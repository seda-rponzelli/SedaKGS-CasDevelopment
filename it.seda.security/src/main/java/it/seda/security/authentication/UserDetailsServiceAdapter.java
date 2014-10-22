/**
 * 
 */
package it.seda.security.authentication;

import javax.servlet.http.HttpServletRequest;

import it.seda.security.domain.Account;
import it.seda.security.domain.UsernameClient;
import it.seda.security.service.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author f.ricci
 *
 */
@Service(value="userDetailsService")
public class UserDetailsServiceAdapter implements UserDetailsService {
	
	@Autowired SecurityService securityService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
//		RequestAttributes attributes=RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request=((ServletRequestAttributes)attributes).getRequest();
//		String IdCliente=getIdClienteFromUrl(request);
		
		//TODO creare account usando anche IdCliente
		
		
		String customerId=(String) resolveRequest().getSession().getAttribute("customerId");
		UsernameClient usernameClient=new UsernameClient(username,customerId);
		
		
		Account account = securityService.getAccountByCustomerUser(usernameClient);
		
		//String customerId=(String) resolveRequest().getSession().getAttribute("customerId");
		//Account account = securityService.getAccountByUserName(username);
		
		if (account==null) {
			//TODO NO I18N
			throw new UsernameNotFoundException("No such user: " + username);
		} else if (account.getAuthorities().isEmpty()) {
			//TODO NO I18N			
			throw new UsernameNotFoundException("User " + username + " has no authorities");
		}

		UserDetailsAdapter user = new UserDetailsAdapter(account);	
		user.setPassword(securityService.findPasswordByCustumerUser(usernameClient));
		
		return user;
	}
	
	protected HttpServletRequest resolveRequest() {
		RequestAttributes attributes=RequestContextHolder.getRequestAttributes();
		return ((ServletRequestAttributes)attributes).getRequest();
	}

}
