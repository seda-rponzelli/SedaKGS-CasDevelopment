package it.seda.security.domain;

import java.util.Date;

public class LegameFunzione {
	
	private String chiavePrimariaDelLegameApplicazioniFunzioniSottofunzioni;//SELFNS_CKEYLFNS
	private String operatoreInserimento;//SELFNS_COPERINS
	private Date dataInserimento;//SELFNS_GDATAINS
	private String operatoreUltimaVariazione;//SELFNS_COPEUVAR
	private Date dataUltimaVariazione;//SELFNS_GDATUVAR
	private String chiavePrimariaDelleApplicazioni;//SEAPPL_CKEYAPPL
	private String chiavePrimariaDeiModuliDelleApplicazioni;//SEMODU_CKEYMODU
	private String chiavePrimariaDelleFunzioni;//SEFUNZ_CKEYFUNZ
	private String chiavePrimariaDelleSottoFunzioni;//SESFUN_CKEYSFUN
	
	
	
	
	public LegameFunzione() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LegameFunzione(
			String chiavePrimariaDelLegameApplicazioniFunzioniSottofunzioni,
			String operatoreInserimento, Date dataInserimento,
			String opperatoreUltimaVariazione, Date dataUltimaVariazione,
			String chiavePrimariaDelleApplicazioni,
			String chiavePrimariaDeiModuliDelleApplicazioni,
			String chiavePrimariaDelleFunzioni,
			String chiavePrimariaDelleSottoFunzioni) {
		super();
		this.chiavePrimariaDelLegameApplicazioniFunzioniSottofunzioni = chiavePrimariaDelLegameApplicazioniFunzioniSottofunzioni;
		this.operatoreInserimento = operatoreInserimento;
		this.dataInserimento = dataInserimento;
		this.operatoreUltimaVariazione = opperatoreUltimaVariazione;
		this.dataUltimaVariazione = dataUltimaVariazione;
		this.chiavePrimariaDelleApplicazioni = chiavePrimariaDelleApplicazioni;
		this.chiavePrimariaDeiModuliDelleApplicazioni = chiavePrimariaDeiModuliDelleApplicazioni;
		this.chiavePrimariaDelleFunzioni = chiavePrimariaDelleFunzioni;
		this.chiavePrimariaDelleSottoFunzioni = chiavePrimariaDelleSottoFunzioni;
	}
	public String getChiavePrimariaDelLegameApplicazioniFunzioniSottofunzioni() {
		return chiavePrimariaDelLegameApplicazioniFunzioniSottofunzioni;
	}
	public void setChiavePrimariaDelLegameApplicazioniFunzioniSottofunzioni(
			String chiavePrimariaDelLegameApplicazioniFunzioniSottofunzioni) {
		this.chiavePrimariaDelLegameApplicazioniFunzioniSottofunzioni = chiavePrimariaDelLegameApplicazioniFunzioniSottofunzioni;
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
	public String getOpperatoreUltimaVariazione() {
		return operatoreUltimaVariazione;
	}
	public void setOpperatoreUltimaVariazione(String opperatoreUltimaVariazione) {
		this.operatoreUltimaVariazione = opperatoreUltimaVariazione;
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
	public String getChiavePrimariaDeiModuliDelleApplicazioni() {
		return chiavePrimariaDeiModuliDelleApplicazioni;
	}
	public void setChiavePrimariaDeiModuliDelleApplicazioni(
			String chiavePrimariaDeiModuliDelleApplicazioni) {
		this.chiavePrimariaDeiModuliDelleApplicazioni = chiavePrimariaDeiModuliDelleApplicazioni;
	}
	public String getChiavePrimariaDelleFunzioni() {
		return chiavePrimariaDelleFunzioni;
	}
	public void setChiavePrimariaDelleFunzioni(String chiavePrimariaDelleFunzioni) {
		this.chiavePrimariaDelleFunzioni = chiavePrimariaDelleFunzioni;
	}
	public String getChiavePrimariaDelleSottoFunzioni() {
		return chiavePrimariaDelleSottoFunzioni;
	}
	public void setChiavePrimariaDelleSottoFunzioni(
			String chiavePrimariaDelleSottoFunzioni) {
		this.chiavePrimariaDelleSottoFunzioni = chiavePrimariaDelleSottoFunzioni;
	}
	@Override
	public String toString() {
		return "LegameFunzioni [chiavePrimariaDelLegameApplicazioniFunzioniSottofunzioni="
				+ chiavePrimariaDelLegameApplicazioniFunzioniSottofunzioni
				+ ", operatoreInserimento="
				+ operatoreInserimento
				+ ", dataInserimento="
				+ dataInserimento
				+ ", opperatoreUltimaVariazione="
				+ operatoreUltimaVariazione
				+ ", dataUltimaVariazione="
				+ dataUltimaVariazione
				+ ", chiavePrimariaDelleApplicazioni="
				+ chiavePrimariaDelleApplicazioni
				+ ", chiavePrimariaDeiModuliDelleApplicazioni="
				+ chiavePrimariaDeiModuliDelleApplicazioni
				+ ", chiavePrimariaDelleFunzioni="
				+ chiavePrimariaDelleFunzioni
				+ ", chiavePrimariaDelleSottoFunzioni="
				+ chiavePrimariaDelleSottoFunzioni + "]";
	}
	
	
	public void init(){
		this.chiavePrimariaDelLegameApplicazioniFunzioniSottofunzioni = " ";
		this.operatoreInserimento = " ";
		this.dataInserimento = new Date();
		this.operatoreUltimaVariazione = " ";
		this.dataUltimaVariazione = new Date();
		this.chiavePrimariaDelleApplicazioni = " ";
		this.chiavePrimariaDeiModuliDelleApplicazioni = " ";
		this.chiavePrimariaDelleFunzioni = " ";
		this.chiavePrimariaDelleSottoFunzioni = " ";
		
	}
	

}
