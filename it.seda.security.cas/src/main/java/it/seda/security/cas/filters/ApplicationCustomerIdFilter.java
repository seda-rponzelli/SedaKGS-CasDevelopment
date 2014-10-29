/**
 * 
 */
package it.seda.security.cas.filters;

import it.seda.security.cas.CASParametersURL;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author lmontesi
 *
 */
public class ApplicationCustomerIdFilter implements Filter{
	
//	private String ID_CLIENTE="customerId";
//	private String ID_APPLICAZIONE="applicationId";
	
	private String ID_CLIENTE=CASParametersURL.ID_CLIENTE.getParameterName();
	private String ID_APPLICAZIONE=CASParametersURL.ID_APPLICAZIONE.getParameterName();

    @Override
    public void destroy() {
        // Do nothing
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {

            HttpServletRequest request = (HttpServletRequest) req;
            HttpSession session=request.getSession();
            
            String applicationId = request.getParameter(ID_APPLICAZIONE);
            if (applicationId != null) {
            	session.setAttribute(ID_APPLICAZIONE, applicationId);
            }
            String customerId = request.getParameter(ID_CLIENTE);
            if (customerId != null) {
            	session.setAttribute(ID_CLIENTE, customerId);
            }
            chain.doFilter(req, res);

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // Do nothing
    }

}
