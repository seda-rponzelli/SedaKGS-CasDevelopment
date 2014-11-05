package it.seda.security.cas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import it.seda.security.cas.CASParametersURL;
import it.seda.security.cas.manager.forms.ChangePasswordForm;
import it.seda.security.cas.utils.ObjectCopier;
import it.seda.security.domain.Signon;
import it.seda.security.domain.UsernameClient;
import it.seda.security.service.SecurityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


	
	@Controller
	@RequestMapping(value="login/changePassword")
	public class ChangePasswordController {
		

		@Autowired SecurityService securityService;
		private String ID_CLIENTE=CASParametersURL.ID_CLIENTE.getParameterName();
		
		private Logger logger = LoggerFactory.getLogger(ChangePasswordController.class);
		@RequestMapping(method = RequestMethod.GET)
		public String initForm(ModelMap model){
			ChangePasswordForm changePasswordForm = new ChangePasswordForm();
			changePasswordForm.setUsername("USERNAME");
			changePasswordForm.setNewPassword("NEW_PASSWORD");
			changePasswordForm.setConfirm("CONFIRM_NEW_PASSWORD");
			changePasswordForm.setEsito(true);
			model.addAttribute("changePassword", changePasswordForm);
			return "changePassword";
		}
		
		@RequestMapping(method = RequestMethod.POST)
		public String changePassword(HttpServletRequest request,@Valid  @ModelAttribute("changePassword") ChangePasswordForm changePasswordForm, BindingResult result, ModelMap model) {
			List<ObjectError> errors=null;
			if (result.hasErrors()) {
				errors=result.getAllErrors();
				return "changePassword";
			} else {		
				logger.debug("ChangePassword: dati inseriti correttamente"); //TODO i18n
			}
			
			String customerId=(String) request.getSession().getAttribute(ID_CLIENTE);
			String username=changePasswordForm.getUsername();
			UsernameClient usernameClient=new UsernameClient(username,customerId);
			Signon oldSignon=null;
			Signon newSignon = new Signon();
			try{
			oldSignon=securityService.getSignon(usernameClient);
			newSignon=ObjectCopier.createObject(oldSignon, Signon.class);	
			newSignon.setPasswordValidaDellUtenza(changePasswordForm.getNewPassword());
			newSignon.setPenultimaPasswordValidaDellUtenza(oldSignon.getUltimaPasswordValidaDellUtenza());
			newSignon.setUltimaPasswordValidaDellUtenza(oldSignon.getPasswordValidaDellUtenza());
			newSignon.setOperatoreUltimaVariazione("CAS Change Password");
			}catch(Exception e){
				String message="login.changepassword.username.notExists";
				logger.debug("Utenza non censita.");	
			    result.rejectValue("NewOldError", message);
				return "changePassword";
			}
			securityService.updateSignon(username,newSignon);		
			changePasswordForm.setEsito(true);
			model.addAttribute("changePassword", changePasswordForm);
			return "changePassword";
		}

}
