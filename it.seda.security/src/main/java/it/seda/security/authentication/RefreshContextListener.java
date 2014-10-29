package it.seda.security.authentication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import it.seda.security.domain.Account;
import it.seda.security.domain.Customer;
import it.seda.security.domain.CustomerUser;
import it.seda.security.domain.MutableAccount;
import it.seda.security.domain.UsernameClient;
import it.seda.security.service.ManagerService;
import it.seda.security.service.SecurityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * @author f.ricci
 *
 */
@Component("securityRefreshContextListener")
public class RefreshContextListener implements ApplicationListener<ContextRefreshedEvent> {
	
	private Logger logger = LoggerFactory.getLogger(RefreshContextListener.class);	
	
	public final static String ADMIN_USER="admin";
	public final static String ADMIN_FIRST_NAME="administartor";
	public final static String ADMIN_LAST_NAME="admin";
	public final static String ADMIN_EMAIL="administrator@administrator.it";
	public final static String CAS_SECURITY="CAS_SECURITY";
	public final static String EXPIRATION="2099-12-31";
	public final static String LAST_ATTEMP="2000-01-01";
	//public final static String ADMIN_USER_KEY="c78dfc0f-968c-486e-bb2d-31820bcfba22";
	
	
	@Autowired private SecurityService securityService; 
	@Autowired private ManagerService managerService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		/*
		String customerId=null;
		Account account=null;
		List<Customer> customerList=managerService.listCustomer();
		UsernameClient usernameClient=new UsernameClient();
		if(customerList!=null&&customerList.size()>0){
		for (Customer customer : customerList) {
			usernameClient.setUsername(ADMIN_USER.concat(customer.getCodiceCliente()));
			usernameClient.setCustomerId(customer.getCodiceCliente());
		    account = securityService.getAccountByCustomerUser(usernameClient);
		if (account==null) {
			logger.warn("administrator account not found for client "+customer.getCodiceCliente()+".... trying to create it. "); //TODO no i18n
			MutableAccount accountto=new MutableAccount();
			accountto.init();
			accountto.setChiavePrimariaDelCliente(UUID.randomUUID().toString());
			accountto.setChiavePrimariaTabellaUsers(UUID.randomUUID().toString());
			accountto.setUsername(ADMIN_USER.concat(customer.getCodiceCliente()));
			accountto.setChiavePrimariaDellaTabellaGruppi(UUID.randomUUID().toString());
			accountto.setFirstName(ADMIN_FIRST_NAME);
			accountto.setLastName(ADMIN_LAST_NAME);			
			accountto.setEmail(ADMIN_EMAIL);
			accountto.setOperatoreInserimento(CAS_SECURITY);
			accountto.setOperatoreUltimaVariazione(CAS_SECURITY);
			accountto.setEnabled(true);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				accountto.setDataScadenzaCredenziali(formatter.parse(EXPIRATION));
				accountto.setDataScadenzaUser(formatter.parse(EXPIRATION));
				accountto.setLastAttempt(formatter.parse(LAST_ATTEMP));
			} catch (ParseException e) {
				logger.error("problem while insert administrator credential expiration...");
				e.printStackTrace();
			}
			securityService.insertAccount(accountto,customer);
			logger.warn("administrator account created..."); //TODO no i18n			
		} else {
			logger.warn("administrator account found"); //TODO no i18n
		}
		
		}
		
		
		}//abbiamo finito l'inserimento degli utenti mministratori per ogni cliente
		*/
	}
	
	
	

}
