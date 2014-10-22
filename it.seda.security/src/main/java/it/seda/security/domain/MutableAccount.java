/**
 * 
 */
package it.seda.security.domain;

import java.util.Date;

/**
 * @author f.ricci
 *
 */
@SuppressWarnings("serial")
public class MutableAccount extends AbstractAccount {

//	protected String customerId;
//	protected String groupName;	
	
	//COMMONS_INFO
	private String operatoreInserimento;  //SEUTEC_COPERINS 
	private Date dataInserimento;// SEUTEC_GDATAINS 
	private String operatoreUltimaVariazione; //SEUTEC_COPEUVAR 
	private Date dataUltimaVariazione;//SEUTEC_GDATUVAR 
	
	//CUSTUMER_USER
	private String chiaveTabellaRelazioneUserCliente; //SEUTEC_CKEYUTEC
	private String chiavePrimariaDelCliente;//SECUST_CKEYCUST 
	private String chiavePrimariaTabellaUsers;//SEUSER_CKEYUSER 
	
	
	//GROUP-MEMNERS
	private String chiavePrimariaTabellaGruppiUtenti;// SEGRUU_CKEYGRUU
	private String chiavePrimariaDellaTabellaGruppi;// SEGRUP_CKEYGRUP
	private String chiavePrimariaDellaTabellaUtentiClienti;// SEUTEC_CKEYUTEC
	
	
	//SEUSERTB_FIELDS 
//	protected String usernameKey; ABSTRACT_ACCOUNT   ->  SEUSER_CKEYUSER
//	protected String firstName; ABSTRACT_ACCOUNT  -> SEUSER_CNOMEUSER
//	protected String lastName;  ABSTRACT_ACCOUNT  ->SEUSER_CCOGNUSER
//	protected String codiceFiscale; ABSTRACT_ACCOUNT ->SEUSER_CCODFISC
//	protected String email;    ABSTRACT_ACCOUNT -> SEUSER_CINDEMAIL
//	protected boolean enabled;  ABSTRACT_ACCOUNT -> SEUSER_CUSRABIL
//	protected short attempts;  ABSTRACT_ACCOUNT -> SEUSER_NNUMTENTIVI
//	protected Date lastAttempt;  ABSTRACT_ACCOUNT ->SEUSER_GULTIMOTENT
	
	
	
