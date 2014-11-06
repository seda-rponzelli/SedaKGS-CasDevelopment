package it.seda.security.persistence;

import java.util.List;

import it.seda.security.domain.Application;
import it.seda.security.domain.Customer;
import it.seda.security.domain.CustomerApplication;
import it.seda.security.domain.CustomerUser;
import it.seda.security.domain.Group;
import it.seda.security.domain.Ticket;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerMapper {

	
	/* ************************** */
	/* **** Gestione clienti **** */
	/* ************************** */
	void insertCustomer(Customer customer);
	void deleteCustomer(Customer customer);
	void updateCustomer(Customer customer);
	int existsCustomer(String customerId);
	Customer selectCustomer(String customerId);
	List<Customer> listCustomer(RowBounds rowBounds);
	List<Customer> listCustomer();
	int listCustomerCount();
	
	/* **** Gestione clienti/utenti **** */
	void insertCustomerUser(CustomerUser customerUser);
	void deleteCustomerUser(CustomerUser customerUser);
	int existsCustomerUser(CustomerUser customerUser);
	
	/* ******************************* */
	/* **** Gestione applicazioni **** */
	/* ******************************* */
	void insertApplication(Application application);
	void deleteApplication(Application application);
	void updateApplication(Application application);
	Application selectApplication(String applicationId);
	Application selectApplicationIdByName(String applicationName);
	int existsApplication(String applicationId);
	int existsApplicationByName(String applicationName);
	List<Application> listApplication(RowBounds rowBounds);
	int listApplicationCount();
	
	/* **** Gestione clienti/applicazioni **** */
	void insertCustomerApplication(CustomerApplication customerApplication);
	void updateCustomerApplication(CustomerApplication customerApplication);
	void deleteCustomerApplication(CustomerApplication customerApplication);
	List<CustomerApplication> listCustomerApplication(String customerId, RowBounds rowBounds);
	int listCustomerApplicationCount(String customerId);
	
	String getCustomerIdByURI(String uri);
	
	
	String getURLbackByTicket(Ticket ticket);
	
	
	List<Application> getAllChildApplications(String applicationId);
	
	int hasParent(String applicationId);
	
	
}
