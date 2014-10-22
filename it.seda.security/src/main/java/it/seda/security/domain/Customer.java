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
public class Customer implements Serializable {

	private String chiavePrimariaCliente;  //SECUST_CKEYCUST
	private String descrizioneCliente;     //SECUST_CDESCCUS
	private String codiceCliente;          //SECUST_CCODCUS
	private String flagClienteCentroServizio; //SECUST_CCUSCENSER
	private String operatoreDiInserimento;    //SECUST_COPERINS
	private Date dataDiInserimento;           //SECUST_GDATAINS
	private String operatoreDiUltimaVariazione; //SECUST_COPEUVAR
	private Date dataDiUltimaVariazione; //SECUST_GDATUVAR
	
	
   	
	
    	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String chiavePrimariaCliente, String descrizioneCliente,
			String codiceCliente, String flagClienteCentroServizio,
			String operatoreDiInserimento, Date dataDiInserimento,
			String operatoreDiUltimaVariazione, Date dataDiUltimaVariazione) {
		super();
		this.chiavePrimariaCliente = chiavePrimariaCliente;
		this.descrizioneCliente = descrizioneCliente;
		this.codiceCliente = codiceCliente;
		this.flagClienteCentroServizio = flagClienteCentroServizio;
		this.operatoreDiInserimento = operatoreDiInserimento;
		this.dataDiInserimento = dataDiInserimento;
		this.operatoreDiUltimaVariazione = operatoreDiUltimaVariazione;
		this.dataDiUltimaVariazione = dataDiUltimaVariazione;
	}
	public String getChiavePrimariaCliente() {
		return chiavePrimariaCliente;
	}
	public void setChiavePrimariaCliente(String chiavePrimariaCliente) {
		this.chiavePrimariaCliente = chiavePrimariaCliente;
	}
	public String getDescrizioneCliente() {
		return descrizioneCliente;
	}
	public void setDescrizioneCliente(String descrizioneCliente) {
		this.descrizioneCliente = descrizioneCliente;
	}
	public String getCodiceCliente() {
		return codiceCliente;
	}
	public void setCodiceCliente(String codiceCliente) {
		this.codiceCliente = codiceCliente;
	}
	public String getFlagClienteCentroServizio() {
		return flagClienteCentroServizio;
	}
	public void setFlagClienteCentroServizio(String flagClienteCentroServizio) {
		this.flagClienteCentroServizio = flagClienteCentroServizio;
	}
	public String getOperatoreDiInserimento() {
		return operatoreDiInserimento;
	}
	public void setOperatoreDiInserimento(String operatoreDiInserimento) {
		this.operatoreDiInserimento = operatoreDiInserimento;
	}
	public Date getDataDiInserimento() {
		return dataDiInserimento;
	}
	public void setDataDiInserimento(Date dataDiInserimento) {
		this.dataDiInserimento = dataDiInserimento;
	}
	public String getOperatoreDiUltimaVariazione() {
		return operatoreDiUltimaVariazione;
	}
	public void setOperatoreDiUltimaVariazione(String operatoreDiUltimaVariazione) {
		this.operatoreDiUltimaVariazione = operatoreDiUltimaVariazione;
	}
	public Date getDataDiUltimaVariazione() {
		return dataDiUltimaVariazione;
	}
	public void setDataDiUltimaVariazione(Date dataDiUltimaVariazione) {
		this.dataDiUltimaVariazione = dataDiUltimaVariazione;
	}
	@Override
	public String toString() {
		return "Customer [chiavePrimariaCliente=" + chiavePrimariaCliente
				+ ", descrizioneCliente=" + descrizioneCliente
				+ ", codiceCliente=" + codiceCliente
				+ ", flagClienteCentroServizio=" + flagClienteCentroServizio
				+ ", operatoreDiInserimento=" + operatoreDiInserimento
				+ ", dataDiInserimento=" + dataDiInserimento
				+ ", operatoreDiUltimaVariazione="
				+ operatoreDiUltimaVariazione + ", dataDiUltimaVariazione="
				+ dataDiUltimaVariazione + "]";
	}
	
	
}
