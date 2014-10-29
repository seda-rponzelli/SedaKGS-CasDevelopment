package it.seda.security.cas.seda.success.handler;

import it.seda.security.authentication.UserDetailsAdapter;
import it.seda.security.cas.CASParametersURL;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



public class SedaAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    
	
	private String ID_CLIENTE=CASParametersURL.ID_CLIENTE.getParameterName();
	private String ID_APPLICAZIONE=CASParametersURL.ID_APPLICAZIONE.getParameterName();
	private String ID_TICKET=CASParametersURL.ID_TICKET.getParameterName();
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(SedaAuthenticationSuccessHandler.class);
    protected String applicationId;
    protected String customerId;
    protected String urlBack;
    
    @Autowired TicketService ticketService;
    @Autowired SecurityService securityService;
    @Autowired ManagerService managerService;
    @Autowired LoginUtils loginUtils;
    
    @Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		// initialization logic after login
		// quì sono stato autenticato e possiamo accedere alle informazioni
		// dell'authentication tra cui i ruoli e lo username
		// se allo username autenticato corrisponde l'id dell'applicazione
		// inviamo una redirect all'applicazione che aspetta il token
		// altrimenti inviamo la request al cas
		//String username = ((UserDetailsAdapter) auth.getPrincipal()).getFirstName();
		applicationId=(String) request.getSession().getAttribute(ID_APPLICAZIONE);
		customerId=(String) request.getSession().getAttribute(ID_CLIENTE);
		CustomerCodeApplication customerCodeApplication = new CustomerCodeApplication(customerId,applicationId);
		urlBack = setUrlBack(customerCodeApplication);
		logger.debug("Login completed. ApplicationId= "+applicationId+" .CustomerId= "+customerId+" .UrlBack"+urlBack+"...");
		String username=((UserDetailsAdapter) auth.getPrincipal()).getUsername();
		//String password=((UserDetailsAdapter) auth.getPrincipal()).getPassword();
		if (applicationId != null&& customerId!=null&&urlBack!=null) {
			boolean userGranted = checkUserApplicationId(username);
			
			List<Application> applicationList=managerService.getAllChildApplications(applicationId);
			if(applicationList!=null&&applicationList.size()>0){
				loginUtils.sendLoginRequest(username,customerId,applicationList);
			}
			
			Ticket generatedTicket=ticketService.generate(username, customerId,applicationId);
			if(userGranted&&generatedTicket!=null){
				String ticket = generatedTicket.getChiavePrimariaDellaTabellaDeiTicket();
				response.sendRedirect(urlBack+"?"+ID_TICKET+"="+ticket);
			}
			else{
				response.sendRedirect("/errors?error=");
				
			}
		} else {
			response.sendRedirect("/welcome");
		}
	}
    
    /*Controlla se l'utente-cliente è censito controllando se è valorizzato il codiceFiscale*/
    protected boolean checkUserApplicationId(String username){
    	UsernameClient usernameClient = new UsernameClient(username,customerId);
    	String  codiceFiscale="";
    	try{
    		codiceFiscale=securityService.getCodiceFiscaleFromUsernameClient(usernameClient);
    	}catch(Exception e){
    		logger.debug("Errors occurred while checking esername "+username+" and customerId "+ customerId);
    		return false;
    	}
    	if(codiceFiscale!=null&&!codiceFiscale.isEmpty()){
    		return true;
    	}
    	return false;
    }
	
    /*va presa dal DB*/
    protected String setUrlBack(CustomerApplication customerApplication){
        String urlBack=securityService.findURLBackByCustumerApplication(customerApplication);
        return  urlBack;	
		//return "http://localhost:8080/it.seda.example.springProject";	
    }
    
    protected String setUrlBack(CustomerCodeApplication customerCodeApplication){
        String urlBack=securityService.findURLBackByCustumerCodeApplication(customerCodeApplication);
        return  urlBack;	
		//return "http://localhost:8080/it.seda.example.springProject";	
    }
        
}
