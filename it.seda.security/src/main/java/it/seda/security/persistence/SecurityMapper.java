package it.seda.security.persistence;

import it.seda.security.domain.Account;
import it.seda.security.domain.CustomerApplication;
import it.seda.security.domain.CustomerCodeApplication;
import it.seda.security.domain.CustomerUser;
import it.seda.security.domain.Funzione;
import it.seda.security.domain.Group;
import it.seda.security.domain.GroupMember;
import it.seda.security.domain.LegameFunzione;
import it.seda.security.domain.LegameGruppo;
import it.seda.security.domain.Modulo;
import it.seda.security.domain.MutableAccount;
import it.seda.security.domain.Signon;
import it.seda.security.domain.SottoFunzione;


import it.seda.security.domain.UserApplication;
import it.seda.security.domain.UsernameClient;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface SecurityMapper {

	Account getAccountByUsername(String username);
	Account getAccountByCustomerUser(UsernameClient customerUser);
	MutableAccount getMutableAccountByUsername(String username);
	String findPasswordByUsername(String username);
	String findPasswordByCustumerUser(UsernameClient usernameClient); 
	void insertAccount(MutableAccount account);
	void updateAccount(MutableAccount account);
	void deleteAccount(String username);
	void loginFailure(String username);	
	void restoreAttempts(MutableAccount mutableAccount);
	
	void insertDefaultGroupMember(String username);
	void insertAdminGroupMember(String username);
	
	void deleteGroupMember(GroupMember groupMember);	
	void insertGroupMember(GroupMember groupMember);	
	void updateGroupMember(GroupMember groupMember);
	
	void updateCredentialsExpiration(String username);
	
	void insertSignon(Signon signon);
	void updateSignon(Signon signon);
	
	List<Group> groupsList();
	
	List<MutableAccount> listAccount(String customerId, RowBounds rowBounds);
	int listAccountCount(String customerId);
	void insertGroup(Group group);
	
	void insertGruppoFunzione(LegameGruppo legameGruppo);
	
	void insertLegameFunzione(LegameFunzione legameFunzione);
	
	void insertModulo(Modulo modulo);
	
	void insertFunzione(Funzione funzione);
	
	void insertSottoFunzione(SottoFunzione sottoFunzione);
	
	String findURLBackByCustumerApplication(CustomerApplication customerApplication);
	
	String findURLBackByCustumerCodeApplication(CustomerCodeApplication customerCodeApplication);
	
	Account  getAccountByTicket(String idTicket);
	
	String getCodiceFiscaleFromUserApplication(UserApplication userApplication);
	
	int isTicketValid(String idTicket);
	
	String getCodiceFiscaleFromUsernameClient(UsernameClient usernameClient);
	
	Signon getSignon(UsernameClient usernameClient);
	
	List<String> listUserPassword(UsernameClient usernameClient);
	
	int isUserApplicationAuthorized(UserApplication userApplication);
}
