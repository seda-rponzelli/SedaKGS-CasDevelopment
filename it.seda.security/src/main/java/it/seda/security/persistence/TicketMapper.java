package it.seda.security.persistence;

import it.seda.security.domain.Ticket;
import it.seda.security.domain.UserApplication;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketMapper {

	void insertTicket(Ticket ticket);
	void deleteTicket(Ticket ticket);
	Ticket selectTicket(String id);

	List<Ticket> listTicket(Ticket filter, RowBounds rowBounds);
	int listTicketCount(Ticket filter);
	
	Ticket getNotExpiredTicket(UserApplication userApplication);
	
	List<Ticket> getAllLastTickets(UserApplication userApplication);
	
	
	List<Ticket> getAllUserApplicationTickets(String ticketId);
	
	
}
