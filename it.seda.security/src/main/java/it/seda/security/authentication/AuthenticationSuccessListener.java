package it.seda.security.authentication;

import javax.servlet.http.HttpServletRequest;

import it.seda.security.domain.Account;
import it.seda.security.domain.MutableAccount;
import it.seda.security.domain.UsernameClient;
import it.seda.security.service.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * When a user is correctly authenticated the below listener will inform the user 
 * who for reset it’s authentication failure counters.
 * 
 * @author f.ricci
 *
 */
@Component("authenticationSuccessListener")
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent>{

	@Autowired private SecurityService securityService;

	public void onApplicationEvent(AuthenticationSuccessEvent event) {

		String username = event.getAuthentication().getName();
		
		
		
		String customerId=(String) resolveRequest().getSession().getAttribute("customerId");
		UsernameClient usernameClient=new UsernameClient(username,customerId);
		Account account = securityService.getAccountByCustomerUser(usernameClient);

		
		if (account!=null) {
			String codiceFiscale=securityService.getCodiceFiscaleFromUsernameClient(usernameClient);
			MutableAccount mutableAccount=new MutableAccount();
			mutableAccount.init();
			short attempts=(short) 0;
			mutableAccount.setAttempts(attempts);
			mutableAccount.setUsername(username);
			mutableAccount.setCodiceFiscale(codiceFiscale);
			securityService.restoreAttempts(mutableAccount);
		}

	}
	
	
	protected HttpServletRequest resolveRequest() {
		RequestAttributes attributes=RequestContextHolder.getRequestAttributes();
		return ((ServletRequestAttributes)attributes).getRequest();
	}
}
