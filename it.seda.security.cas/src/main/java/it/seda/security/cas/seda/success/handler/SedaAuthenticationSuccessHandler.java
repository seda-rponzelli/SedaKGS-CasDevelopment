package it.seda.security.cas.seda.success.handler;

import it.seda.security.authentication.UserDetailsAdapter;
import it.seda.security.cas.authentication.CasAuthenticationEntryPoint;
import it.seda.security.domain.Application;
import it.seda.security.domain.CustomerApplication;
import it.seda.security.domain.CustomerCodeApplication;
import it.seda.security.domain.Ticket;
import it.seda.security.service.ManagerService;
import it.seda.security.service.SecurityService;
import it.seda.security.service.TicketService;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.client.RestTemplate;


public class SedaAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    
	private static final Logger logger = LoggerFactory.getLogger(SedaAuthenticationSuccessHandler.class);
    protected String applicationId;
    protected String customerId;
    protected String urlBack;
    
    @Autowired TicketService ticketService;
    @Autowired SecurityService securityService;
   
    
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
    	
		applicationId=(String) request.getSession().getAttribute("applicationId");
		
		customerId=(String) request.getSession().getAttribute("customerId");
		
		//CustomerApplication customerApplication=new CustomerApplication("","", "",new Date(), "",new Date(),applicationId,customerId);
		//urlBack = setUrlBack(customerApplication);
		
		
		CustomerCodeApplication customerCodeApplication = new CustomerCodeApplication(customerId,applicationId);
		urlBack = setUrlBack(customerCodeApplication);
		//String ticket = "TICKET";
		logger.debug("Login completed. ApplicationId= "+applicationId+" .CustomerId= "+customerId+" .UrlBack"+urlBack+"...");
		
		String username=((UserDetailsAdapter) auth.getPrincipal()).getUsername();
		String password=((UserDetailsAdapter) auth.getPrincipal()).getPassword();
		
		//TODO recupera custumer_ID  dallo username
		//TODO verifica che l'applicazioneId è abilitata per l'utente e recupera l'urlback dal customer_Id e application_Id
		
		
		// se applicationnId è valorizzato la richiesta di autenticazione
		// avviene da un'applicazione altrimenti da wb
		if (applicationId != null&& customerId!=null) {
			boolean userGranted = checkUserApplicationId(username);
			Ticket generatedTicket=ticketService.generate(username, applicationId);
			String ticket = generatedTicket.getChiavePrimariaDellaTabellaDeiTicket();
			if(userGranted){
				response.sendRedirect(urlBack+"?ticket="+ticket);
				//RestTemplate restTemplate=new RestTemplate();
				//restTemplate.getForObject(urlBack, String.class);
	
			}else{
				response.sendRedirect("/errors?error=");
				
			}
		//} else if (auth.getAuthorities().contains(getCasRolesFromDb())) {
			// TO_DO
			// la lista degli utenti abilitati al cas può essere modificata da db??
			//response.sendRedirect(cas);
		} else {
			response.sendRedirect("/welcome");
		}
	}
    
    protected boolean checkUserApplicationId(String username){
    	return true;
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
