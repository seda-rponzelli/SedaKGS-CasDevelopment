/**
 * 
 */
package it.seda.security.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * The abstract Account, the base security identity
 * 
 * @author f.ricci
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractAccount implements Serializable {

	protected String username;
	protected String customerId;
	protected String firstName;
	protected String lastName;
	protected String codiceFiscale;;
	protected String email;
	protected boolean enabled;
	protected short attempts;
	protected Date lastAttempt;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
 
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isLocked() {
		return attempts>=Account.MAX_FAILED_LOGIN_ATTEMPTS;
	}
	public short getAttempts() {
		return attempts;
	}
	public void setAttempts(short attempts) {
		this.attempts = attempts;
	}
	public Date getLastAttempt() {
		return lastAttempt;
	}
	public void setLastAttempt(Date lastAttempt) {
		this.lastAttempt = lastAttempt;
	}
	
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	
	public String getIdCliente() {
		return customerId;
	}
	public void setIdCliente(String idCliente) {
		this.customerId = idCliente;
	}
	@Override
	public String toString() {
		return "AbstractAccount [username=" + username + ", idCliente="
				+ customerId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", codiceFiscale=" + codiceFiscale + ", email="
				+ email + ", enabled=" + enabled + ", attempts=" + attempts
				+ ", lastAttempt=" + lastAttempt + "]";
	}
	
	
	
	
}
