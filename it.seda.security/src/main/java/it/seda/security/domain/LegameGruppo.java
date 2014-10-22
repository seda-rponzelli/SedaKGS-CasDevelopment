package it.seda.security.domain;

import java.util.Date;

public class LegameGruppo {
	
	private String chiavePrimariaLegameGruppoApplicazioniModuloFunzioniSottoFunzioni;//SELGFN_CKEYLGFN
	private String operatoreInserimento;//SELGFN_COPERINS
	private Date dataInserimento;//SELGFN_GDATAINS
	private String operatoreUltimaVariazione;//SELGFN_COPEUVAR
	private Date dataUltimaVariazione;//SELGFN_GDATUVAR
	private String chiavePrimariaDellaTabellaGruppi;//SEGRUP_CKEYGRUP
	private String chiavePrimariaLegameApplicazioniFunzioniSottofunzioni;//SELFNS_CKEYLFNS
	
	
	
	public LegameGruppo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public LegameGruppo(
			String chiavePrimariaLegameGruppoApplicazioniModuloFunzioniSottoFunzioni,
			String operatoreInserimento, Date dataInserimento,
			String operatoreUltimaVariazione, Date dataUltimaVariazione,
			String chiavePrimariaDellaTabellaGruppi,
			String chiavePrimariaLegameApplicazioniFunzioniSottofunzioni) {
		super();
		this.chiavePrimariaLegameGruppoApplicazioniModuloFunzioniSottoFunzioni = chiavePrimariaLegameGruppoApplicazioniModuloFunzioniSottoFunzioni;
		this.operatoreInserimento = operatoreInserimento;
		this.dataInserimento = dataInserimento;
		this.operatoreUltimaVariazione = operatoreUltimaVariazione;
		this.dataUltimaVariazione = dataUltimaVariazione;
		this.chiavePrimariaDellaTabellaGruppi = chiavePrimariaDellaTabellaGruppi;
		this.chiavePrimariaLegameApplicazioniFunzioniSottofunzioni = chiavePrimariaLegameApplicazioniFunzioniSottofunzioni;
	}



	public String getChiavePrimariaLegameGruppoApplicazioniModuloFunzioniSottoFunzioni() {
		return chiavePrimariaLegameGruppoApplicazioniModuloFunzioniSottoFunzioni;
	}



	public void setChiavePrimariaLegameGruppoApplicazioniModuloFunzioniSottoFunzioni(
			String chiavePrimariaLegameGruppoApplicazioniModuloFunzioniSottoFunzioni) {
		this.chiavePrimariaLegameGruppoApplicazioniModuloFunzioniSottoFunzioni = chiavePrimariaLegameGruppoApplicazioniModuloFunzioniSottoFunzioni;
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



	public String getChiavePrimariaLegameApplicazioniFunzioniSottofunzioni() {
		return chiavePrimariaLegameApplicazioniFunzioniSottofunzioni;
	}



	public void setChiavePrimariaLegameApplicazioniFunzioniSottofunzioni(
			String chiavePrimariaLegameApplicazioniFunzioniSottofunzioni) {
		this.chiavePrimariaLegameApplicazioniFunzioniSottofunzioni = chiavePrimariaLegameApplicazioniFunzioniSottofunzioni;
	}



	@Override
	public String toString() {
		return "LegameGruppo [chiavePrimariaLegameGruppoApplicazioniModuloFunzioniSottoFunzioni="
				+ chiavePrimariaLegameGruppoApplicazioniModuloFunzioniSottoFunzioni
				+ ", operatoreInserimento="
				+ operatoreInserimento
				+ ", dataInserimento="
				+ dataInserimento
				+ ", operatoreUltimaVariazione="
				+ operatoreUltimaVariazione
				+ ", dataUltimaVariazione="
				+ dataUltimaVariazione
				+ ", chiavePrimariaDellaTabellaGruppi="
				+ chiavePrimariaDellaTabellaGruppi
				+ ", chiavePrimariaLegameApplicazioniFunzioniSottofunzioni="
				+ chiavePrimariaLegameApplicazioniFunzioniSottofunzioni + "]";
	}
	
	
	
	public void init(){
		this.chiavePrimariaLegameGruppoApplicazioniModuloFunzioniSottoFunzioni = " ";
		this.operatoreInserimento = " ";
		this.dataInserimento = new Date();
		this.operatoreUltimaVariazione = " ";
		this.dataUltimaVariazione = new Date();
		this.chiavePrimariaDellaTabellaGruppi = " ";
		this.chiavePrimariaLegameApplicazioniFunzioniSottofunzioni = " ";
		
	}
	
	
	

}
