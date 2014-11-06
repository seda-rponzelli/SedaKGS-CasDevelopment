package it.seda.security.cas.controller;

import java.util.List;
import it.seda.security.authentication.UserDetailsAdapter;
import it.seda.security.cas.CASParametersURL;
import it.seda.security.cas.exceptions.ApplicationNotAccessibleException;
import it.seda.security.cas.exceptions.ApplicationNotFoundException;
import it.seda.security.cas.exceptions.UserNotGrantedException;
import it.seda.security.cas.utils.TokenUtils;
import it.seda.security.domain.Application;
import it.seda.security.domain.CustomerCodeApplication;
import it.seda.security.domain.Ticket;
import it.seda.security.service.ManagerService;
import it.seda.security.service.SecurityService;
import it.seda.security.service.TicketService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	private String ID_CLIENTE = CASParametersURL.ID_CLIENTE.getParameterName();
	private String ID_APPLICAZIONE = CASParametersURL.ID_APPLICAZIONE
			.getParameterName();
	private String ID_TICKET = CASParametersURL.ID_TICKET.getParameterName();
	private String APPLICATION_LIST = "j_seda_cas_application_list";
	private String PARENT_CUSTOMER = "j_seda_cas_parent_customer";
	private String applicationId;
	private String customerId;
	private String urlBack;
	private String APPLICATION_NOT_ACCESSIBLE = "Applicazione non censita : ";
	private String APPLICATION_CUSTOMER_PROBLEMS = "Si sono verificati problemi nel recupero delle informazioni legate all'applicazione.";
	private String USER_NOT_GRANTED = "Utenza non abilitata al servizio : ";

	@Autowired
	TicketService ticketService;
	@Autowired
	SecurityService securityService;
	@Autowired
	ManagerService managerService;
	@Autowired
	TokenUtils tokenUtils;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView def(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// Se l'utente è già authenticato eseguiamo procedura di autenticazione

		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication()
						.isAuthenticated()
				&& !SecurityContextHolder.getContext().getAuthentication()
						.getAuthorities()
						.contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"))) {
			return new ModelAndView(tokenAuthentication(request, response,
					SecurityContextHolder.getContext().getAuthentication()));

		} else {
			return new ModelAndView("login");
		}
	
	}

	private String tokenAuthentication(HttpServletRequest request,
			HttpServletResponse response, Authentication auth) throws Exception {
		String applicationCode = (String) request.getSession().getAttribute(ID_APPLICAZIONE);
		applicationId = (managerService.selectApplicationIdByName(applicationCode)).getChiavePrimariaDelleApplicazioni();
		/*
		 * Se lapplicazione di cui chiediamo accesso non ha parent si deve fare
		 * la login
		 */
		if (managerService.hasParent(applicationCode) == 0) {
			return "login";
		}

		customerId = (String) request.getSession().getAttribute(ID_CLIENTE);
		/*
		 * Se lapplicazione di cui chiediamo accesso ha parent vediamo se è
		 * nella lista delle applicazioni del parebt
		 */
		if (!isAccessible(request, applicationId, customerId)) {
			String message = APPLICATION_NOT_ACCESSIBLE.concat("ApplicationId  " + applicationId).concat("  CustomerId " + customerId);
			logger.debug(message);
			return "login";
		}
		CustomerCodeApplication customerCodeApplication = new CustomerCodeApplication(customerId, applicationId);
		urlBack = tokenUtils.setUrlBack(customerCodeApplication);
		logger.debug("Login completed. ApplicationId= " + applicationId+ " .CustomerId= " + customerId + " .UrlBack" + urlBack + "...");
		String username = ((UserDetailsAdapter) auth.getPrincipal()).getUsername();
		if (applicationId != null && customerId != null && urlBack != null) {
			boolean userGranted = tokenUtils.checkUserApplicationId(username,customerId,applicationCode);
			Ticket generatedTicket = ticketService.generate(username,
					customerId, applicationId);
			if (userGranted && generatedTicket != null) {
				String ticket = generatedTicket
						.getChiavePrimariaDellaTabellaDeiTicket();
				return "redirect:" + urlBack + "?" + ID_TICKET + "=" + ticket;
			} else {
				String message = USER_NOT_GRANTED.concat(username)
						.concat("customerId: " + customerId)
						.concat("applicationId " + applicationId);
				logger.debug(message);
				throw new UserNotGrantedException(message);
			}
		} else {
			String message = APPLICATION_CUSTOMER_PROBLEMS.concat(
					"customerId: " + customerId).concat(
					"applicationId " + applicationId);
			logger.debug(message);
			throw new ApplicationNotFoundException(message);
		}
	}

	private boolean isAccessible(HttpServletRequest request,
			String applicationId, String customerId) {
		HttpSession session = request.getSession(false);
		@SuppressWarnings("unchecked")
		List<Application> applicationList = (List<Application>) request
				.getSession().getAttribute(APPLICATION_LIST);
		String parentCustomer = (String) session.getAttribute(PARENT_CUSTOMER);
		boolean found = false;
		if (customerId.equals(parentCustomer) && applicationList != null) {
			for (Application application : applicationList) {
				if (application.getChiavePrimariaDelleApplicazioni().equals(applicationId)) {
					found = true;
				}
			}
		}
		return found;
	}
	
	
	


}
