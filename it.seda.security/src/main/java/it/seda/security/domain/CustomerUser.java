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
public class CustomerUser implements Serializable {

	private String chiaveTabellaRelazioneUserCliente; // SEUTEC_CKEYUTEC
	private String operatoreInserimento; // SEUTEC_COPERINS
	private Date dataInserimento;// SEUTEC_GDATAINS
	private String operatoreUltimaVariazione; // SEUTEC_COPEUVAR
	private Date dataUltimaVariazione;// SEUTEC_GDATUVAR
	private String chiavePrimariaDelCliente;// SECUST_CKEYCUST
	// private String chiavePrimariaTabellaUsers;//SEUSER_CKEYUSER
	private String username;// SEUSER_CUSERNAME
	private String codiceFiscale;// SEUSER_CCODFISC

	public CustomerUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerUser(String chiaveTabellaRelazioneUserCliente,
			String operatoreInserimento, Date dataInserimento,
			String operatoreUltimaVariazione, Date dataUltimaVariazione,
			String chiavePrimariaDelCliente, String username,
			String codiceFiscale) {
		super();
		this.chiaveTabellaRelazioneUserCliente = chiaveTabellaRelazioneUserCliente;
		this.operatoreInserimento = operatoreInserimento;
		this.dataInserimento = dataInserimento;
		this.operatoreUltimaVariazione = operatoreUltimaVariazione;
		this.dataUltimaVariazione = dataUltimaVariazione;
		this.chiavePrimariaDelCliente = chiavePrimariaDelCliente;
		this.username = username;
		this.codiceFiscale = codiceFiscale;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public void init() {
		this.chiaveTabellaRelazioneUserCliente = " "; // SEUTEC_CKEYUTEC
		this.operatoreInserimento = " "; // SEUTEC_COPERINS
		this.dataInserimento = new Date();// SEUTEC_GDATAINS
		this.operatoreUltimaVariazione = " "; // SEUTEC_COPEUVAR
		this.dataUltimaVariazione = new Date();// SEUTEC_GDATUVAR
		this.chiavePrimariaDelCliente = " ";// SECUST_CKEYCUST
		this.username = " ";// SEUSER_CUSERNAME
		this.codiceFiscale = " ";// SEUSER_CCODFISC

	}

}
