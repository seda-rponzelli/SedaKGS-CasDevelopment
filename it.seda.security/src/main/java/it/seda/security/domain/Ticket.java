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
public class Ticket implements Serializable {

//	private String id;
//	private String username;
//	private String applicationId;
//	private Date creationDate;
//	private Date expirationDate;
	
	
	private String chiavePrimariaDellaTabellaDeiTicket;//SETICK_CKEYTICK
	private String username;//SETICK_CUSERNAME
	private String codiceFiscaleDelDelegatoPersonaFisica;//SETICK_CCODFISC
	private Date dataCreazioneTickets;//ETICK_GDATCREA
	private Date dataScadenzaTicket;//SETICK_GDATSCAD
	private String operatoreInserimento;//SETICK_COPERINS
	private Date dataInserimento;//SETICK_GDATAINS
	private String operatoreUltimaVariazione;//SETICK_COPEUVAR
	private Date dataUltimaVariazione;//SETICK_GDATUVAR
	private String chiavePrimariaDelleApplicazioni;//SEAPPL_CKEYAPPL
	
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Ticket(String chiavePrimariaDellaTabellaDeiTicket, String username,
			String codiceFiscaleDelDelegatoPersonaFisica,
			Date dataCreazioneTickets, Date dataScadenzaTicket,
			String operatoreInserimento, Date dataInserimento,
			String operatoreUltimaVariazione, Date dataUltimaVariazione,
			String chiavePrimariaDelleApplicazioni) {
		super();
		this.chiavePrimariaDellaTabellaDeiTicket = chiavePrimariaDellaTabellaDeiTicket;
		this.username = username;
		this.codiceFiscaleDelDelegatoPersonaFisica = codiceFiscaleDelDelegatoPersonaFisica;
		this.dataCreazioneTickets = dataCreazioneTickets;
		this.dataScadenzaTicket = dataScadenzaTicket;
		this.operatoreInserimento = operatoreInserimento;
		this.dataInserimento = dataInserimento;
		this.operatoreUltimaVariazione = operatoreUltimaVariazione;
		this.dataUltimaVariazione = dataUltimaVariazione;
		this.chiavePrimariaDelleApplicazioni = chiavePrimariaDelleApplicazioni;
	}



	public String getChiavePrimariaDellaTabellaDeiTicket() {
		return chiavePrimariaDellaTabellaDeiTicket;
	}
	public void setChiavePrimariaDellaTabellaDeiTicket(
			String chiavePrimariaDellaTabellaDeiTicket) {
		this.chiavePrimariaDellaTabellaDeiTicket = chiavePrimariaDellaTabellaDeiTicket;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCodiceFiscaleDelDelegatoPersonaFisica() {
		return codiceFiscaleDelDelegatoPersonaFisica;
	}
	public void setCodiceFiscaleDelDelegatoPersonaFisica(
			String codiceFiscaleDelDelegatoPersonaFisica) {
		this.codiceFiscaleDelDelegatoPersonaFisica = codiceFiscaleDelDelegatoPersonaFisica;
	}
	public Date getDataCreazioneTickets() {
		return dataCreazioneTickets;
	}
	public void setDataCreazioneTickets(Date dataCreazioneTickets) {
		this.dataCreazioneTickets = dataCreazioneTickets;
	}
	public Date getDataScadenzaTicket() {
		return dataScadenzaTicket;
	}
	public void setDataScadenzaTicket(Date dataScadenzaTicket) {
		this.dataScadenzaTicket = dataScadenzaTicket;
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
	@Override
	public String toString() {
		return "Ticket [chiavePrimariaDellaTabellaDeiTicket="
				+ chiavePrimariaDellaTabellaDeiTicket + ", username="
				+ username + ", codiceFiscaleDelDelegatoPersonaFisica="
				+ codiceFiscaleDelDelegatoPersonaFisica
				+ ", dataCreazioneTickets=" + dataCreazioneTickets
				+ ", dataScadenzaTicket=" + dataScadenzaTicket
				+ ", operatoreInserimento=" + operatoreInserimento
				+ ", dataInserimento=" + dataInserimento
				+ ", operatoreUltimaVariazione=" + operatoreUltimaVariazione
				+ ", dataUltimaVariazione=" + dataUltimaVariazione
				+ ", chiavePrimariaDelleApplicazioni="
				+ chiavePrimariaDelleApplicazioni + "]";
	}
	
	
	public void init(){
		this.chiavePrimariaDellaTabellaDeiTicket = " ";
		this.username = " ";
		this.codiceFiscaleDelDelegatoPersonaFisica = " ";
		this.dataCreazioneTickets = new Date();
		this.dataScadenzaTicket = new Date();
		this.operatoreInserimento = " ";
		this.dataInserimento = new Date();
		this.operatoreUltimaVariazione = " ";
		this.dataUltimaVariazione = new Date();
		this.chiavePrimariaDelleApplicazioni = " ";
		
	}
	

	
}
