package it.seda.security.domain;

import java.util.Date;

public class Group {

//	private int id;
//	private String groupName;
//	private String groupDescription;
	
	
	private String chiavePrimariaDellaTabellaGruppi;//SEGRUP_CKEYGRUP
	private String chiaveGruppo;//SEGRUP_CCODGRUPPO
	private String descrizioneGruppo;//SEGRUP_CDESGRUPPO
	private String operatoreInserimento;//SEGRUP_COPERINS
	private Date dataInserimento;//SEGRUP_GDATAINS
	private String operatoreUltimaVariazione;//SEGRUP_COPEUVAR
	private Date dataUltimaVariazione;//SEGRUP_GDATUVAR
	private String chiavePrimariaDelCliente;//SECUST_CKEYCUST
	
	
	
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Group(String chiavePrimariaDellaTabellaGruppi, String chiaveGruppo,
			String descrizioneGruppo, String operatoreInserimento,
			Date dataInserimento, String operatoreUltimaVariazione,
			Date dataUltimaVariazione, String chiavePrimariaDelCliente) {
		super();
		this.chiavePrimariaDellaTabellaGruppi = chiavePrimariaDellaTabellaGruppi;
		this.chiaveGruppo = chiaveGruppo;
		this.descrizioneGruppo = descrizioneGruppo;
		this.operatoreInserimento = operatoreInserimento;
		this.dataInserimento = dataInserimento;
		this.operatoreUltimaVariazione = operatoreUltimaVariazione;
		this.dataUltimaVariazione = dataUltimaVariazione;
		this.chiavePrimariaDelCliente = chiavePrimariaDelCliente;
	}
	public String getChiavePrimariaDellaTabellaGruppi() {
		return chiavePrimariaDellaTabellaGruppi;
	}
	public void setChiavePrimariaDellaTabellaGruppi(
			String chiavePrimariaDellaTabellaGruppi) {
		this.chiavePrimariaDellaTabellaGruppi = chiavePrimariaDellaTabellaGruppi;
	}
	public String getChiaveGruppo() {
		return chiaveGruppo;
	}
	public void setChiaveGruppo(String chiaveGruppo) {
		this.chiaveGruppo = chiaveGruppo;
	}
	public String getDescrizioneGruppo() {
		return descrizioneGruppo;
	}
	public void setDescrizioneGruppo(String descrizioneGruppo) {
		this.descrizioneGruppo = descrizioneGruppo;
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
	@Override
	public String toString() {
		return "Group [chiavePrimariaDellaTabellaGruppi="
				+ chiavePrimariaDellaTabellaGruppi + ", chiaveGruppo="
				+ chiaveGruppo + ", descrizioneGruppo=" + descrizioneGruppo
				+ ", operatoreInserimento=" + operatoreInserimento
				+ ", dataInserimento=" + dataInserimento
				+ ", operatoreUltimaVariazione=" + operatoreUltimaVariazione
				+ ", dataUltimaVariazione=" + dataUltimaVariazione
				+ ", chiavePrimariaDelCliente=" + chiavePrimariaDelCliente
				+ "]";
	}
	
	
	
}
