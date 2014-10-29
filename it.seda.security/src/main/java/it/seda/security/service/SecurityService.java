/**
 * 
 */
package it.seda.security.service;

import it.seda.jdbc.commons.DataPage;
import it.seda.jdbc.commons.DefaultDataPage;
import it.seda.jdbc.ibatis.RowBoundsHelper;
import it.seda.security.authentication.RefreshContextListener;
import it.seda.security.authentication.UserDetailsAdapter;
import it.seda.security.domain.Account;
import it.seda.security.domain.Application;
import it.seda.security.domain.Customer;
import it.seda.security.domain.CustomerApplication;
import it.seda.security.domain.CustomerCodeApplication;
import it.seda.security.domain.CustomerUser;
import it.seda.security.domain.Funzione;
import it.seda.security.domain.LegameFunzione;
import it.seda.security.domain.LegameGruppo;
import it.seda.security.domain.Modulo;
import it.seda.security.domain.MutableAccount;
import it.seda.security.domain.Group;
import it.seda.security.domain.GroupMember;
import it.seda.security.domain.Signon;
import it.seda.security.domain.SottoFunzione;
import it.seda.security.domain.UsernameClient;
import it.seda.security.service.exceptions.DuplicateAccountException;
import it.seda.security.service.exceptions.ExperedTicketException;
import it.seda.security.persistence.ManagerMapper;
import it.seda.security.persistence.SecurityMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author f.ricci
 * 
 */
@Service
@Transactional
public class SecurityService {

	private Logger logger = LoggerFactory.getLogger(SecurityService.class);

	@Autowired
	private SecurityMapper securityMapper;
	@Autowired
	private ManagerMapper managerMapper;
	@Autowired
	private ShaPasswordEncoder passwordEncoder;
	@Autowired
	private SaltSource saltSource;

	@Transactional(readOnly = true)
	public Account getAccountByUserName(String username) {
		return securityMapper.getAccountByUsername(username);
	}

	@Transactional(readOnly = true)
	public MutableAccount getMutableAccountByUserName(String username) {
		return securityMapper.getMutableAccountByUsername(username);
	}

	@Transactional(readOnly = true)
	public String findPasswordByUsername(String username) {
		return securityMapper.findPasswordByUsername(username);
	}

	@Transactional(readOnly = true)
	public String findPasswordByCustumerUser(UsernameClient usernameClient) {
		return securityMapper.findPasswordByCustumerUser(usernameClient);
	}

	@Transactional(readOnly = true)
	public String findURLBackByCustumerApplication(
			CustomerApplication customerApplication) {
		return securityMapper
				.findURLBackByCustumerApplication(customerApplication);
	}
	
	@Transactional(readOnly = true)
	public String findURLBackByCustumerCodeApplication(
			CustomerCodeApplication customerCodeApplication) {
		return securityMapper
				.findURLBackByCustumerCodeApplication(customerCodeApplication);
	}
	

	public void reportLoginFailure(String username) {
		securityMapper.loginFailure(username);
	}

	public void restoreAttempts(MutableAccount mutableAccount) {
		securityMapper.restoreAttempts(mutableAccount);
	}

