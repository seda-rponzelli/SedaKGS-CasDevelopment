package it.seda.security.filter;

import it.seda.security.cas.CASParametersURL;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

public class TicketRequestFilter extends OncePerRequestFilter{
	
//	private String ID_CLIENTE="customerId";
//	private String ID_TICKET="ticket";
	
	private String ID_CLIENTE=CASParametersURL.ID_CLIENTE.getParameterName();
	private String ID_TICKET=CASParametersURL.ID_TICKET.getParameterName();

	@Override
	protected void doFilterInternal(HttpServletRequest req,
			HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		
		 HttpServletRequest request = (HttpServletRequest) req;
         HttpSession session=request.getSession();
         String ticket = request.getParameter(ID_TICKET);
         if (ticket != null) {
         	session.setAttribute(ID_TICKET, ticket);
         }
         String customerId = request.getParameter(ID_CLIENTE);
         if (customerId != null) {
         	session.setAttribute(ID_CLIENTE, customerId);
         }
         filterChain.doFilter(req, res);	
	}

}
