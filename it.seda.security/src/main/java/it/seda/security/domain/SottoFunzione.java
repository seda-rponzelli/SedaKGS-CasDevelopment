package it.seda.security.domain;

import java.util.Date;

public class SottoFunzione {

	private String chiavePrimariaDelleSottoFunzioni;//SESFUN_CKEYSFUN
	private String codiceSottoFunzione;//SESFUN_CCODSFU
	private String descrizioneSottoFunzione;//SESFUN_CDESCSFU
	private String operatoreInserimento;//SESFUN_COPERINS
	private Date  dataInserimento;//SESFUN_GDATAINS
	private String operatoreUltimaVariazione;//SESFUN_COPEUVAR
	private Date dataUltimaVariazione;//SESFUN_GDATUVAR
	
	
	
	
	public SottoFunzione() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SottoFunzione(String chiavePrimariaDelleSottoFunzioni,
			String codiceSottoFunzione, String descrizioneSottoFunzione,
			String operatoreInserimento, Date dataInserimento,
			String operatoreUltimaVariazione, Date dataUltimaVariazione) {
		super();
		this.chiavePrimariaDelleSottoFunzioni = chiavePrimariaDelleSottoFunzioni;
		this.codiceSottoFunzione = codiceSottoFunzione;
		this.descrizioneSottoFunzione = descrizioneSottoFunzione;
		this.operatoreInserimento = operatoreInserimento;
		this.dataInserimento = dataInserimento;
		this.operatoreUltimaVariazione = operatoreUltimaVariazione;
		this.dataUltimaVariazione = dataUltimaVariazione;
	}
	public String getChiavePrimariaDelleSottoFunzioni() {
		return chiavePrimariaDelleSottoFunzioni;
	}
	public void setChiavePrimariaDelleSottoFunzioni(
			String chiavePrimariaDelleSottoFunzioni) {
		this.chiavePrimariaDelleSottoFunzioni = chiavePrimariaDelleSottoFunzioni;
	}
	public String getCodiceSottoFunzione() {
		return codiceSottoFunzione;
	}
	public void setCodiceSottoFunzione(String codiceSottoFunzione) {
		this.codiceSottoFunzione = codiceSottoFunzione;
	}
	public String getDescrizioneSottoFunzione() {
		return descrizioneSottoFunzione;
	}
	public void setDescrizioneSottoFunzione(String descrizioneSottoFunzione) {
		this.descrizioneSottoFunzione = descrizioneSottoFunzione;
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
		return "Sottofunzione [chiavePrimariaDelleSottoFunzioni="
				+ chiavePrimariaDelleSottoFunzioni + ", codiceSottoFunzione="
				+ codiceSottoFunzione + ", descrizioneSottoFunzione="
				+ descrizioneSottoFunzione + ", operatoreInserimento="
				+ operatoreInserimento + ", dataInserimento=" + dataInserimento
				+ ", operatoreUltimaVariazione=" + operatoreUltimaVariazione
				+ ", dataUltimaVariazione=" + dataUltimaVariazione + "]";
	}
	
	
	public void init(){
		this.chiavePrimariaDelleSottoFunzioni = " ";
		this.codiceSottoFunzione = " ";
		this.descrizioneSottoFunzione = " ";
		this.operatoreInserimento = " ";
		this.dataInserimento = new Date();
		this.operatoreUltimaVariazione = " ";
		this.dataUltimaVariazione = new Date();
	}
	
	
}
