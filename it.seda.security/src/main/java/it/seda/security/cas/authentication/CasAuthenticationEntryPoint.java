
package it.seda.security.cas.authentication;


import it.seda.security.authentication.UserDetailsAdapter;
import it.seda.security.cas.CASParametersURL;
import it.seda.security.cas.CommonUtils;
import it.seda.security.cas.ServiceProperties;
import it.seda.security.domain.Account;
import it.seda.security.domain.Application;
import it.seda.security.service.ManagerService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;

/**
 * Used by the <code>ExceptionTranslationFilter</code> to commence authentication via the Seda Central
 * Authentication Service (CAS).
 * <p>
 * The user's browser will be redirected to the SEDA CAS enterprise-wide login page.
 * This page is specified by the <code>loginUrl</code> property. Once login is complete, the CAS login page will
 * redirect to the page indicated by the <code>service</code> property. The <code>service</code> is a HTTP URL
 * belonging to the current application. The <code>service</code> URL is monitored by the {@link CasAuthenticationFilter},
 * which will validate the CAS login was successful.
 *
 * @author f.ricci
 */
public class CasAuthenticationEntryPoint implements AuthenticationEntryPoint, InitializingBean {

	
	
	
	
	private String CAS_SESSION=CASParametersURL.CAS_SESSION.getParameterName();
	private String ID_CLIENTE=CASParametersURL.ID_CLIENTE.getParameterName();
	private String ID_APPLICAZIONE=CASParametersURL.ID_APPLICAZIONE.getParameterName();
	private String ID_TICKET=CASParametersURL.ID_TICKET.getParameterName();
	
	
	private ServiceProperties serviceProperties;
	
	private static final Logger logger = LoggerFactory.getLogger(CasAuthenticationEntryPoint.class);

    private String loginUrl;
    private String redirectUrl ="";
    private String urlEncodedService = "";
    private String applicationId = "";
    private String customerId="";

    public void afterPropertiesSet() throws Exception {
        Assert.hasLength(this.loginUrl, "loginUrl must be specified");
        Assert.notNull(this.serviceProperties, "serviceProperties must be specified");
        Assert.notNull(this.serviceProperties.getService(),"serviceProperties.getService() cannot be null.");
    }

    public final void commence(final HttpServletRequest servletRequest, final HttpServletResponse response,
        final AuthenticationException authenticationException) throws IOException, ServletException {
    	logger.debug("Access denied, entering in CAS authentication entry point...");
    	urlEncodedService = createServiceUrl(servletRequest, response);
        redirectUrl = createRedirectUrl(urlEncodedService);
        logger.debug("Redirect URL: "+redirectUrl);
        if(redirectUrl==null){
        	logger.debug("Cas url is null!. Check if you have defined it in serviceProperties.");
        }
        applicationId = getApplicationId(serviceProperties);
        logger.debug("Application id: "+applicationId);
        preCommence(servletRequest, response);
        submitTicket(servletRequest,response);
    }


	/**
     * Constructs a new Service Url.  The default implementation relies on the CAS client to do the bulk of the work.
     * @param request the HttpServletRequest
     * @param response the HttpServlet Response
     * @return the constructed service url.  CANNOT be NULL.
     */
    protected String createServiceUrl(final HttpServletRequest request, final HttpServletResponse response) {
        return CommonUtils.constructServiceUrl(null, response, this.serviceProperties.getService(), null, this.serviceProperties.getArtifactParameter(), true);
    }

    /**
     * Constructs the Url for Redirection to the CAS server.  Default implementation relies on the CAS client to do the bulk of the work.
     *
     * @param serviceUrl the service url that should be included.
     * @return the redirect url.  CANNOT be NULL.
     */
    protected String createRedirectUrl(final String serviceUrl) {
        return CommonUtils.constructRedirectUrl(this.loginUrl, this.serviceProperties.getServiceParameter(), serviceUrl, this.serviceProperties.isSendRenew(), false);
    }

    /**
     * Template method for you to do your own pre-processing before the redirect occurs.
     *
     * @param request the HttpServletRequest
     * @param response the HttpServletResponse
     */
    protected void preCommence(final HttpServletRequest request, final HttpServletResponse response) {

    }

    /**
     * The enterprise-wide CAS login URL. Usually something like
     * <code>https://www.mycompany.com/cas/login</code>.
     *
     * @return the enterprise-wide CAS login URL
     */
    public final String getLoginUrl() {
        return this.loginUrl;
    }

    public final ServiceProperties getServiceProperties() {
        return this.serviceProperties;
    }

