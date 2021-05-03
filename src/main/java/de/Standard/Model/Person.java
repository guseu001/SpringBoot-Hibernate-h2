package de.Standard.Model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person
{
	@Column
	protected String nachname;
	@Column
	protected String vorname;
	@Column
	protected short geburtstag, geburtsmonat, geburtsdatum;
	@Column
	protected String emailAdresse;
	@Column
	protected int telefonnummer ;
	@Column
	protected double kontostand;

	public Person(String nachname, String vorname, short geburtstag, short geburtsmonat, short geburtsdatum,
				  String emailAdresse, int telefonnummer) {
		this.nachname = nachname;
		this.vorname = vorname;
		this.geburtstag = geburtstag;
		this.geburtsmonat = geburtsmonat;
		this.geburtsdatum = geburtsdatum;
		this.emailAdresse = emailAdresse;
		this.telefonnummer = telefonnummer;

	}
	
	public String getName() {
		return nachname;
	}

	public void setName(String name) {
		this.nachname = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public short getGeburtstag() {
		return geburtstag;
	}

	public void setGeburtstag(short geburtstag) {
		this.geburtstag = geburtstag;
	}

	public short getGeburtsmonat() {
		return geburtsmonat;
	}

	public void setGeburtsmonat(short geburtsmonat) {
		this.geburtsmonat = geburtsmonat;
	}

	public short getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(short geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public int getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(int telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public double getKontostand() {
		return kontostand;
	}

	public void setKontostand(double kontostand) {
		this.kontostand = kontostand;
	}
}