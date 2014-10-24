package it.seda.security.sign.out;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import it.seda.security.authentication.UserDetailsAdapter;
import it.seda.security.domain.UsernameClient;
import it.seda.security.filter.SedaSingleSignOutFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;



public class SedaSingleSignOutHandler {
	
	private final Logger logger = LoggerFactory.getLogger(SedaSingleSignOutHandler.class);
	final static String WEB_APP_LOGOUT_URL="j_spring_security_logout";
	final static String CAS_LOGOUT_URL="j_spring_security_cas_logout";
	/** Mapping of token IDs and session IDs to HTTP sessions */
    private HashMap sessionMappingStorage = new HashMap();
   // private boolean tockenFlag=true;
	
	
	//il cas ha inviato in post
	public boolean isApplicationLogoutRequst(HttpServletRequest request){
		return  "GET".equals(request.getMethod())
                && !isMultipartRequest(request)&&isWebAppLogoutRequest(request);
	}
	
	
	public boolean isCASLogoutRequest(HttpServletRequest request){
		return  "POST".equals(request.getMethod())&&isLogoutCASRequest(request);
	}
	
	
	
	private boolean isMultipartRequest(final HttpServletRequest request) {
        return request.getContentType() != null && request.getContentType().toLowerCase().startsWith("multipart");
    }
	
	
	public void logout() {
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(null);
        SecurityContextHolder.clearContext();
    }
	
	public boolean isLogoutCASRequest(HttpServletRequest request){
		String uri = request.getRequestURI();
		return uri.endsWith(CAS_LOGOUT_URL);
		
	}
	
	
	public boolean isWebAppLogoutRequest(HttpServletRequest request){
		String uri = request.getRequestURI();
		return uri.endsWith(WEB_APP_LOGOUT_URL);
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void recordSession(final HttpServletRequest request) {
        final HttpSession session = request.getSession(false);
        if (session == null) {
            logger.debug("No session currently exists (and none created).  Cannot record session information for single sign out.");
            return;
        }
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        UserDetailsAdapter userDetailsAdapter=(UserDetailsAdapter) authentication.getPrincipal();
        String username=userDetailsAdapter.getUsername();
        String customerId=userDetailsAdapter.getCustomerId();
        UsernameClient usernameClient=new UsernameClient(username,customerId);
        if(customerId==null||usernameClient==null){
        	 logger.debug("No customer user available.");
             return;
        }
        logger.debug("Recording session for customerId {} and username" , customerId, username);

        try {
        	removeSessionFromMapById(session.getId());
            //this.sessionMappingStorage.remove(session.getId());
        } catch (final Exception e) {
            // ignore if the session is already marked as invalid.  Nothing we can do!
        }
        sessionMappingStorage.put(customerId, session);
    }
	
	@SuppressWarnings("unchecked")
	public void removeSessionFromMapById(String sessionId){
		@SuppressWarnings("rawtypes")
		Iterator hashMapIterator = sessionMappingStorage.entrySet().iterator();
		while (hashMapIterator.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry pairs = (Map.Entry)hashMapIterator.next();
			if(((HttpSession)pairs.getValue()).getId().equals(sessionId)){
				sessionMappingStorage.remove(pairs.getKey());
			}
			
		}
		sessionMappingStorage.values().removeAll(Collections.singleton(sessionId));
	}
	
	
	//We delete al records containing the username customerId stored in the posted request from the CAS
	public void destroySession(final HttpServletRequest request) {
		String username=request.getParameter("username");
		String customerId=request.getParameter("customerId");
		UsernameClient usernameCustomer=new UsernameClient(username,customerId);
		HttpSession session = (HttpSession) sessionMappingStorage.get(usernameCustomer);
		if (session != null) {
            String sessionID = session.getId();
            try {
            	logger.debug("Invalidating session [{}] ", sessionID);
            	removeSessionFromMapById(session.getId());
                session.invalidate();
            } catch (final IllegalStateException e) {
                logger.debug("Error invalidating session.", e);
            }
            try {
				request.logout();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				  logger.debug("request logout error.", e);
			}
           
        }
	}
	
	
	public boolean isTokenRequest(HttpServletRequest request){
		final HttpSession session = request.getSession(false);
		if(session.getAttribute("customerId")!=null){
			return true;
		}
		return false;
	}

}
