package it.seda.security.filter;

import it.seda.security.sign.out.SedaSingleSignOutHandler;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SedaSingleSignOutFilter  implements Filter {
	
	/** Logger instance */
    private final Logger logger = LoggerFactory.getLogger(SedaSingleSignOutFilter.class);
    
    private static final SedaSingleSignOutHandler HANDLER = new SedaSingleSignOutHandler();
	
	/** Mapping of token IDs and session IDs to HTTP sessions */
    //private HashMap sessionMappingStorage = new HashMap();
	
    /** CAS redirect url */
    private String casURL;
    
	public SedaSingleSignOutFilter(String casURL) {
		super();
		this.casURL = casURL;
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
	     if(HANDLER.isApplicationLogoutRequst(request)){
	     response.sendRedirect(HANDLER.getCASWebServiceURL(request,casURL));
	     }else if(HANDLER.isCASLogoutRequest(request)){
	    	 logger.debug("Performing log out from "+((HttpServletRequest)servletRequest).getRequestURL());
	    	 HANDLER.destroySession(request);
	    	 HANDLER.logout();
	     }else{
	    	 if(HANDLER.isTokenRequest(request)){
	    		 HANDLER.recordSession(request);
	    	 }
	    	 chain.doFilter(servletRequest, servletResponse);
	     }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	} 
	
	
	
	

}
