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
public class CustomerApplication implements Serializable {

	
	private String chiavePrimariaDelleApplicazioniCliente;//SEAPPC_CKEYAPPC
	private String urlApplicazioneDelCliente;//SEAPPC_CURLAPPLCLIENTE
	private String operatoreInserimento;//SEAPPC_COPERINS
	private Date dataInserimento;//SEAPPC_GDATAINS
	private String operatoreUltimaVariazione;//SEAPPC_COPEUVAR
	private Date dataUltimaVariazione;//SEAPPC_GDATUVAR
	private String chiavePrimariaDelleApplicazioni;//SEAPPL_CKEYAPPL
	private String chiavePrimariaDelCliente;//SECUST_CKEYCUST
	
	
	
	
	
	public CustomerApplication(String chiavePrimariaDelleApplicazioniCliente,
			String urlApplicazioneDelCliente, String operatoreInserimento,
			Date dataInserimento, String operatoreUltimaVariazione,
			Date dataUltimaVariazione, String chiavePrimariaDelleApplicazioni,
			String chiavePrimariaDelCliente) {
		super();
		this.chiavePrimariaDelleApplicazioniCliente = chiavePrimariaDelleApplicazioniCliente;
		this.urlApplicazioneDelCliente = urlApplicazioneDelCliente;
		this.operatoreInserimento = operatoreInserimento;
		this.dataInserimento = dataInserimento;
		this.operatoreUltimaVariazione = operatoreUltimaVariazione;
		this.dataUltimaVariazione = dataUltimaVariazione;
		this.chiavePrimariaDelleApplicazioni = chiavePrimariaDelleApplicazioni;
		this.chiavePrimariaDelCliente = chiavePrimariaDelCliente;
	}
	public String getChiavePrimariaDelleApplicazioniCliente() {
		return chiavePrimariaDelleApplicazioniCliente;
	}
	public void setChiavePrimariaDelleApplicazioniCliente(
			String chiavePrimariaDelleApplicazioniCliente) {
		this.chiavePrimariaDelleApplicazioniCliente = chiavePrimariaDelleApplicazioniCliente;
	}
	public String getUrlApplicazioneDelCliente() {
		return urlApplicazioneDelCliente;
	}
	public void setUrlApplicazioneDelCliente(String urlApplicazioneDelCliente) {
		this.urlApplicazioneDelCliente = urlApplicazioneDelCliente;
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
	public String getChiavePrimariaDelleApplicazioni() {
		return chiavePrimariaDelleApplicazioni;
	}
	public void setChiavePrimariaDelleApplicazioni(
			String chiavePrimariaDelleApplicazioni) {
		this.chiavePrimariaDelleApplicazioni = chiavePrimariaDelleApplicazioni;
	}
	public String getChiavePrimariaDelCliente() {
		return chiavePrimariaDelCliente;
	}
	public void setChiavePrimariaDelCliente(String chiavePrimariaDelCliente) {
		this.chiavePrimariaDelCliente = chiavePrimariaDelCliente;
	}
	@Override
	public String toString() {
		return "CustomerApplication [chiavePrimariaDelleApplicazioniCliente="
				+ chiavePrimariaDelleApplicazioniCliente
				+ ", urlApplicazioneDelCliente=" + urlApplicazioneDelCliente
				+ ", operatoreInserimento=" + operatoreInserimento
				+ ", dataInserimento=" + dataInserimento
				+ ", operatoreUltimaVariazione=" + operatoreUltimaVariazione
				+ ", dataUltimaVariazione=" + dataUltimaVariazione
				+ ", chiavePrimariaDelleApplicazioni="
				+ chiavePrimariaDelleApplicazioni
				+ ", chiavePrimariaDelCliente=" + chiavePrimariaDelCliente
				+ "]";
	}
	
	
}