	public void insertAccount(MutableAccount mutable,Customer customer) {
		if (securityMapper.getAccountByUsername(mutable.getUsername()) != null) {
			throw new DuplicateAccountException(mutable.getUsername());
		}
		// INSERIMENTO SEPWRDTB
		Signon signon = new Signon();
		signon.setChiavePrimariaTabellaUsers(mutable
				.getChiavePrimariaTabellaUsers());
		signon.setChiaveTabellaDellePasswordDellUtenza(UUID.randomUUID()
				.toString());
		signon.setOperatoreUltimaVariazione("CAS_SECURITY");
		signon.setPenultimaPasswordValidaDellUtenza(" ");
		signon.setUltimaPasswordValidaDellUtenza(" ");
		signon.setOperatoreInserimento("CAS_SECURITY");

		// SALT PASSWORD
		Account unAccount = new Account();
		unAccount.setUsername(mutable.getUsername());
		Object salt = saltSource.getSalt(new UserDetailsAdapter(unAccount));
		signon.setPasswordValidaDellUtenza(passwordEncoder.encodePassword(
				mutable.getUsername(), salt));

		// CUSTOMER SEDA SECUSTTB
//		Customer customer = new Customer(UUID.randomUUID().toString(), "SEDA",
//				"SEDA DEFAULT CUSTOMER", "N", "CAS_SECURITY", new Date(),
//				"CAS_SECURITY", new Date());

		// DEFINIZIONE GRUPPO AMMINISTRATORI SEGRUPTB
		Group group = new Group(UUID.randomUUID().toString(), "START".concat(customer.getCodiceCliente()),
				"GRUPPO DEGLI AMMINISTRATORI", "CAS_SECURITY", new Date(),
				"CAS_SECURITY", new Date(), customer.getChiavePrimariaCliente());

		// DEFINIZIONE CUSTUMER_USER UTEC SEUTECTB
		CustomerUser cu = new CustomerUser(UUID.randomUUID().toString(),
				mutable.getOperatoreInserimento(),
				mutable.getDataInserimento(),
				mutable.getOperatoreUltimaVariazione(),
				mutable.getDataUltimaVariazione(),
				customer.getChiavePrimariaCliente(),
				mutable.getUsername(),
				mutable.getCodiceFiscale());

		// GROUP_MEMBER SEGRUUTB
		GroupMember gm = new GroupMember();
		gm.init();
		gm.setChiavePrimariaDellaTabellaGruppi(group
				.getChiavePrimariaDellaTabellaGruppi());
		gm.setChiavePrimariaDellaTabellaUtentiClienti(cu
				.getChiaveTabellaRelazioneUserCliente());
		gm.setChiavePrimariaTabellaGruppiUtenti(UUID.randomUUID().toString());
		gm.setDataInserimento(mutable.getDataInserimento());
		gm.setDataUltimaVariazione(mutable.getDataUltimaVariazione());
		gm.setOperatoreInserimento(mutable.getOperatoreInserimento());
		gm.setOperatoreUltimaVariazione(mutable.getOperatoreUltimaVariazione());

		try {
			//SEUSERTB
			securityMapper.insertAccount(mutable);
			// DEFAULT CUSTUMER_INIZIO SECUSTTB
			//managerMapper.insertCustomer(customer);
			// DEFAULT CUSTUMER_FINE SEUTECTB
			managerMapper.insertCustomerUser(cu);

			// DEFAULT GROUP INIZIO
			securityMapper.insertGroup(group);
			// DEFAULT GROUP FINE
			securityMapper.insertGroupMember(gm);
			securityMapper.insertSignon(signon);
			securityMapper.updateCredentialsExpiration(mutable.getUsername());

			// ///////////////////////////////
			// INSERT AUTHORITIES FIELDS, LEGAME FUNZIONE RUOLI, LEGAME GRUPPO
			// FUNZIONI
			// ///////////////////////////////
			// APPLICATION SEAPLLTB
			Application application = new Application(UUID.randomUUID()
					.toString(), "SPRIGPROJECT","Applicazione it.seda.example.springProject","NSE",
					"CAS_SECURITY", new Date(), "CAS_SECURITY", new Date());
			managerMapper.insertApplication(application);
			// DEFINIZIONE LEGAME CUSTOMER APPLICATION
			CustomerApplication customerApplication = new CustomerApplication(
					UUID.randomUUID().toString(),
					"http://localhost:8080/it.seda.example.springProject/manager",
					"CAS_SECURITY", new Date(), "CAS_SECURITY", new Date(),
					application.getChiavePrimariaDelleApplicazioni(), cu
							.getChiavePrimariaDelCliente());
			managerMapper.insertCustomerApplication(customerApplication);
			// MODULO SEMODUTB
			Modulo modulo = new Modulo(UUID.randomUUID().toString(),
					"MODULOSP", "moduloFittizio", "CAS_SECURITY", new Date(),
					"CAS_SECURITY", new Date());
			securityMapper.insertModulo(modulo);
			// FUNZION SEFUNZTB
			Funzione funzione = new Funzione(UUID.randomUUID().toString(),
					"FUNZIONESP", "funzioneFittizia", "CAS_SECURITY",
					new Date(), "CAS_SECURITY", new Date());
			securityMapper.insertFunzione(funzione);
			// SOTTOFUNZIONE SESFUNTB
			SottoFunzione sottofunzione = new SottoFunzione(UUID.randomUUID()
					.toString(), "SOTTOFUNZIONESP", "sottoFunzioneFittizia",
					"CAS_SECURITY", new Date(), "CAS_SECURITY", new Date());
			securityMapper.insertSottoFunzione(sottofunzione);
			// LEGAME FUNZIONE-RUOLO
			LegameFunzione legamefunzioneRuolo = new LegameFunzione(UUID
					.randomUUID().toString(), "CAS_SECURITY", new Date(),
					"CAS_SECURITY", new Date(),
					application.getChiavePrimariaDelleApplicazioni(),
					modulo.getChiavePrimariaDeiModuliDelleApplicazioni(),
					funzione.getChiavePrimariaDelleFunzioni(),
					sottofunzione.getChiavePrimariaDelleSottoFunzioni());
			securityMapper.insertLegameFunzione(legamefunzioneRuolo);

			// LEGAME GRUPPO FUNZIONE
			securityMapper
					.insertGruppoFunzione(new LegameGruppo(
							UUID.randomUUID().toString(),
							"CAS_SECURITY",
							new Date(),
							"CAS_SECURITY",
							new Date(),
							group.getChiavePrimariaDellaTabellaGruppi(),
							legamefunzioneRuolo
									.getChiavePrimariaDelLegameApplicazioniFunzioniSottofunzioni()));
		} catch (Exception e) {
			logger.error("problem while insert default user ...");
			e.printStackTrace();
		}
	}

