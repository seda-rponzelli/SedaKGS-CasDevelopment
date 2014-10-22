package it.seda.security.domain;

import java.util.Date;

public class Funzione {
	
	
	private String chiavePrimariaDelleFunzioni;//SEFUNZ_CKEYFUNZ
	private String codiceFunzione;//SEFUNZ_CCODFUN
	private String descrizioneFunzione;//SEFUNZ_CDESCFUN
	private String operatoreInserimento;//SEFUNZ_COPERINS
	private Date dataInserimento;//SEFUNZ_GDATAINS
	private String operatoreUltimaVariazione;//SEFUNZ_COPEUVAR
	private Date dataUltimaVariazione;//SEFUNZ_GDATUVAR
	
	
	
	
	public Funzione() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Funzione(String chiavePrimariaDelleFunzioni, String codiceFunzione,
			String descrizioneFunzione, String operatoreInserimento,
			Date dataInserimento, String operatoreUltimaVariazione,
			Date dataUltimaVariazione) {
		super();
		this.chiavePrimariaDelleFunzioni = chiavePrimariaDelleFunzioni;
		this.codiceFunzione = codiceFunzione;
		this.descrizioneFunzione = descrizioneFunzione;
		this.operatoreInserimento = operatoreInserimento;
		this.dataInserimento = dataInserimento;
		this.operatoreUltimaVariazione = operatoreUltimaVariazione;
		this.dataUltimaVariazione = dataUltimaVariazione;
	}
	public String getChiavePrimariaDelleFunzioni() {
		return chiavePrimariaDelleFunzioni;
	}
	public void setChiavePrimariaDelleFunzioni(String chiavePrimariaDelleFunzioni) {
		this.chiavePrimariaDelleFunzioni = chiavePrimariaDelleFunzioni;
	}
	public String getCodiceFunzione() {
		return codiceFunzione;
	}
	public void setCodiceFunzione(String codiceFunzione) {
		this.codiceFunzione = codiceFunzione;
	}
	public String getDescrizioneFunzione() {
		return descrizioneFunzione;
	}
	public void setDescrizioneFunzione(String descrizioneFunzione) {
		this.descrizioneFunzione = descrizioneFunzione;
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
	@Override
	public String toString() {
		return "Funzione [chiavePrimariaDelleFunzioni="
				+ chiavePrimariaDelleFunzioni + ", codiceFunzione="
				+ codiceFunzione + ", descrizioneFunzione="
				+ descrizioneFunzione + ", operatoreInserimento="
				+ operatoreInserimento + ", dataInserimento=" + dataInserimento
				+ ", operatoreUltimaVariazione=" + operatoreUltimaVariazione
				+ ", dataUltimaVariazione=" + dataUltimaVariazione + "]";
	}

	public void init(){
		
		this.chiavePrimariaDelleFunzioni = " ";
		this.codiceFunzione = " ";
		this.descrizioneFunzione = " ";
		this.operatoreInserimento = " ";
		this.dataInserimento = new Date();
		this.operatoreUltimaVariazione = " ";
		this.dataUltimaVariazione = new Date();
		
		
	}
	
	
	
}
