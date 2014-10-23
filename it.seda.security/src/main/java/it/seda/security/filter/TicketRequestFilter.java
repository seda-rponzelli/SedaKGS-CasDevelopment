package it.seda.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

public class TicketRequestFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest req,
			HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		
		 HttpServletRequest request = (HttpServletRequest) req;
         HttpSession session=request.getSession();
         String ticket = request.getParameter("ticket");
         if (ticket != null) {
         	session.setAttribute("ticket", ticket);
         }
         String customerId = request.getParameter("customerId");
         if (customerId != null) {
         	session.setAttribute("customerId", customerId);
         }
         filterChain.doFilter(req, res);	
	}

}