	private String usernameKey;//SEUSER_CUSERNAME
	private Date dataPersonaFisicaODelegato;//SEUSER_GDATNASCITA
	private String comuneNascitaPersonaFisicaODelegato;  // SEUSER_CCOMUNASCITA
	private String indicaSeNascitaAllEstero;//SEUSER_DNASCEST
	private String tipoDocumento;//SEUSER_CCODTIPDOC
	private String numeroDocumento;//SEUSER_DNUMERODOC
	private String descrizioneEnteCheRilasciaIlDocumento;//SEUSER_DDESCENTE
	private Date dataRilascioDocumento;//SEUSER_GDATARILA
	private String indicaSeIndirizzoAllEstero;//SEUSER_DRESESTERO
	private String indirizzoPersonaFisicaODelegato;//SEUSER_CINDIRIZZO
	private String comuneFiscalePersonaFisicaODelegato;//SEUSER_CCOMUNE
	private String frazioneDelComuneFiscalePersonaFisicaODelegato;//SEUSER_CFRAZIONE
	private String ilCAPDelComuneFiscalePersonaFisicaODelegato;//SEUSER_CCAPCOMFISC
	private String provinciaDelComuneFiscalePersonaFisicaODelegato;//SEUSER_CPROVINCIA
	private String numeroTelefonicoPersonaFisicaODelegato;//SEUSER_CTELEFONO
	private String numeroCellularePersonaFisicaODelegato;//SEUSER_CCELLULARE
	private String indirizzoEMailDelDelegatoOPersonaFisica;//SEUSER_CINDEMAIL
	private String eMailPECDelDelegatoPersonaFisica;//SEUSER_CPECDELEG
	private String naturaGiuridicaDellUtenza;//SEUSER_CFLAGGIUR
	private String codiceFiscalePIVADellAzienda;//SEUSER_CFISCPIVAAZI
	private String denominazioneAzienda;//SEUSER_CDENOMIN
	private String indicaSeSedeAllEstero;//SEUSER_DSEDEESTERO
	private String indirizzoAzienda;//SEUSER_CINDAZIENDA
	private String comuneFiscaleAzienda;//SEUSER_CCOMUAZIE
	private String frazioneDelComuneFiscaleDellAzienda;//SEUSER_CFRAZAZIE
	private String ilCAPFiscaleDellAzienda;//SEUSER_CCAPAZIEN
	private String provinciaDelComuneFiscaleDellAzienda;//SEUSER_CPROVAZIEN
	private String numeroTelefonicoAzienda;//SEUSER_CTELEFONOAZI
	private String numeroFaxAzienda;//SEUSER_CNUMEROFAX
	private String eMailAzienda;//SEUSER_CEMAILAZI
	private String eMailPECAzienda;//SEUSER_CPECAZIENDA
	private Short indicaSeUtenzaAbilitata;//SEUSER_CUSRABIL
	private Date dataRegistrazione;//SEUSER_GDATAREG
	private Date dataScadenzaUser;//SEUSER_GDATASCAD
	private Date dataScadenzaCredenziali;//SEUSER_GSCADCREDEN
	private Date dataUltimoAccesso;//SEUSER_GULTIMOACC
	
	
	
