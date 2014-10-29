/**
 * 
 */
package it.seda.security.cas.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.seda.security.authentication.UserDetailsAdapter;
import it.seda.security.domain.Account;
import it.seda.security.domain.Authority;
import it.seda.security.domain.Ticket;
import it.seda.security.service.SecurityService;
import it.seda.security.service.TicketService;
import it.seda.security.sign.out.LogoutUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;















import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lmontesi
 *
 */
@Controller
//@RequestMapping("/login/casws")
public class CasWebService {
	
	@Autowired TicketService ticketService;
	@Autowired SecurityService securityService;
	@Autowired private LogoutUtils logoutUtils;
	
	@RequestMapping(value="/login/casws/{ticket}", method = RequestMethod.GET)
	public String getUserDetailsAdapter(@PathVariable String ticket, ModelMap model) {
	
		Account account=null;
		try{
			account=securityService.getAccountByTicket(ticket);
		}catch(Exception e){
			account=null;
		}
		//model.addAttribute("accountJson", account);
		model.addAttribute("Account", account);
		return null;
	}

//	@RequestMapping(value="{applicationId}", method = RequestMethod.PUT)
//	public @ResponseBody String saveApplicationId(@PathVariable String applicationId, HttpServletRequest servletRequest) {
//		HttpSession session = servletRequest.getSession();
//		session.setAttribute("applicationId", applicationId);
//		return "";
//	}
//	
	
	@RequestMapping(value="/login/casws/logout/{ticketId}", method = RequestMethod.GET)
	public String performSingleSignOut(@PathVariable String ticketId,ModelMap model,HttpServletRequest request) {
	List<Ticket> ticketList= ticketService.getAllUserApplicationTickets(ticketId);
	logoutUtils.performCASLogout(ticketList);	
	
	HttpSession session=request.getSession();
	session.invalidate();
//	SecurityContext context = SecurityContextHolder.getContext();
//    context.setAuthentication(null);
//    SecurityContextHolder.clearContext();
    
    
	return "logout";
	}
	

	
}
