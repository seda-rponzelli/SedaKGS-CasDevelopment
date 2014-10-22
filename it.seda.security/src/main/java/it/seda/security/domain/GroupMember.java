/**
 * 
 */
package it.seda.security.domain;

import java.util.Date;

/**
 * @author f.ricci
 *
 */
public class GroupMember {

//	private String groupName;
//	private String username;

	
	private String chiavePrimariaTabellaGruppiUtenti;// SEGRUU_CKEYGRUU
	private String operatoreInserimento;// SEGRUU_COPERINS
	private Date dataInserimento;// SEGRUU_GDATAINS
	private String operatoreUltimaVariazione;// SEGRUU_COPEUVAR
	private Date dataUltimaVariazione;// SEGRUU_GDATUVAR
	private String chiavePrimariaDellaTabellaGruppi;// SEGRUP_CKEYGRUP
	private String chiavePrimariaDellaTabellaUtentiClienti;// SEUTEC_CKEYUTEC
	
	
	
	public GroupMember() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroupMember(String chiavePrimariaTabellaGruppiUtenti,
			String operatoreInserimento, Date dataInserimento,
			String operatoreUltimaVariazione, Date dataUltimaVariazione,
			String chiavePrimariaDellaTabellaGruppi,
			String chiavePrimariaDellaTabellaUtentiClienti) {
		super();
		this.chiavePrimariaTabellaGruppiUtenti = chiavePrimariaTabellaGruppiUtenti;
		this.operatoreInserimento = operatoreInserimento;
		this.dataInserimento = dataInserimento;
		this.operatoreUltimaVariazione = operatoreUltimaVariazione;
		this.dataUltimaVariazione = dataUltimaVariazione;
		this.chiavePrimariaDellaTabellaGruppi = chiavePrimariaDellaTabellaGruppi;
		this.chiavePrimariaDellaTabellaUtentiClienti = chiavePrimariaDellaTabellaUtentiClienti;
	}
	public String getChiavePrimariaTabellaGruppiUtenti() {
		return chiavePrimariaTabellaGruppiUtenti;
	}
	public void setChiavePrimariaTabellaGruppiUtenti(
			String chiavePrimariaTabellaGruppiUtenti) {
		this.chiavePrimariaTabellaGruppiUtenti = chiavePrimariaTabellaGruppiUtenti;
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
	public String getChiavePrimariaDellaTabellaGruppi() {
		return chiavePrimariaDellaTabellaGruppi;
	}
	public void setChiavePrimariaDellaTabellaGruppi(
			String chiavePrimariaDellaTabellaGruppi) {
		this.chiavePrimariaDellaTabellaGruppi = chiavePrimariaDellaTabellaGruppi;
	}
	public String getChiavePrimariaDellaTabellaUtentiClienti() {
		return chiavePrimariaDellaTabellaUtentiClienti;
	}
	public void setChiavePrimariaDellaTabellaUtentiClienti(
			String chiavePrimariaDellaTabellaUtentiClienti) {
		this.chiavePrimariaDellaTabellaUtentiClienti = chiavePrimariaDellaTabellaUtentiClienti;
	}
	@Override
	public String toString() {
		return "GroupMember [chiavePrimariaTabellaGruppiUtenti="
				+ chiavePrimariaTabellaGruppiUtenti + ", operatoreInserimento="
				+ operatoreInserimento + ", dataInserimento=" + dataInserimento
				+ ", operatoreUltimaVariazione=" + operatoreUltimaVariazione
				+ ", dataUltimaVariazione=" + dataUltimaVariazione
				+ ", chiavePrimariaDellaTabellaGruppi="
				+ chiavePrimariaDellaTabellaGruppi
				+ ", chiavePrimariaDellaTabellaUtentiClienti="
				+ chiavePrimariaDellaTabellaUtentiClienti + "]";
	}
	
	public void init(){
		this.chiavePrimariaTabellaGruppiUtenti=" ";// SEGRUU_CKEYGRUU
		this.operatoreInserimento=" ";// SEGRUU_COPERINS
		this.dataInserimento=new Date();// SEGRUU_GDATAINS
		this.operatoreUltimaVariazione=" ";// SEGRUU_COPEUVAR
		this.dataUltimaVariazione=new Date();// SEGRUU_GDATUVAR
		this.chiavePrimariaDellaTabellaGruppi=" ";// SEGRUP_CKEYGRUP
		this.chiavePrimariaDellaTabellaUtentiClienti=" ";// SEUTEC_CKEYUTEC
		
	}

}
