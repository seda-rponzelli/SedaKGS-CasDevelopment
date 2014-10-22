package it.seda.security.domain;

public class UsernameClient {
	
	private String username;
	
	private String customerId;
	public UsernameClient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsernameClient(String username,
			String customerId) {
		super();
		this.username = username;
		
		this.customerId = customerId;
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
	@Override
	public String toString() {
		return "UsernameClientApplication [username=" + username
				+ ", customerId="
				+ customerId + "]";
	}
	
	
	
	

}
