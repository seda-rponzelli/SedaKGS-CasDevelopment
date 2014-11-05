/**
 * 
 */
package it.seda.security.service;

import it.seda.jdbc.commons.DataPage;
import it.seda.jdbc.commons.DefaultDataPage;
import it.seda.jdbc.ibatis.RowBoundsHelper;
import it.seda.security.domain.Ticket;
import it.seda.security.domain.UserApplication;
import it.seda.security.persistence.ManagerMapper;
import it.seda.security.persistence.SecurityMapper;
import it.seda.security.persistence.TicketMapper;
import it.seda.security.service.exceptions.ApplicationNotFoundException;
import it.seda.security.sign.out.LogoutUtils;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author f.ricci
 *
 */
@Service
@Transactional
public class TicketService {
    
	
	private static  final Logger logger = LoggerFactory.getLogger(TicketService.class);
	@Autowired private TicketMapper ticketMapper;
	@Autowired private ManagerMapper managerMapper;
	@Autowired private SecurityMapper securityMapper;
	@Autowired private LogoutUtils logoutUtils;
	
	final static int TICKET_EXPIRATION_TIME=12;
	
	
	/**
	 * 
	 * @return the new generated ticket
	 * @exception ApplicationNotFoundException if the application id was not found
	 */
	public Ticket generate(String username, String customerId, String applicationId) {
		UserApplication userApplication=new UserApplication(username,customerId,applicationId);
		if (managerMapper.existsApplication(applicationId)==0) {
			throw ApplicationNotFoundException.idNotFound(applicationId); 
		}
		
		Ticket currentTicket=ticketMapper.getNotExpiredTicket(userApplication); 
		if(currentTicket!=null){
		return	currentTicket;
		}
		//LogoutUtils logoutUtils=new LogoutUtils();
		if(logoutUtils.performCASLogout(ticketMapper.getAllLastTickets(userApplication))){
			logger.debug("Ticket expired, performing Logout from all user applications...New ticket generation.");
		}
		//New ticket generation
		DateTime dateTime = new DateTime();
		Ticket ticket = new Ticket();
		ticket.init();
		ticket.setChiavePrimariaDellaTabellaDeiTicket(UUID.randomUUID().toString());
		ticket.setUsername(username);
		
		ticket.setCodiceFiscaleDelDelegatoPersonaFisica(securityMapper.getCodiceFiscaleFromUserApplication(userApplication));
		ticket.setChiavePrimariaDelleApplicazioni(applicationId);
		ticket.setDataCreazioneTickets(dateTime.toDate());
		//ticket.setDataScadenzaTicket(dateTime.plusMinutes(1).plusSeconds(30).toDate());
		ticket.setDataScadenzaTicket(dateTime.plusHours(TICKET_EXPIRATION_TIME).toDate());
		insertTicket(ticket);
		return ticket;
	}
	
	public void insertTicket(Ticket ticket) {
		ticketMapper.insertTicket(ticket);
	}

	 public void deleteTicket(Ticket ticket) {
		 ticketMapper.deleteTicket(ticket);
	 }
	
	 @Transactional(readOnly=true)
	 public Ticket selectTicket(String ticketId) {
		 return ticketMapper.selectTicket(ticketId);
	 }
	 
	 @Transactional(readOnly=true)
	 public DataPage<Ticket> listTicket(Ticket filter, int pageNumber, int rowsPerPage) {
		 RowBoundsHelper rbh = new RowBoundsHelper(rowsPerPage, pageNumber);
		 int totalrows=ticketMapper.listTicketCount(filter);

		 List<Ticket> ticketList=ticketMapper.listTicket(filter, rbh.buildRowBounds());
		 DataPage<Ticket> ticketPage= new DefaultDataPage<Ticket>(ticketList);
		 rbh.decorate(ticketPage, totalrows);

		 return ticketPage;
	 }
	 
	 
	 
	 @Transactional(readOnly=true)
	 public List<Ticket> getAllUserApplicationTickets(String ticketId) {
		 return ticketMapper.getAllUserApplicationTickets(ticketId);
	 }
	 
	 
	 
}
