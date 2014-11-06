package it.seda.security.cas.utils;
import it.seda.security.cas.controller.LoginController;
import it.seda.security.domain.CustomerCodeApplication;
import it.seda.security.domain.UserApplication;
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
	
	 public boolean checkUserApplicationId(String username,String customerId,String applicationId){
	    	
	    	UserApplication userApplication=new UserApplication(username,customerId,applicationId);
	    	int  esito=0;
	    	try{
	    		esito=securityService.isUserApplicationAuthorized(userApplication);
	    	}catch(Exception e){
	    		logger.debug("Errors occurred while checking esername "+username+" and customerId "+ customerId+" Error: "+ e.getMessage());
	    		return false;
	    	}
	    	if(esito>0){
	    		return true;
	    	}
	    	return false;
	    }
	 
	 public String setUrlBack(CustomerCodeApplication customerCodeApplication){
	        String urlBack=securityService.findURLBackByCustumerCodeApplication(customerCodeApplication);
	        return  urlBack;	
	    }
	
	 
	 
	 
	 

}
