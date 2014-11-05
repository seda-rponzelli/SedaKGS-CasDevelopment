package it.seda.security.cas.validators;

import java.util.List;

import it.seda.security.authentication.UserDetailsAdapter;
import it.seda.security.cas.CASParametersURL;
import it.seda.security.cas.manager.forms.ChangePasswordForm;
import it.seda.security.cas.utils.ObjectCopier;
import it.seda.security.domain.Account;
import it.seda.security.domain.Signon;
import it.seda.security.domain.UsernameClient;
import it.seda.security.service.SecurityService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class PasswordChangedValidator implements ConstraintValidator<NotInvalidChangePassword,ChangePasswordForm> {
	
	
	private String KeyMessage;
    private String node;
    @Autowired
	private SaltSource saltSource;
    @Autowired SecurityService securityService;
    @Autowired
	private ShaPasswordEncoder passwordEncoder;
    private String ID_CLIENTE=CASParametersURL.ID_CLIENTE.getParameterName();
    
	boolean compare(String pa,String pr){
		if(pa.equals(pr)){
			return true;
		}
		return false;
	}

	@Override
	public void initialize(NotInvalidChangePassword notInvalidChangePassword) {
		// TODO Auto-generated method stub
		//messaggio i18n di errore
		this.KeyMessage=notInvalidChangePassword.message();
		//capo della form
		this.node=notInvalidChangePassword.field();
		
	}

	@Override
	public boolean isValid(ChangePasswordForm changeFormPassword,
			ConstraintValidatorContext constraintValidatorContext) {
		String newPassword=changeFormPassword.getNewPassword();
		String confirm=changeFormPassword.getConfirm();
		
		boolean isValidOldNew = compare(newPassword,confirm);
		boolean isValidUser=checkUser(changeFormPassword);
		boolean isValidPassword=passwordNotAlreadyUsed(changeFormPassword);
		
		
		
		
		
		
		boolean valid=isValidOldNew&&isValidUser&&isValidPassword;
		
		
		if (!valid) {
			KeyMessage = KeyMessage.replace("{","");
			KeyMessage = KeyMessage.replace("}","");
			if(!isValidOldNew){
				KeyMessage=KeyMessage.replace(".notValidUser", "");
				KeyMessage=KeyMessage.replace(".notValidPassword", "");
				KeyMessage=KeyMessage.concat(".notEqualsNewOld");
			}else if(!isValidUser){
				KeyMessage=KeyMessage.replace(".notEqualsNewOld", "");
				KeyMessage=KeyMessage.replace(".notValidPassword", "");
				KeyMessage=KeyMessage.concat(".").concat("notValidUser");
			}else if(!isValidPassword){
				KeyMessage=KeyMessage.replace(".notEqualsNewOld", "");
				KeyMessage=KeyMessage.replace(".notValidUser", "");
				KeyMessage=KeyMessage.concat(".notValidPassword");
			}
			KeyMessage="{".concat(KeyMessage).concat("}");
			replaceMessage(constraintValidatorContext);			
		}
		
		return valid;
		
	}
	//sostituisce il mess. di errore con quello i18n
	public void replaceMessage(ConstraintValidatorContext constraintValidatorContext){
		if(KeyMessage!=null){
			constraintValidatorContext.disableDefaultConstraintViolation();
			constraintValidatorContext.buildConstraintViolationWithTemplate(
					//"{it.seda.sem.security.password.NotEqualNewOld.message}"
					KeyMessage
	            )
	            .addNode(node)
	            .addConstraintViolation();
			
		}
	}
	
	
	/*Controlliamo che l'utente cliente è censito*/
	public boolean checkUser(ChangePasswordForm changeFormPassword){
		Signon oldSignon=null;
		String customerId=(String) resolveRequest().getSession().getAttribute(ID_CLIENTE);
		String username=changeFormPassword.getUsername();
		UsernameClient usernameClient=new UsernameClient(username,customerId);
		try{
			oldSignon=securityService.getSignon(usernameClient);
			if(oldSignon==null){
				return false;
			}
			}catch(Exception e){
				return false;
			}
		return true;
	}
	
	public boolean passwordNotAlreadyUsed(ChangePasswordForm changeFormPassword){
		try{
		String customerId=(String) resolveRequest().getSession().getAttribute(ID_CLIENTE);
		String username=changeFormPassword.getUsername();
	    Account tempAccount = new Account();
		tempAccount.setUsername(username);
		Object salt = saltSource.getSalt(new UserDetailsAdapter(tempAccount));
		String password=passwordEncoder.encodePassword(changeFormPassword.getNewPassword(), salt);
		UsernameClient usernameClient=new UsernameClient(username,customerId);
		List<String> passwordList=securityService.listUserPassword(usernameClient);
		if(passwordList.contains(password)){
			return false;
		}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	protected HttpServletRequest resolveRequest() {
		RequestAttributes attributes=RequestContextHolder.getRequestAttributes();
		return ((ServletRequestAttributes)attributes).getRequest();
	}
	
	

}