	public MutableAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public MutableAccount(String operatoreInserimento, Date dataInserimento,
			String operatoreUltimaVariazione, Date dataUltimaVariazione,
			String chiaveTabellaRelazioneUserCliente,
			String chiavePrimariaDelCliente, String chiavePrimariaTabellaUsers,
			String chiavePrimariaTabellaGruppiUtenti,
			String chiavePrimariaDellaTabellaGruppi,
			String chiavePrimariaDellaTabellaUtentiClienti, String usernameKey,
			Date dataPersonaFisicaODelegato,
			String comuneNascitaPersonaFisicaODelegato,
			String indicaSeNascitaAllEstero, String tipoDocumento,
			String numeroDocumento,
			String descrizioneEnteCheRilasciaIlDocumento,
			Date dataRilascioDocumento, String indicaSeIndirizzoAllEstero,
			String indirizzoPersonaFisicaODelegato,
			String comuneFiscalePersonaFisicaODelegato,
			String frazioneDelComuneFiscalePersonaFisicaODelegato,
			String ilCAPDelComuneFiscalePersonaFisicaODelegato,
			String provinciaDelComuneFiscalePersonaFisicaODelegato,
			String numeroTelefonicoPersonaFisicaODelegato,
			String numeroCellularePersonaFisicaODelegato,
			String indirizzoEMailDelDelegatoOPersonaFisica,
			String eMailPECDelDelegatoPersonaFisica,
			String naturaGiuridicaDellUtenza,
			String codiceFiscalePIVADellAzienda, String denominazioneAzienda,
			String indicaSeSedeAllEstero, String indirizzoAzienda,
			String comuneFiscaleAzienda,
			String frazioneDelComuneFiscaleDellAzienda,
			String ilCAPFiscaleDellAzienda,
			String provinciaDelComuneFiscaleDellAzienda,
			String numeroTelefonicoAzienda, String numeroFaxAzienda,
			String eMailAzienda, String eMailPECAzienda,
			Short indicaSeUtenzaAbilitata, Date dataRegistrazione,
			Date dataScadenzaUser, Date dataScadenzaCredenziali,
			Date dataUltimoAccesso) {
		super();
		this.operatoreInserimento = operatoreInserimento;
		this.dataInserimento = dataInserimento;
		this.operatoreUltimaVariazione = operatoreUltimaVariazione;
		this.dataUltimaVariazione = dataUltimaVariazione;
		this.chiaveTabellaRelazioneUserCliente = chiaveTabellaRelazioneUserCliente;
		this.chiavePrimariaDelCliente = chiavePrimariaDelCliente;
		this.chiavePrimariaTabellaUsers = chiavePrimariaTabellaUsers;
		this.chiavePrimariaTabellaGruppiUtenti = chiavePrimariaTabellaGruppiUtenti;
		this.chiavePrimariaDellaTabellaGruppi = chiavePrimariaDellaTabellaGruppi;
		this.chiavePrimariaDellaTabellaUtentiClienti = chiavePrimariaDellaTabellaUtentiClienti;
		this.usernameKey = usernameKey;
		this.dataPersonaFisicaODelegato = dataPersonaFisicaODelegato;
		this.comuneNascitaPersonaFisicaODelegato = comuneNascitaPersonaFisicaODelegato;
		this.indicaSeNascitaAllEstero = indicaSeNascitaAllEstero;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.descrizioneEnteCheRilasciaIlDocumento = descrizioneEnteCheRilasciaIlDocumento;
		this.dataRilascioDocumento = dataRilascioDocumento;
		this.indicaSeIndirizzoAllEstero = indicaSeIndirizzoAllEstero;
		this.indirizzoPersonaFisicaODelegato = indirizzoPersonaFisicaODelegato;
		this.comuneFiscalePersonaFisicaODelegato = comuneFiscalePersonaFisicaODelegato;
		this.frazioneDelComuneFiscalePersonaFisicaODelegato = frazioneDelComuneFiscalePersonaFisicaODelegato;
		this.ilCAPDelComuneFiscalePersonaFisicaODelegato = ilCAPDelComuneFiscalePersonaFisicaODelegato;
		this.provinciaDelComuneFiscalePersonaFisicaODelegato = provinciaDelComuneFiscalePersonaFisicaODelegato;
		this.numeroTelefonicoPersonaFisicaODelegato = numeroTelefonicoPersonaFisicaODelegato;
		this.numeroCellularePersonaFisicaODelegato = numeroCellularePersonaFisicaODelegato;
		this.indirizzoEMailDelDelegatoOPersonaFisica = indirizzoEMailDelDelegatoOPersonaFisica;
		this.eMailPECDelDelegatoPersonaFisica = eMailPECDelDelegatoPersonaFisica;
		this.naturaGiuridicaDellUtenza = naturaGiuridicaDellUtenza;
		this.codiceFiscalePIVADellAzienda = codiceFiscalePIVADellAzienda;
		this.denominazioneAzienda = denominazioneAzienda;
		this.indicaSeSedeAllEstero = indicaSeSedeAllEstero;
		this.indirizzoAzienda = indirizzoAzienda;
		this.comuneFiscaleAzienda = comuneFiscaleAzienda;
		this.frazioneDelComuneFiscaleDellAzienda = frazioneDelComuneFiscaleDellAzienda;
		this.ilCAPFiscaleDellAzienda = ilCAPFiscaleDellAzienda;
		this.provinciaDelComuneFiscaleDellAzienda = provinciaDelComuneFiscaleDellAzienda;
		this.numeroTelefonicoAzienda = numeroTelefonicoAzienda;
		this.numeroFaxAzienda = numeroFaxAzienda;
		this.eMailAzienda = eMailAzienda;
		this.eMailPECAzienda = eMailPECAzienda;
		this.indicaSeUtenzaAbilitata = indicaSeUtenzaAbilitata;
		this.dataRegistrazione = dataRegistrazione;
		this.dataScadenzaUser = dataScadenzaUser;
		this.dataScadenzaCredenziali = dataScadenzaCredenziali;
		this.dataUltimoAccesso = dataUltimoAccesso;
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
	public String getChiaveTabellaRelazioneUserCliente() {
		return chiaveTabellaRelazioneUserCliente;
	}
	public void setChiaveTabellaRelazioneUserCliente(
			String chiaveTabellaRelazioneUserCliente) {
		this.chiaveTabellaRelazioneUserCliente = chiaveTabellaRelazioneUserCliente;
	}
	public String getChiavePrimariaDelCliente() {
		return chiavePrimariaDelCliente;
	}
	public void setChiavePrimariaDelCliente(String chiavePrimariaDelCliente) {
		this.chiavePrimariaDelCliente = chiavePrimariaDelCliente;
	}
	public String getChiavePrimariaTabellaUsers() {
		return chiavePrimariaTabellaUsers;
	}
	public void setChiavePrimariaTabellaUsers(String chiavePrimariaTabellaUsers) {
		this.chiavePrimariaTabellaUsers = chiavePrimariaTabellaUsers;
	}
	public String getChiavePrimariaTabellaGruppiUtenti() {
		return chiavePrimariaTabellaGruppiUtenti;
	}
	public void setChiavePrimariaTabellaGruppiUtenti(
			String chiavePrimariaTabellaGruppiUtenti) {
		this.chiavePrimariaTabellaGruppiUtenti = chiavePrimariaTabellaGruppiUtenti;
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
	public String getUsernameKey() {
		return usernameKey;
	}
	
	public Date getDataPersonaFisicaODelegato() {
		return dataPersonaFisicaODelegato;
	}
	public void setDataPersonaFisicaODelegato(Date dataPersonaFisicaODelegato) {
		this.dataPersonaFisicaODelegato = dataPersonaFisicaODelegato;
	}
	public String getComuneNascitaPersonaFisicaODelegato() {
		return comuneNascitaPersonaFisicaODelegato;
	}
	public void setComuneNascitaPersonaFisicaODelegato(
			String comuneNascitaPersonaFisicaODelegato) {
		this.comuneNascitaPersonaFisicaODelegato = comuneNascitaPersonaFisicaODelegato;
	}
	public String getIndicaSeNascitaAllEstero() {
		return indicaSeNascitaAllEstero;
	}
	public void setIndicaSeNascitaAllEstero(String indicaSeNascitaAllEstero) {
		this.indicaSeNascitaAllEstero = indicaSeNascitaAllEstero;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getDescrizioneEnteCheRilasciaIlDocumento() {
		return descrizioneEnteCheRilasciaIlDocumento;
	}
	public void setDescrizioneEnteCheRilasciaIlDocumento(
			String descrizioneEnteCheRilasciaIlDocumento) {
		this.descrizioneEnteCheRilasciaIlDocumento = descrizioneEnteCheRilasciaIlDocumento;
	}
	public Date getDataRilascioDocumento() {
		return dataRilascioDocumento;
	}
	public void setDataRilascioDocumento(Date dataRilascioDocumento) {
		this.dataRilascioDocumento = dataRilascioDocumento;
	}
	public String getIndicaSeIndirizzoAllEstero() {
		return indicaSeIndirizzoAllEstero;
	}
	public void setIndicaSeIndirizzoAllEstero(String indicaSeIndirizzoAllEstero) {
		this.indicaSeIndirizzoAllEstero = indicaSeIndirizzoAllEstero;
	}
	public String getIndirizzoPersonaFisicaODelegato() {
		return indirizzoPersonaFisicaODelegato;
	}
	public void setIndirizzoPersonaFisicaODelegato(
			String indirizzoPersonaFisicaODelegato) {
		this.indirizzoPersonaFisicaODelegato = indirizzoPersonaFisicaODelegato;
	}
	public String getComuneFiscalePersonaFisicaODelegato() {
		return comuneFiscalePersonaFisicaODelegato;
	}
	public void setComuneFiscalePersonaFisicaODelegato(
			String comuneFiscalePersonaFisicaODelegato) {
		this.comuneFiscalePersonaFisicaODelegato = comuneFiscalePersonaFisicaODelegato;
	}
	public String getFrazioneDelComuneFiscalePersonaFisicaODelegato() {
		return frazioneDelComuneFiscalePersonaFisicaODelegato;
	}
	public void setFrazioneDelComuneFiscalePersonaFisicaODelegato(
			String frazioneDelComuneFiscalePersonaFisicaODelegato) {
		this.frazioneDelComuneFiscalePersonaFisicaODelegato = frazioneDelComuneFiscalePersonaFisicaODelegato;
	}
	public String getIlCAPDelComuneFiscalePersonaFisicaODelegato() {
		return ilCAPDelComuneFiscalePersonaFisicaODelegato;
	}
	public void setIlCAPDelComuneFiscalePersonaFisicaODelegato(
			String ilCAPDelComuneFiscalePersonaFisicaODelegato) {
		this.ilCAPDelComuneFiscalePersonaFisicaODelegato = ilCAPDelComuneFiscalePersonaFisicaODelegato;
	}
	public String getProvinciaDelComuneFiscalePersonaFisicaODelegato() {
		return provinciaDelComuneFiscalePersonaFisicaODelegato;
	}
	public void setProvinciaDelComuneFiscalePersonaFisicaODelegato(
			String provinciaDelComuneFiscalePersonaFisicaODelegato) {
		this.provinciaDelComuneFiscalePersonaFisicaODelegato = provinciaDelComuneFiscalePersonaFisicaODelegato;
	}
	public String getNumeroTelefonicoPersonaFisicaODelegato() {
		return numeroTelefonicoPersonaFisicaODelegato;
	}
	public void setNumeroTelefonicoPersonaFisicaODelegato(
			String numeroTelefonicoPersonaFisicaODelegato) {
		this.numeroTelefonicoPersonaFisicaODelegato = numeroTelefonicoPersonaFisicaODelegato;
	}
	public String getNumeroCellularePersonaFisicaODelegato() {
		return numeroCellularePersonaFisicaODelegato;
	}
	public void setNumeroCellularePersonaFisicaODelegato(
			String numeroCellularePersonaFisicaODelegato) {
		this.numeroCellularePersonaFisicaODelegato = numeroCellularePersonaFisicaODelegato;
	}
	public String getIndirizzoEMailDelDelegatoOPersonaFisica() {
		return indirizzoEMailDelDelegatoOPersonaFisica;
	}
	public void setIndirizzoEMailDelDelegatoOPersonaFisica(
			String indirizzoEMailDelDelegatoOPersonaFisica) {
		this.indirizzoEMailDelDelegatoOPersonaFisica = indirizzoEMailDelDelegatoOPersonaFisica;
	}
	public String geteMailPECDelDelegatoPersonaFisica() {
		return eMailPECDelDelegatoPersonaFisica;
	}
	public void seteMailPECDelDelegatoPersonaFisica(
			String eMailPECDelDelegatoPersonaFisica) {
		this.eMailPECDelDelegatoPersonaFisica = eMailPECDelDelegatoPersonaFisica;
	}
	public String getNaturaGiuridicaDellUtenza() {
		return naturaGiuridicaDellUtenza;
	}
	public void setNaturaGiuridicaDellUtenza(String naturaGiuridicaDellUtenza) {
		this.naturaGiuridicaDellUtenza = naturaGiuridicaDellUtenza;
	}
	public String getCodiceFiscalePIVADellAzienda() {
		return codiceFiscalePIVADellAzienda;
	}
	public void setCodiceFiscalePIVADellAzienda(String codiceFiscalePIVADellAzienda) {
		this.codiceFiscalePIVADellAzienda = codiceFiscalePIVADellAzienda;
	}
	public String getDenominazioneAzienda() {
		return denominazioneAzienda;
	}
	public void setDenominazioneAzienda(String denominazioneAzienda) {
		this.denominazioneAzienda = denominazioneAzienda;
	}
	public String getIndicaSeSedeAllEstero() {
		return indicaSeSedeAllEstero;
	}
	public void setIndicaSeSedeAllEstero(String indicaSeSedeAllEstero) {
		this.indicaSeSedeAllEstero = indicaSeSedeAllEstero;
	}
	public String getIndirizzoAzienda() {
		return indirizzoAzienda;
	}
	public void setIndirizzoAzienda(String indirizzoAzienda) {
		this.indirizzoAzienda = indirizzoAzienda;
	}
	public String getComuneFiscaleAzienda() {
		return comuneFiscaleAzienda;
	}
	public void setComuneFiscaleAzienda(String comuneFiscaleAzienda) {
		this.comuneFiscaleAzienda = comuneFiscaleAzienda;
	}
	public String getFrazioneDelComuneFiscaleDellAzienda() {
		return frazioneDelComuneFiscaleDellAzienda;
	}
	public void setFrazioneDelComuneFiscaleDellAzienda(
			String frazioneDelComuneFiscaleDellAzienda) {
		this.frazioneDelComuneFiscaleDellAzienda = frazioneDelComuneFiscaleDellAzienda;
	}
	public String getIlCAPFiscaleDellAzienda() {
		return ilCAPFiscaleDellAzienda;
	}
	public void setIlCAPFiscaleDellAzienda(String ilCAPFiscaleDellAzienda) {
		this.ilCAPFiscaleDellAzienda = ilCAPFiscaleDellAzienda;
	}
	public String getProvinciaDelComuneFiscaleDellAzienda() {
		return provinciaDelComuneFiscaleDellAzienda;
	}
	public void setProvinciaDelComuneFiscaleDellAzienda(
			String provinciaDelComuneFiscaleDellAzienda) {
		this.provinciaDelComuneFiscaleDellAzienda = provinciaDelComuneFiscaleDellAzienda;
	}
	public String getNumeroTelefonicoAzienda() {
		return numeroTelefonicoAzienda;
	}
	public void setNumeroTelefonicoAzienda(String numeroTelefonicoAzienda) {
		this.numeroTelefonicoAzienda = numeroTelefonicoAzienda;
	}
	public String getNumeroFaxAzienda() {
		return numeroFaxAzienda;
	}
	public void setNumeroFaxAzienda(String numeroFaxAzienda) {
		this.numeroFaxAzienda = numeroFaxAzienda;
	}
	public String geteMailAzienda() {
		return eMailAzienda;
	}
	public void seteMailAzienda(String eMailAzienda) {
		this.eMailAzienda = eMailAzienda;
	}
	public String geteMailPECAzienda() {
		return eMailPECAzienda;
	}
	public void seteMailPECAzienda(String eMailPECAzienda) {
		this.eMailPECAzienda = eMailPECAzienda;
	}
	public Short getIndicaSeUtenzaAbilitata() {
		return indicaSeUtenzaAbilitata;
	}
	public void setIndicaSeUtenzaAbilitata(Short indicaSeUtenzaAbilitata) {
		this.indicaSeUtenzaAbilitata = indicaSeUtenzaAbilitata;
	}
	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}
	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}
	public Date getDataScadenzaUser() {
		return dataScadenzaUser;
	}
	public void setDataScadenzaUser(Date dataScadenzaUser) {
		this.dataScadenzaUser = dataScadenzaUser;
	}
	public Date getDataScadenzaCredenziali() {
		return dataScadenzaCredenziali;
	}
	public void setDataScadenzaCredenziali(Date dataScadenzaCredenziali) {
		this.dataScadenzaCredenziali = dataScadenzaCredenziali;
	}
	public Date getDataUltimoAccesso() {
		return dataUltimoAccesso;
	}
	public void setDataUltimoAccesso(Date dataUltimoAccesso) {
		this.dataUltimoAccesso = dataUltimoAccesso;
	}
	@Override
	public String toString() {
		return "MutableAccount [operatoreInserimento=" + operatoreInserimento
				+ ", dataInserimento=" + dataInserimento
				+ ", operatoreUltimaVariazione=" + operatoreUltimaVariazione
				+ ", dataUltimaVariazione=" + dataUltimaVariazione
				+ ", chiaveTabellaRelazioneUserCliente="
				+ chiaveTabellaRelazioneUserCliente
				+ ", chiavePrimariaDelCliente=" + chiavePrimariaDelCliente
				+ ", chiavePrimariaTabellaUsers=" + chiavePrimariaTabellaUsers
				+ ", chiavePrimariaTabellaGruppiUtenti="
				+ chiavePrimariaTabellaGruppiUtenti
				+ ", chiavePrimariaDellaTabellaGruppi="
				+ chiavePrimariaDellaTabellaGruppi
				+ ", chiavePrimariaDellaTabellaUtentiClienti="
				+ chiavePrimariaDellaTabellaUtentiClienti + ", usernameKey="
				+ usernameKey + ", dataPersonaFisicaODelegato="
				+ dataPersonaFisicaODelegato
				+ ", comuneNascitaPersonaFisicaODelegato="
				+ comuneNascitaPersonaFisicaODelegato
				+ ", indicaSeNascitaAllEstero=" + indicaSeNascitaAllEstero
				+ ", tipoDocumento=" + tipoDocumento + ", numeroDocumento="
				+ numeroDocumento + ", descrizioneEnteCheRilasciaIlDocumento="
				+ descrizioneEnteCheRilasciaIlDocumento
				+ ", dataRilascioDocumento=" + dataRilascioDocumento
				+ ", indicaSeIndirizzoAllEstero=" + indicaSeIndirizzoAllEstero
				+ ", indirizzoPersonaFisicaODelegato="
				+ indirizzoPersonaFisicaODelegato
				+ ", comuneFiscalePersonaFisicaODelegato="
				+ comuneFiscalePersonaFisicaODelegato
				+ ", frazioneDelComuneFiscalePersonaFisicaODelegato="
				+ frazioneDelComuneFiscalePersonaFisicaODelegato
				+ ", ilCAPDelComuneFiscalePersonaFisicaODelegato="
				+ ilCAPDelComuneFiscalePersonaFisicaODelegato
				+ ", provinciaDelComuneFiscalePersonaFisicaODelegato="
				+ provinciaDelComuneFiscalePersonaFisicaODelegato
				+ ", numeroTelefonicoPersonaFisicaODelegato="
				+ numeroTelefonicoPersonaFisicaODelegato
				+ ", numeroCellularePersonaFisicaODelegato="
				+ numeroCellularePersonaFisicaODelegato
				+ ", indirizzoEMailDelDelegatoOPersonaFisica="
				+ indirizzoEMailDelDelegatoOPersonaFisica
				+ ", eMailPECDelDelegatoPersonaFisica="
				+ eMailPECDelDelegatoPersonaFisica
				+ ", naturaGiuridicaDellUtenza=" + naturaGiuridicaDellUtenza
				+ ", codiceFiscalePIVADellAzienda="
				+ codiceFiscalePIVADellAzienda + ", denominazioneAzienda="
				+ denominazioneAzienda + ", indicaSeSedeAllEstero="
				+ indicaSeSedeAllEstero + ", indirizzoAzienda="
				+ indirizzoAzienda + ", comuneFiscaleAzienda="
				+ comuneFiscaleAzienda
				+ ", frazioneDelComuneFiscaleDellAzienda="
				+ frazioneDelComuneFiscaleDellAzienda
				+ ", ilCAPFiscaleDellAzienda=" + ilCAPFiscaleDellAzienda
				+ ", provinciaDelComuneFiscaleDellAzienda="
				+ provinciaDelComuneFiscaleDellAzienda
				+ ", numeroTelefonicoAzienda=" + numeroTelefonicoAzienda
				+ ", numeroFaxAzienda=" + numeroFaxAzienda + ", eMailAzienda="
				+ eMailAzienda + ", eMailPECAzienda=" + eMailPECAzienda
				+ ", indicaSeUtenzaAbilitata=" + indicaSeUtenzaAbilitata
				+ ", dataRegistrazione=" + dataRegistrazione
				+ ", dataScadenzaUser=" + dataScadenzaUser
				+ ", dataScadenzaCredenziali=" + dataScadenzaCredenziali
				+ ", dataUltimoAccesso=" + dataUltimoAccesso + "]";
	}
	
	
	public void init(){
		this.usernameKey=" ";
		this.firstName=" ";
		this.lastName=" ";
		this.codiceFiscale="XXXXXXXXXXXXXXXX";
		this.email=" ";
		this.enabled=false;
		this.attempts=0;
		this.operatoreInserimento=" ";  
		this.dataInserimento=new Date();
		this.operatoreUltimaVariazione=" "; 
		this.dataUltimaVariazione=new Date();
		this.chiaveTabellaRelazioneUserCliente=" ";
		this.chiavePrimariaDelCliente=" ";
		this.chiavePrimariaTabellaUsers=" ";
		this.chiavePrimariaTabellaGruppiUtenti=" ";
		this.chiavePrimariaDellaTabellaGruppi=" ";
		this.chiavePrimariaDellaTabellaUtentiClienti=" ";
		this.username=" ";
		this.dataPersonaFisicaODelegato=new Date();
		this.comuneNascitaPersonaFisicaODelegato="   "; 
		this.indicaSeNascitaAllEstero=" ";
		this.tipoDocumento="  ";
		this.numeroDocumento=" ";
		this.descrizioneEnteCheRilasciaIlDocumento=" ";
		this.dataRilascioDocumento=new Date();
		this.indicaSeIndirizzoAllEstero="X";
		this.indirizzoPersonaFisicaODelegato=" ";
		this.comuneFiscalePersonaFisicaODelegato=" ";
		this.frazioneDelComuneFiscalePersonaFisicaODelegato=" ";
		this.ilCAPDelComuneFiscalePersonaFisicaODelegato=" ";
		this.provinciaDelComuneFiscalePersonaFisicaODelegato="  ";
		this.numeroTelefonicoPersonaFisicaODelegato=" ";
		this.numeroCellularePersonaFisicaODelegato=" ";
		this.indirizzoEMailDelDelegatoOPersonaFisica=" ";
		this.eMailPECDelDelegatoPersonaFisica=" ";
		this.naturaGiuridicaDellUtenza="X";
		this.codiceFiscalePIVADellAzienda="XXXXXXXXXXXXXXX";
		this.denominazioneAzienda=" ";
		this.indicaSeSedeAllEstero="X";
		this.indirizzoAzienda=" ";
		this.comuneFiscaleAzienda=" ";
		this.frazioneDelComuneFiscaleDellAzienda=" ";
		this.ilCAPFiscaleDellAzienda=" ";
		this.provinciaDelComuneFiscaleDellAzienda="  ";
		this.numeroTelefonicoAzienda=" ";
		this.numeroFaxAzienda=" ";
		this.eMailAzienda=" ";
		this.eMailPECAzienda=" ";
		this.indicaSeUtenzaAbilitata=1;
		this.dataRegistrazione=new Date();
		this.dataScadenzaUser=new Date();
		this.dataScadenzaCredenziali=new Date();
		this.dataUltimoAccesso=new Date();
		this.lastAttempt=new Date();
	}
	
	
	
	
	

}
