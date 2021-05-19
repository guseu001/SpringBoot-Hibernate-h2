package de.Standard.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Kunde implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int kunde_id;
	@Column
	private String nachname;
	@Column
	private String vorname;
	@Column
	private int geburtstag, geburtsmonat, geburtsdatum;
	@Column
	private String emailAdresse;
	@Column
	private String passwort;
	@Column
	private String telefonnummer ;
	@Column
	private final String kundenNr;
	@Column
	private String anrede;
	@Column
	private double kontostand;

	public static int zahlkunde = 80070010;



	public Kunde(String anrede, String nachname, String vorname,
					int geburtstag, int geburtsmonat, int geburtsdatum,
					String emailAdresse, String telefonnummer, String passwort)
	{
		this.anrede = anrede;
		this.nachname = nachname;
		this.vorname = vorname;
		this.geburtstag = geburtstag;
		this.geburtsmonat = geburtsmonat;
		this.geburtsdatum = geburtsdatum;
		this.telefonnummer = telefonnummer;

		this.emailAdresse = emailAdresse;
		this.passwort = passwort;

		this.kontostand = 0.00;

		this.kundenNr = "C-" + zahlkunde;

	}
	public Kunde(){
		this.kundenNr = "C-" + zahlkunde;
		zahlkunde++;
	}

	public String getKundenNr() {
		return kundenNr;
	}

	public String getAnrede() {
		return anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getGeburtstag() {
		return geburtstag;
	}

	public void setGeburtstag(int geburtstag) {
		this.geburtstag = geburtstag;
	}

	public int getGeburtsmonat() {
		return geburtsmonat;
	}

	public void setGeburtsmonat(int geburtsmonat) {
		this.geburtsmonat = geburtsmonat;
	}

	public int getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(int geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public int getKunde_id() {
		return kunde_id;
	}

	public void setKunde_id(int kunde_id) {
		this.kunde_id = kunde_id;
	}

//	public void setKundenNr(String kundenNr) {
//		this.kundenNr = kundenNr;
//	}

	public double getKontostand() {
		return kontostand;
	}

	public void setKontostand(double kontostand) {
		this.kontostand = kontostand;
	}

	public String getEmailAdresse() {
		return emailAdresse;
	}

	public void setEmailAdresse(String emailAdresse) {
		this.emailAdresse = emailAdresse;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
}
