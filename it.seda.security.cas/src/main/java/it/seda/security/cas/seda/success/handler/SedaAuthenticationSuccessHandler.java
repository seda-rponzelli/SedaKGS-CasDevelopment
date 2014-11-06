package it.seda.security.cas.seda.success.handler;

import it.seda.security.authentication.UserDetailsAdapter;
import it.seda.security.cas.CASParametersURL;
import it.seda.security.cas.exceptions.ApplicationNotFoundException;
import it.seda.security.cas.exceptions.GenericTicketException;
import it.seda.security.cas.exceptions.UserNotGrantedException;
import it.seda.security.cas.utils.TokenUtils;
import it.seda.security.domain.Application;
import it.seda.security.domain.CustomerApplication;
import it.seda.security.domain.CustomerCodeApplication;
import it.seda.security.domain.Ticket;
import it.seda.security.domain.UsernameClient;
import it.seda.security.service.ManagerService;
import it.seda.security.service.SecurityService;
import it.seda.security.service.TicketService;
import it.seda.security.sign.out.LoginUtils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



public class SedaAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    
	
	private String ID_CLIENTE=CASParametersURL.ID_CLIENTE.getParameterName();
	private String ID_APPLICAZIONE=CASParametersURL.ID_APPLICAZIONE.getParameterName();
	private String ID_TICKET=CASParametersURL.ID_TICKET.getParameterName();
	private String CAS_SESSION=CASParametersURL.CAS_SESSION.getParameterName();
	private String EXCEPTIONS_CONTROLLER_URI="login/exceptions";
	private String APPLICATION_NOT_FOUND="Applicazione non censita : ";
	private String APPLICATION_CUSTOMER_PROBLEMS="Si sono verificati problemi nel recupero delle informazioni legate all'applicazione.";
	private String USER_NOT_GRANTED="Utenza non abilitata al servizio : ";
	private String GENERIC_ERROR="Errore generico durante la generazione del ticket. ";
	private String APPLICATION_LIST="j_seda_cas_application_list";
	private String PARENT_CUSTOMER="j_seda_cas_parent_customer";
	private String DATABASE="DATABASE";
	private String SERVICE="service";
	
	private static final Logger logger = LoggerFactory.getLogger(SedaAuthenticationSuccessHandler.class);
    protected String applicationId;
    protected String customerId;
    protected String urlBack;
    
    @Autowired TicketService ticketService;
    @Autowired SecurityService securityService;
    @Autowired ManagerService managerService;
    @Autowired LoginUtils loginUtils;
    @Autowired TokenUtils tokenUtils;
    
    @Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
    	
    	
    	
    	String applicationCode=(String) request.getSession(false).getAttribute(ID_APPLICAZIONE);
    	try{
    	applicationId = (managerService.selectApplicationIdByName(applicationCode)).getChiavePrimariaDelleApplicazioni();
    	}catch(Exception e){
    		logger.debug("Applicazione "+applicationCode +" non censita." );
    		String message=APPLICATION_NOT_FOUND.concat("applicationCode: "+applicationCode);
    	    response.sendRedirect(EXCEPTIONS_CONTROLLER_URI+"/"+ApplicationNotFoundException.class.getName()+"/"+message);
    	    return;
    	}
    	try{
		customerId=(String) request.getSession(false).getAttribute(ID_CLIENTE);
		CustomerCodeApplication customerCodeApplication = new CustomerCodeApplication(customerId,applicationId);
		urlBack = tokenUtils.setUrlBack(customerCodeApplication);
		//Se abbiamo definito una url back nel file di config. della web app lo usiamo per la redirect
		String service=(String) request.getSession(false).getAttribute(SERVICE);
		if(service!=null&&!service.equals(DATABASE)){
			urlBack=service;
		}
		
		logger.debug("Login completed. ApplicationId= "+applicationId+" .CustomerId= "+customerId+" .UrlBack"+urlBack+"...");
		String username=((UserDetailsAdapter) auth.getPrincipal()).getUsername();
		if (applicationId != null&& customerId!=null&&urlBack!=null) {
			boolean userGranted = tokenUtils.checkUserApplicationId(username,customerId);
			
			List<Application> applicationList=managerService.getAllChildApplications(applicationId);
			HttpSession session=request.getSession(false);
			if(applicationList!=null&&applicationList.size()>0){
				List<Application> oldApplicationList=(List<Application>) session.getAttribute("ApplicationsList");
				session.setAttribute(APPLICATION_LIST,applicationList);
				session.setAttribute(PARENT_CUSTOMER,customerId);
			}
			
			Ticket generatedTicket=ticketService.generate(username, customerId,applicationId);
			if(userGranted&&generatedTicket!=null){
				/*il cas comunica la session con il quale valida utente applicazione*/
				String ticket = generatedTicket.getChiavePrimariaDellaTabellaDeiTicket();
				response.sendRedirect(urlBack+"?"+ID_TICKET+"="+ticket+"&"+CAS_SESSION+"="+session.getId());
			}
			else{
	    		String message=USER_NOT_GRANTED.concat(username).concat("customerId: "+customerId).concat("applicationId "+applicationId);
	    		logger.debug(message);
	    	    response.sendRedirect(EXCEPTIONS_CONTROLLER_URI+"/"+UserNotGrantedException.class.getName()+"/"+message);	
			}
		} else {
			String message=APPLICATION_CUSTOMER_PROBLEMS.concat("customerId: "+customerId).concat("applicationId "+applicationId);
			logger.debug(message);
    	    response.sendRedirect(EXCEPTIONS_CONTROLLER_URI+"/"+ApplicationNotFoundException.class.getName()+"/"+message);
		}
		
    	}catch(Exception e){
    		logger.debug("Generic exception while sending ticker for application  "+applicationId +" and customer "+customerId);
    		String message=GENERIC_ERROR.concat("customerId: "+customerId).concat("applicationId "+applicationId);
    	    response.sendRedirect(EXCEPTIONS_CONTROLLER_URI+"/"+GenericTicketException.class.getName()+"/"+message);
    	}
	}
    
  
        
}
