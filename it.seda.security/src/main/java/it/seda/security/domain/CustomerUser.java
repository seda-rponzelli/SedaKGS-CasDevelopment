/**
 * 
 */
package it.seda.security.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author f.ricci
 *
 */
@SuppressWarnings("serial")
public class CustomerUser implements Serializable{
	
	private String  chiaveTabellaRelazioneUserCliente; //SEUTEC_CKEYUTEC
	private String operatoreInserimento;  //SEUTEC_COPERINS 
	private Date dataInserimento;// SEUTEC_GDATAINS 
	private String operatoreUltimaVariazione; //SEUTEC_COPEUVAR 
	private Date dataUltimaVariazione;//SEUTEC_GDATUVAR 
	private String chiavePrimariaDelCliente;//SECUST_CKEYCUST 
	private String chiavePrimariaTabellaUsers;//SEUSER_CKEYUSER 
	
	
	
	
	public CustomerUser(String chiaveTabellaRelazioneUserCliente,
			String operatoreInserimento, Date dataInserimento,
			String operatoreUltimaVariazione, Date dataUltimaVariazione,
			String chiavePrimariaDelCliente, String chiavePrimariaTabellaUsers) {
		super();
		this.chiaveTabellaRelazioneUserCliente = chiaveTabellaRelazioneUserCliente;
		this.operatoreInserimento = operatoreInserimento;
		this.dataInserimento = dataInserimento;
		this.operatoreUltimaVariazione = operatoreUltimaVariazione;
		this.dataUltimaVariazione = dataUltimaVariazione;
		this.chiavePrimariaDelCliente = chiavePrimariaDelCliente;
		this.chiavePrimariaTabellaUsers = chiavePrimariaTabellaUsers;
	}
	public String getChiaveTabellaRelazioneUserCliente() {
		return chiaveTabellaRelazioneUserCliente;
	}
	public void setChiaveTabellaRelazioneUserCliente(
			String chiaveTabellaRelazioneUserCliente) {
		this.chiaveTabellaRelazioneUserCliente = chiaveTabellaRelazioneUserCliente;
	}
	public String getOperatoreInserimento() {
		return operatoreInserimento;
	}
	public void setOperatoreInserimento(String operatoreInserimento) {
		this.operatoreInserimento = operatoreInserimento;
	}
	public Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	public String getOperatoreUltimaVariazione() {
		return operatoreUltimaVariazione;
	}
	public void setOperatoreUltimaVariazione(String operatoreUltimaVariazione) {
		this.operatoreUltimaVariazione = operatoreUltimaVariazione;
	}
	public Date getDataUltimaVariazione() {
		return dataUltimaVariazione;
	}
	public void setDataUltimaVariazione(Date dataUltimaVariazione) {
		this.dataUltimaVariazione = dataUltimaVariazione;
	}
	public String getChiavePrimariaDelCliente() {
		return chiavePrimariaDelCliente;
	}
	public void setChiavePrimariaDelCliente(String chiavePrimariaDelCliente) {
		this.chiavePrimariaDelCliente = chiavePrimariaDelCliente;
	}
	public String getChiavePrimariaTabellaUsers() {
		return chiavePrimariaTabellaUsers;
	}
	public void setChiavePrimariaTabellaUsers(String chiavePrimariaTabellaUsers) {
		this.chiavePrimariaTabellaUsers = chiavePrimariaTabellaUsers;
	}
	@Override
	public String toString() {
		return "CustomerUser [chiaveTabellaRelazioneUserCliente="
				+ chiaveTabellaRelazioneUserCliente + ", operatoreInserimento="
				+ operatoreInserimento + ", dataInserimento=" + dataInserimento
				+ ", operatoreUltimaVariazione=" + operatoreUltimaVariazione
				+ ", dataUltimaVariazione=" + dataUltimaVariazione
				+ ", chiavePrimariaDelCliente=" + chiavePrimariaDelCliente
				+ ", chiavePrimariaTabellaUsers=" + chiavePrimariaTabellaUsers
				+ "]";
	}
	
	
	public void init(){
		this.chiaveTabellaRelazioneUserCliente=" "; //SEUTEC_CKEYUTEC
		this.operatoreInserimento=" ";  //SEUTEC_COPERINS 
		this.dataInserimento=new Date();// SEUTEC_GDATAINS 
		this.operatoreUltimaVariazione=" "; //SEUTEC_COPEUVAR 
		this.dataUltimaVariazione=new Date();//SEUTEC_GDATUVAR 
		this.chiavePrimariaDelCliente=" ";//SECUST_CKEYCUST 
		this.chiavePrimariaTabellaUsers=" ";//SEUSER_CKEYUSER 
		
	}
	
}
