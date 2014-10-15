package it.seda.security.cas.seda.success.handler;

import it.seda.security.authentication.UserDetailsAdapter;
import it.seda.security.domain.Application;
import it.seda.security.domain.Ticket;
import it.seda.security.service.ManagerService;
import it.seda.security.service.TicketService;

import java.io.IOException;
import java.security.Principal;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.client.RestTemplate;


public class SedaAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    
    
    protected String applicationId;
    protected String urlBack;
    
    @Autowired TicketService ticketService;
   
    
    @Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		// initialization logic after login
		// qu� sono stato autenticato e possiamo accedere alle informazioni
		// dell'authentication tra cui i ruoli e lo username
		// se allo username autenticato corrisponde l'id dell'applicazione
		// inviamo una redirect all'applicazione che aspetta il token
		// altrimenti inviamo la request al cas
		//String username = ((UserDetailsAdapter) auth.getPrincipal()).getFirstName();
    	
		applicationId=(String) request.getSession().getAttribute("applicationId");
		urlBack = setUrlBack(applicationId);
		//String ticket = "TICKET";
		
		
		
		String username=((UserDetailsAdapter) auth.getPrincipal()).getUsername();
		String password=((UserDetailsAdapter) auth.getPrincipal()).getPassword();
		
		//TODO recupera custumer_ID  dallo username
		//TODO verifica che l'applicazioneId � abilitata per l'utente e recupera l'urlback dal customer_Id e application_Id
		
		
		// se applicationnId � valorizzato la richiesta di autenticazione
		// avviene da un'applicazione altrimenti da wb
		if (applicationId != null) {
			boolean userGranted = checkUserApplicationId(username);
			Ticket generatedTicket=ticketService.generate(username, applicationId);
			String ticket = generatedTicket.getId();
			if(userGranted){
				response.sendRedirect(urlBack+"?ticket="+ticket);
				//RestTemplate restTemplate=new RestTemplate();
				//restTemplate.getForObject(urlBack, String.class);
	
			}else{
				response.sendRedirect("/errors?error=");
				
			}
		//} else if (auth.getAuthorities().contains(getCasRolesFromDb())) {
			// TO_DO
			// la lista degli utenti abilitati al cas pu� essere modificata da db??
			//response.sendRedirect(cas);
		} else {
			response.sendRedirect("/welcome");
		}
	}
    
    protected boolean checkUserApplicationId(String username){
    	return true;
    }
	
    /*va presa dal DB*/
    protected String setUrlBack(String applicationId){
    	
    
		return "http://localhost:8080/it.seda.example.springProject";	
    }
        
}