    public final void setLoginUrl(final String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public final void setServiceProperties(final ServiceProperties serviceProperties) {
        this.serviceProperties = serviceProperties;
    }

    /* Metodo per ottenere l'Id della applicazione */
    protected String getApplicationId (ServiceProperties serviceProperties) {
    	String applicationName  = serviceProperties.getApplicationName();
    	return applicationName;
    	/*
    	Application application = null;
    	try {
    		application = managerService.selectApplicationIdByName(applicationName);	
		} catch (Exception e) {
			logger.error("Applicazione: " +applicationName +" non censita all'interno della tabella Applications");
			logger.error(e.getMessage());
		}
    	if (application != null) {	
    		return application.getChiavePrimariaDelleApplicazioni();	
    	} 
    	return "";
    	*/
    }
    
    /* Metodo per concatenare l'�Id della applicazione alla Url di redirect */ 
    protected String concatApplicationIdToUrl (String applicationId,String customerId) {
    	logger.debug("Url di redirect: " +redirectUrl + "&"+ID_APPLICAZIONE+"=" +applicationId+ "&"+ID_CLIENTE+"=" +customerId);
		return redirectUrl = redirectUrl + "&"+ID_APPLICAZIONE+"=" +applicationId+ "&"+ID_CLIENTE+"=" +customerId;
	}


//    private void saveApplicationId(HttpServletRequest servletRequest) {
//	
//    	RestTemplate restTemplate = new RestTemplate();
//
//    	restTemplate.put(urlEncodedService+"/casws/"+applicationId, applicationId);
//		
//	}
    
    protected void submitTicket(HttpServletRequest servletRequest,HttpServletResponse response) throws IOException {
		HttpSession session=servletRequest.getSession();
		logger.debug("Looking for Ticket parameter in request");
    	String ticket = (String) session.getAttribute(ID_TICKET);	
    	if (ticket== null)  {
    		String applicationCustomerURl=servletRequest.getRequestURL().toString();
    		customerId=getCustomerIdFromRequest(servletRequest);
    	    logger.debug(ID_APPLICAZIONE +"="+applicationId + ID_CLIENTE+"="+customerId +".");
    	    logger.debug("Ticket not found....preform CAS redirect at URL "+concatApplicationIdToUrl(applicationId,customerId));
    	    String casSessionId=(String) session.getAttribute(CAS_SESSION);
    	    //Se dispongo di una sessione di autenticazione del cas la imposto
    	    if(casSessionId!=null){
    	    	/*Se il cas ha fornito una sessione di autenticazione la utilizziamo la redirect
    	    	 * Questa funzionalita per il momento non serve, era prevista per il recuper di informazioni
    	    	 * di sessone con una connessione in GET. La sendredirect preserva di suo la sessione
    	    	 * che a questo punto dovrebbe gi� essere salvata nel browser richiedente.*/
    	    response.setHeader("SET-COOKIE", "JSESSIONID=" + casSessionId + "; HttpOnly");
    	    }
    		response.sendRedirect(concatApplicationIdToUrl(applicationId,customerId));
    		return;
    	}
    	
    	logger.debug("Ticket found. Ticket= "+ticket);
    	logger.debug("Calling CAS cas web service...." );
    	UserDetailsAdapter userDetailsAdapter = getUserBean(ticket);
    	logger.debug("Account user found for username " +userDetailsAdapter.getUsername());
    	session.removeAttribute(ID_TICKET);
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            // in here, get your principal, and populate the auth object with 
            // the right authorities
        	logger.debug("Building authentication....");
        	UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetailsAdapter, userDetailsAdapter.getPassword(),userDetailsAdapter.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
       }
       logger.debug("Authentication builded, redirecting to  "+servletRequest.getRequestURL().toString());
       response.sendRedirect(servletRequest.getRequestURL().toString());
     
	}

	private UserDetailsAdapter getUserBean(String ticket) {	
		RestTemplate restTemplate = new RestTemplate();
		String webServiceURL=null;
		if(redirectUrl.lastIndexOf("?")==1){
		webServiceURL=redirectUrl+"/casws/"+ticket+".json";
		}else{
		String [] splitURL=	redirectUrl.split("\\?");
		webServiceURL=splitURL[0]+"/casws/"+ticket+".json"+"?"+splitURL[1];
		}
    	com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
		objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		objectMapper.configure(MapperFeature.USE_ANNOTATIONS, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		messageConverter.setObjectMapper(objectMapper);
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(messageConverter);
		restTemplate.setMessageConverters(messageConverters);
    	restTemplate.getForObject(webServiceURL, Account.class);
    	Account account=restTemplate.getForObject(webServiceURL, Account.class);
    	UserDetailsAdapter userDetailsAdapter=new UserDetailsAdapter(account);
		return userDetailsAdapter;
	}
	
	/*
	 * Il metodo main pu� essere utile in caso si volesse testare le funzionalit� del cas ws per il recupero 
	 * dell'account utente.
	 * 
	public static void main(String args[]){
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.UNWRAP_ROOT_VALUE, true);
		
//		MappingJacksonHttpMessageConverter messageConverter = new MappingJacksonHttpMessageConverter();
//		messageConverter.setObjectMapper(mapper);
//		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//		messageConverters.add(messageConverter);
//		restTemplate.setMessageConverters(messageConverters);
    	String webServiceURL="http://localhost:8080/it.seda.security.cas/login/casws/TICKET.json";
//    	restTemplate.getForObject(webServiceURL, Account.class);
//    	Account model=restTemplate.getForObject(webServiceURL, Account.class);
//    	System.out.println("Name"+model.getExpiration());
		com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
		objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		objectMapper.configure(MapperFeature.USE_ANNOTATIONS, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		messageConverter.setObjectMapper(objectMapper);
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(messageConverter);
		restTemplate.setMessageConverters(messageConverters);
    	//String webServiceURL="http://localhost:8080/it.seda.security.cas/login/casws/TICKET.json";
    	restTemplate.getForObject(webServiceURL, Account.class);
    	Account model=restTemplate.getForObject(webServiceURL, Account.class);
    	System.out.println("Name"+model.getExpiration());
	}
	*/
	
	private String getCustomerIdFromRequest(HttpServletRequest request){
		 
		customerId=(String) request.getSession().getAttribute(ID_CLIENTE);
		if(customerId==null){
			logger.debug("missing request parameter customerId");
		}
		return customerId;
	}
	
	
}


