package it.seda.security.domain;

public class UserApplication {
	
	private String username;
	private String applicationId;
	
	
	
	public UserApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserApplication(String username, String applicationId) {
		super();
		this.username = username;
		this.applicationId = applicationId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	@Override
	public String toString() {
		return "UserApplication [username=" + username + ", applicationId="
				+ applicationId + "]";
	}
	
	
	
	

}
