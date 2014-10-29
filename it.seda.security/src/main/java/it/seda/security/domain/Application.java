/**
 * 
 */
package it.seda.security.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author seda
 * 
 */
@SuppressWarnings("serial")
public class Application implements Serializable {

	private String chiavePrimariaDelleApplicazioni;// SEAPPL_CKEYAPPL
	private String codiceApplicazione; // SEAPPL_CCODAPP
	private String descrizioneApplicazione;// SEAPPL_CDESCAPP
	private String chiaveApplicazioneMaster;// SEAPPL_CCODMAST
	private String operatoreInserimento; // SEAPPL_COPERINS
	private Date dataInserimento;// SEAPPL_GDATAINS
	private String operatoreUltimaVariazione;// SEAPPL_COPEUVAR
	private Date dataUltimaVariazione;// SEAPPL_GDATUVAR

	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Application(String chiavePrimariaDelleApplicazioni,
			String codiceApplicazione, String descrizioneApplicazione,
			String chiaveApplicazioneMaster, String operatoreInserimento,
			Date dataInserimento, String operatoreUltimaVariazione,
			Date dataUltimaVariazione) {
		super();
		this.chiavePrimariaDelleApplicazioni = chiavePrimariaDelleApplicazioni;
		this.codiceApplicazione = codiceApplicazione;
		this.descrizioneApplicazione = descrizioneApplicazione;
		this.chiaveApplicazioneMaster = chiaveApplicazioneMaster;
		this.operatoreInserimento = operatoreInserimento;
		this.dataInserimento = dataInserimento;
		this.operatoreUltimaVariazione = operatoreUltimaVariazione;
		this.dataUltimaVariazione = dataUltimaVariazione;
	}

	public String getChiavePrimariaDelleApplicazioni() {
		return chiavePrimariaDelleApplicazioni;
	}

	public void setChiavePrimariaDelleApplicazioni(
			String chiavePrimariaDelleApplicazioni) {
		this.chiavePrimariaDelleApplicazioni = chiavePrimariaDelleApplicazioni;
	}

	public String getCodiceApplicazione() {
		return codiceApplicazione;
	}

	public void setCodiceApplicazione(String codiceApplicazione) {
		this.codiceApplicazione = codiceApplicazione;
	}

	public String getDescrizioneApplicazione() {
		return descrizioneApplicazione;
	}

	public void setDescrizioneApplicazione(String descrizioneApplicazione) {
		this.descrizioneApplicazione = descrizioneApplicazione;
	}

	public String getChiaveApplicazioneMaster() {
		return chiaveApplicazioneMaster;
	}

	public void setChiaveApplicazioneMaster(String chiaveApplicazioneMaster) {
		this.chiaveApplicazioneMaster = chiaveApplicazioneMaster;
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
		return "Application [chiavePrimariaDelleApplicazioni="
				+ chiavePrimariaDelleApplicazioni + ", codiceApplicazione="
				+ codiceApplicazione + ", descrizioneApplicazione="
				+ descrizioneApplicazione + ", chiaveApplicazioneMaster="
				+ chiaveApplicazioneMaster + ", operatoreInserimento="
				+ operatoreInserimento + ", dataInserimento=" + dataInserimento
				+ ", operatoreUltimaVariazione=" + operatoreUltimaVariazione
				+ ", dataUltimaVariazione=" + dataUltimaVariazione + "]";
	}

}
