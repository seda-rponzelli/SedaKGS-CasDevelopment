package it.seda.security.domain;

public class UserApplication {
	
	private String username;
	private String customerId;
	private String applicationId;
	
	
	
	public UserApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserApplication(String username,String customerId,String applicationId) {
		super();
		this.username = username;
		this.customerId = customerId;
		this.applicationId = applicationId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	@Override
	public String toString() {
		return "UserApplication [username=" + username + ", customerId="
				+ customerId + ", applicationId=" + applicationId + "]";
	}
	
}
