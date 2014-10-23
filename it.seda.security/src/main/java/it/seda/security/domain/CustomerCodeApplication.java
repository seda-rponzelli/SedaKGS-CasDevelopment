package it.seda.security.domain;

public class CustomerCodeApplication {
	
	
	private String customerId; //SECUSTTB.SECUST_CCODCUS
	private String chiavePrimariaDelleApplicazioni; //SEAPPLTB.SEAPPL_CKEYAPPL
	
	
	
	
	public CustomerCodeApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerCodeApplication(String customerId,
			String chiavePrimariaDelleApplicazioni) {
		super();
		this.customerId = customerId;
		this.chiavePrimariaDelleApplicazioni = chiavePrimariaDelleApplicazioni;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getChiavePrimariaDelleApplicazioni() {
		return chiavePrimariaDelleApplicazioni;
	}
	public void setChiavePrimariaDelleApplicazioni(
			String chiavePrimariaDelleApplicazioni) {
		this.chiavePrimariaDelleApplicazioni = chiavePrimariaDelleApplicazioni;
	}
	@Override
	public String toString() {
		return "CustomerCodeApplicationId [customerId=" + customerId
				+ ", chiavePrimariaDelleApplicazioni="
				+ chiavePrimariaDelleApplicazioni + "]";
	}
	
	
 
	
	
	
	
	
}