	public void updateSignon(Signon signon) {

		Account tempAccount = new Account();

		tempAccount.setUsername(signon.getChiavePrimariaTabellaUsers());
		Object salt = saltSource.getSalt(new UserDetailsAdapter(tempAccount));
		signon.setPasswordValidaDellUtenza(passwordEncoder.encodePassword(
				signon.getPasswordValidaDellUtenza(), salt));

		securityMapper.updateSignon(signon);
		securityMapper.updateCredentialsExpiration(signon
				.getChiavePrimariaTabellaUsers());
	}

	@Transactional(readOnly = true)
	public DataPage<MutableAccount> listaAccount(String customerId,
			int pageNumber, int rowsPerPage) {

		RowBoundsHelper rbh = new RowBoundsHelper(rowsPerPage, pageNumber);
		int totalrows = listAccountCount(customerId); // per testare la
														// propagazione della
														// transazione su altri
														// metodi

		List<MutableAccount> accountList = securityMapper.listAccount(
				customerId, rbh.buildRowBounds());
		DataPage<MutableAccount> accountPage = new DefaultDataPage<MutableAccount>(
				accountList);
		rbh.decorate(accountPage, totalrows);

		return accountPage;
	}

	@Transactional(readOnly = true)
	public int listAccountCount(String customerId) {
		int rowsNumber = securityMapper.listAccountCount(customerId);
		return rowsNumber;
	}

	@Transactional(readOnly = true)
	public List<Group> groupsList() {
		List<Group> lg = securityMapper.groupsList();
		return lg;
	}

	public void deleteAccount(String username) {
		securityMapper.deleteAccount(username);
	}

	public void updateAccount(MutableAccount ato) {
		GroupMember gm = new GroupMember();

		gm.setChiavePrimariaDellaTabellaGruppi(ato
				.getChiavePrimariaDellaTabellaGruppi());
		gm.setChiavePrimariaDellaTabellaUtentiClienti(ato
				.getChiavePrimariaDellaTabellaUtentiClienti());

		// gm.setGroupName(ato.getGroupName());
		gm.setChiavePrimariaTabellaGruppiUtenti(ato
				.getChiavePrimariaTabellaGruppiUtenti());
		// gm.setUsername(ato.getUsername());
		securityMapper.updateAccount(ato);
		securityMapper.updateGroupMember(gm);
	}

	@Transactional(readOnly = true)
	public Account getAccountByCustomerUser(UsernameClient usernameClient) {
		return securityMapper.getAccountByCustomerUser(usernameClient);
	}

	@Transactional(readOnly = true)
	public Account getAccountByTicket(String idTicket) {
		if(securityMapper.isTicketValid(idTicket)){
		return securityMapper.getAccountByTicket(idTicket);
		}
		logger.debug("Ticket is expired");
		throw new ExperedTicketException(idTicket);
	}
	
	@Transactional(readOnly = true)
	public String getCodiceFiscaleFromUsernameClient(UsernameClient usernameClient){
		return securityMapper.getCodiceFiscaleFromUsernameClient(usernameClient);
	}
	
	

}
