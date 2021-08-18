package de.Standard.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Kunde")
public class Kunde implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false,
			unique = true)
	private int kunde_id;

	@Column(updatable = true,
			length = 50)
	private String nachname;

	@Column(updatable = true,
			length = 25)
	private String vorname;

	@Column(nullable = false,
			length = 4)
	private int geburtstag, geburtsmonat, geburtsdatum;

	@Column(updatable = false,
			unique = true,
			length = 50)
	private String email;

	@Column(updatable = true,
			length = 50)
	private String password;

	@Column (length = 20)
	private String telefonnummer;

	@Column(unique = true ,
			updatable = false,
			length = 40)
	private final String kundenNr;

	@Column(nullable = false,
			length = 10,
			updatable = true)
	private String anrede;

	@Column(nullable = true)
	private double kontostand;

	@Column(updatable = false)
	private String registrierungstime;

	@OneToOne(cascade = CascadeType.ALL)
	private Adresse adress;

	@Column(length = 7)
	private boolean aktiviert;

	public Kunde(String anrede,
				 String nachname,
				 String vorname,
				 int geburtstag,
				 int geburtsmonat,
				 int geburtsdatum,
				 String email,
				 String telefonnummer,
				 String password,
				 Adresse adress)
	{
		this.anrede = anrede;
		this.nachname = nachname;
		this.vorname = vorname;
		this.geburtstag = geburtstag;
		this.geburtsmonat = geburtsmonat;
		this.geburtsdatum = geburtsdatum;
		this.telefonnummer = telefonnummer;

		this.email= email;
		this.password = password;

		this.kontostand = 0.00;

		this.kundenNr = "C-" + CountKunde.ANZAHLKUNDE;
		CountKunde.ANZAHLKUNDE++;

		this.adress = adress;

		this.aktiviert = false;

	}
	public Kunde(){
		this.registrierungstime = "" + LocalDate.now() + " " + LocalTime.now();

		this.kundenNr = "C-" + CountKunde.ANZAHLKUNDE;

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

	public double getKontostand() {
		return kontostand;
	}

	public void setKontostand(double kontostand) {
		this.kontostand = kontostand;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegistrierungstime() {
		return registrierungstime;
	}

	public void setRegistrierungstime(String registrierungstime) {
		this.registrierungstime = registrierungstime;
	}

	public Adresse getAdress() {
		return adress;
	}

	public void setAdress(Adresse adress) {
		this.adress = adress;
	}

	public boolean isAktiviert() {
		return aktiviert;
	}

	public void setAktiviert(boolean aktiviert) {
		this.aktiviert = aktiviert;
	}
}
