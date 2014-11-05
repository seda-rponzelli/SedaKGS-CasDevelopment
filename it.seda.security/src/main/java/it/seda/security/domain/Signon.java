/**
 * 
 */
package it.seda.security.domain;

import java.util.Date;

/**
 * @author f.ricci
 * 
 */
public class Signon {

	
	private String chiaveTabellaDellePasswordDellUtenza;// SEPWRD_CKEYPWRD
	private String passwordValidaDellUtenza;// SEPWRD_CPASSWORD
	private String ultimaPasswordValidaDellUtenza;// SEPWRD_CPASSWOLD
	private String penultimaPasswordValidaDellUtenza;// SEPWRD_CPASSOLDO
	private String operatoreInserimento;// SEPWRD_COPERINS
	private Date dataInserimento;// SEPWRD_GDATAINS
	private String operatoreUltimaVariazione;// SEPWRD_COPEUVAR
	private Date dataUltimaVariazione;// SEPWRD_GDATUVAR
	private String chiavePrimariaTabellaUsers;// SEUSER_CKEYUSER

	public Signon() {
		super();
	}

	public Signon(String chiaveTabellaDellePasswordDellUtenza,
			String passwordValidaDellUtenza,
			String ultimaPasswordValidaDellUtenza,
			String penultimaPasswordValidaDellUtenza,
			String operatoreInserimento, Date dataInserimento,
			String operatoreUltimaVariazione, Date dataUltimaVariazione,
			String chiavePrimariaTabellaUsers) {
		super();
		this.chiaveTabellaDellePasswordDellUtenza = chiaveTabellaDellePasswordDellUtenza;
		this.passwordValidaDellUtenza = passwordValidaDellUtenza;
		this.ultimaPasswordValidaDellUtenza = ultimaPasswordValidaDellUtenza;
		this.penultimaPasswordValidaDellUtenza = penultimaPasswordValidaDellUtenza;
		this.operatoreInserimento = operatoreInserimento;
		this.dataInserimento = dataInserimento;
		this.operatoreUltimaVariazione = operatoreUltimaVariazione;
		this.dataUltimaVariazione = dataUltimaVariazione;
		this.chiavePrimariaTabellaUsers = chiavePrimariaTabellaUsers;
	}

	public String getChiaveTabellaDellePasswordDellUtenza() {
		return chiaveTabellaDellePasswordDellUtenza;
	}

	public void setChiaveTabellaDellePasswordDellUtenza(
			String chiaveTabellaDellePasswordDellUtenza) {
		this.chiaveTabellaDellePasswordDellUtenza = chiaveTabellaDellePasswordDellUtenza;
	}

	public String getPasswordValidaDellUtenza() {
		return passwordValidaDellUtenza;
	}

	public void setPasswordValidaDellUtenza(String passwordValidaDellUtenza) {
		this.passwordValidaDellUtenza = passwordValidaDellUtenza;
	}

	public String getUltimaPasswordValidaDellUtenza() {
		return ultimaPasswordValidaDellUtenza;
	}

	public void setUltimaPasswordValidaDellUtenza(
			String ultimaPasswordValidaDellUtenza) {
		this.ultimaPasswordValidaDellUtenza = ultimaPasswordValidaDellUtenza;
	}

	public String getPenultimaPasswordValidaDellUtenza() {
		return penultimaPasswordValidaDellUtenza;
	}

	public void setPenultimaPasswordValidaDellUtenza(
			String penultimaPasswordValidaDellUtenza) {
		this.penultimaPasswordValidaDellUtenza = penultimaPasswordValidaDellUtenza;
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

	public String getChiavePrimariaTabellaUsers() {
		return chiavePrimariaTabellaUsers;
	}

	public void setChiavePrimariaTabellaUsers(String chiavePrimariaTabellaUsers) {
		this.chiavePrimariaTabellaUsers = chiavePrimariaTabellaUsers;
	}

	@Override
	public String toString() {
		return "Signon [chiaveTabellaDellePasswordDellUtenza="
				+ chiaveTabellaDellePasswordDellUtenza
				+ ", passwordValidaDellUtenza=" + passwordValidaDellUtenza
				+ ", ultimaPasswordValidaDellUtenza="
				+ ultimaPasswordValidaDellUtenza
				+ ", penultimaPasswordValidaDellUtenza="
				+ penultimaPasswordValidaDellUtenza + ", operatoreInserimento="
				+ operatoreInserimento + ", dataInserimento=" + dataInserimento
				+ ", operatoreUltimaVariazione=" + operatoreUltimaVariazione
				+ ", dataUltimaVariazione=" + dataUltimaVariazione
				+ ", chiavePrimariaTabellaUsers=" + chiavePrimariaTabellaUsers
				+ "]";
	}

}
