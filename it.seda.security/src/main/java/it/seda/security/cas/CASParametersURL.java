package it.seda.security.cas;

public enum CASParametersURL {
	
	ID_TICKET("j_seda_cas_ticket"),
	ID_APPLICAZIONE("j_seda_cas_application"),
	ID_CLIENTE("j_seda_cas_customer"),
	CAS_SESSION("j_seda_cas_session");
	
	private final String url;
	
	private CASParametersURL(String url){
	this.url=url;	
	}
	
	public String getParameterName() { return url; }

}
