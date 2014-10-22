package it.seda.security.domain;

import java.util.Date;

public class Modulo {
	
	private String chiavePrimariaDeiModuliDelleApplicazioni;//SEMODU_CKEYMODU
	private String codiceModulo;//SEMODU_CCODMODU
	private String descrizioneModulo;//SEMODU_CDESCMODU
	private String operatoreInserimento;//SEMODU_COPERINS
	private Date dataInserimento;//SEMODU_GDATAINS
	private String operatoreUltimaVariazione;//SEMODU_COPEUVAR
	private Date dataUltimaVariazione;//SEMODU_GDATUVAR
	
	
	
	
	
	public Modulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Modulo(String chiavePrimariaDeiModuliDelleApplicazioni,
			String codiceModulo, String descrizioneModulo,
			String operatoreInserimento, Date dataInserimento,
			String operatoreUltimaVariazione, Date dataUltimaVariazione) {
		super();
		this.chiavePrimariaDeiModuliDelleApplicazioni = chiavePrimariaDeiModuliDelleApplicazioni;
		this.codiceModulo = codiceModulo;
		this.descrizioneModulo = descrizioneModulo;
		this.operatoreInserimento = operatoreInserimento;
		this.dataInserimento = dataInserimento;
		this.operatoreUltimaVariazione = operatoreUltimaVariazione;
		this.dataUltimaVariazione = dataUltimaVariazione;
	}
	public String getChiavePrimariaDeiModuliDelleApplicazioni() {
		return chiavePrimariaDeiModuliDelleApplicazioni;
	}
	public void setChiavePrimariaDeiModuliDelleApplicazioni(
			String chiavePrimariaDeiModuliDelleApplicazioni) {
		this.chiavePrimariaDeiModuliDelleApplicazioni = chiavePrimariaDeiModuliDelleApplicazioni;
	}
	public String getCodiceModulo() {
		return codiceModulo;
	}
	public void setCodiceModulo(String codiceModulo) {
		this.codiceModulo = codiceModulo;
	}
	public String getDescrizioneModulo() {
		return descrizioneModulo;
	}
	public void setDescrizioneModulo(String descrizioneModulo) {
		this.descrizioneModulo = descrizioneModulo;
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
		return "Modulo [chiavePrimariaDeiModuliDelleApplicazioni="
				+ chiavePrimariaDeiModuliDelleApplicazioni + ", codiceModulo="
				+ codiceModulo + ", descrizioneModulo=" + descrizioneModulo
				+ ", operatoreInserimento=" + operatoreInserimento
				+ ", dataInserimento=" + dataInserimento
				+ ", operatoreUltimaVariazione=" + operatoreUltimaVariazione
				+ ", dataUltimaVariazione=" + dataUltimaVariazione + "]";
	}
	
	
	public void init(){
		
		this.chiavePrimariaDeiModuliDelleApplicazioni = " ";
		this.codiceModulo = " ";
		this.descrizioneModulo = " ";
		this.operatoreInserimento = " ";
		this.dataInserimento = new Date();
		this.operatoreUltimaVariazione = " ";
		this.dataUltimaVariazione = new Date();
		
	}
	

}
