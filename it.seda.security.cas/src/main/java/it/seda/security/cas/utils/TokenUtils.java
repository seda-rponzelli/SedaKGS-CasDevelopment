package it.seda.security.cas.utils;
import it.seda.security.cas.controller.LoginController;
import it.seda.security.domain.CustomerCodeApplication;
import it.seda.security.domain.UsernameClient;
import it.seda.security.service.SecurityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenUtils {
	
	
	private static final Logger logger = LoggerFactory.getLogger(TokenUtils.class);
	@Autowired SecurityService securityService;
	
	 public boolean checkUserApplicationId(String username,String customerId){
	    	UsernameClient usernameClient = new UsernameClient(username,customerId);
	    	String  codiceFiscale="";
	    	try{
	    		codiceFiscale=securityService.getCodiceFiscaleFromUsernameClient(usernameClient);
	    	}catch(Exception e){
	    		logger.debug("Errors occurred while checking esername "+username+" and customerId "+ customerId);
	    		return false;
	    	}
	    	if(codiceFiscale!=null&&!codiceFiscale.isEmpty()){
	    		return true;
	    	}
	    	return false;
	    }
	 
	 public String setUrlBack(CustomerCodeApplication customerCodeApplication){
	        String urlBack=securityService.findURLBackByCustumerCodeApplication(customerCodeApplication);
	        return  urlBack;	
	    }
	
	 
	 
	 
	 

}
