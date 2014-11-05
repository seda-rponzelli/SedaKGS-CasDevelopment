package it.seda.security.sign.out;
import it.seda.security.cas.CASParametersURL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;



public class SedaSingleSignOutHandler {
	

	
	private String ID_TICKET=CASParametersURL.ID_TICKET.getParameterName();
	
	private final Logger logger = LoggerFactory.getLogger(SedaSingleSignOutHandler.class);
	final static String WEB_APP_LOGOUT_URL="j_spring_security_logout";
	final static String CAS_LOGOUT_URL="j_spring_security_cas_logout";
	final static String CAS_LOGOUT_TICKET="j_seda_cas_saved_ticket";

    /** Mapping of token IDs and session IDs to HTTP sessions */
    private SessionMappingStorage sessionMappingStorage = new HashMapBackedSessionMappingStorage();

	
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
	
	/** performs logout*/
	public void logout() {
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(null);
        SecurityContextHolder.clearContext();
    }
	
	
	/** check if this is a CAS logout request*/
	public boolean isLogoutCASRequest(HttpServletRequest request){
		String uri = request.getRequestURI();
		return uri.endsWith(CAS_LOGOUT_URL);
		
	}
	
	 /** check if this is a web app logout request*/
	public boolean isWebAppLogoutRequest(HttpServletRequest request){
		String uri = request.getRequestURI();
		return uri.endsWith(WEB_APP_LOGOUT_URL);
		
	}
	
	
	 /** Records the current ticket-session and invalidates the old session if is present within the same ticket*/
	@SuppressWarnings("unchecked")
	public void recordSession(final HttpServletRequest request) {
        final HttpSession session = request.getSession(false);
        if (session == null) {
            logger.debug("No session currently exists (and none created).  Cannot record session information for single sign out.");
            return;
        }
        String ticket=(String) session.getAttribute(ID_TICKET);
        StringBuffer sb=new StringBuffer("");
        sb.append(ticket);
       
        if(ticket==null){
        	 logger.debug("No customer ticket available.");
             return;
        }
        logger.debug("Recording session for ticket {} " , ticket);

        try {
        	HttpSession oldSession = (HttpSession) sessionMappingStorage.removeSessionByMappingId(sb.toString());
        	if(oldSession.getId()!=session.getId()){
        	oldSession.invalidate();
        	}
        	this.sessionMappingStorage.removeBySessionById(session.getId());
        } catch (final Exception e) {
            // ignore if the session is already marked as invalid.  Nothing we can do!
        }
       
        sessionMappingStorage.addSessionById(sb.toString(), session);
    }
	
	
	
	 /** Invalidate the current session*/
	public void destroySession(final HttpServletRequest request) {
		String ticket=request.getParameter(ID_TICKET);
		HttpSession session = (HttpSession) sessionMappingStorage.removeSessionByMappingId(ticket);
		if (session != null) {
            String sessionID = session.getId();
            try {
            	logger.debug("Invalidating session [{}] ", sessionID);
                session.invalidate();
            } catch (final IllegalStateException e) {
                logger.debug("Error invalidating session.", e);
            }
            try {
				request.logout();
			} catch (ServletException e) {
				  logger.debug("request logout error.", e);
			}
           
        }
	}
	
	 /** Check if this is a token request from CAS web service */
	public boolean isTokenRequest(HttpServletRequest request){
		final HttpSession session = request.getSession(false);
		if(session.getAttribute(ID_TICKET)!=null){
			 /** Store ticket in session */
			session.setAttribute(CAS_LOGOUT_TICKET,session.getAttribute(ID_TICKET));
			return true;
		}
		return false;
	}

	 /** Get CAS ticket from session and then concats it to the CAS web service's url */
	public String getCASWebServiceURL(HttpServletRequest request,String url){
		HttpSession session = request.getSession(false);
		String ticket=(String) session.getAttribute(CAS_LOGOUT_TICKET);
        url=url.concat("/").concat(ticket);
        return url;
	}
}
