package it.seda.security.cas.manager.forms;

import org.hibernate.validator.constraints.NotEmpty;
import it.seda.security.cas.validators.NotInvalidChangePassword;



@NotInvalidChangePassword(message="{login.changepassword}", field = "NewOldError")
public class ChangePasswordForm {
	@NotEmpty(message="{login.changepassword.username.notEmpty}")
	String username;
	String newPassword;
	String confirm;
	String newOldError;
	boolean esito;
	
  
	public String getNewOldError() {
		return newOldError;
	}

	public void setNewOldError(String newOldError) {
		this.newOldError = newOldError;
	}

	public boolean isEsito() {
		return esito;
	}

	public void setEsito(boolean esito) {
		
		this.esito = esito;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		
		this.newPassword = newPassword;
	}

	public String getConfirm() {
		return confirm;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setConfirm(String confirm) {
		
		this.confirm = confirm;
	}

	@Override
	public String toString() {
		return "ChangePasswordForm [username=" + username + ", newPassword="
				+ newPassword + ", confirm=" + confirm + ", newOldError="
				+ newOldError + ", esito=" + esito + "]";
	}

	

	

}