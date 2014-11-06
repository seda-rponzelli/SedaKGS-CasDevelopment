package it.seda.security.filter;

import it.seda.security.cas.CASParametersURL;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

public class CasSessionFilter implements Filter {
	
	private String CAS_SESSION=CASParametersURL.CAS_SESSION.getParameterName();


	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		
		     final HttpServletRequest request = (HttpServletRequest) servletRequest;
	         final HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		     HttpSession session = request.getSession();
	         String casSession = request.getParameter(CAS_SESSION);
	         String customerId = request.getParameter(CAS_SESSION);
	         if (customerId != null) {
	         	session.setAttribute(CAS_SESSION, casSession);
	         }
	         chain.doFilter(servletRequest, servletResponse);
		
	}
	
	

}
