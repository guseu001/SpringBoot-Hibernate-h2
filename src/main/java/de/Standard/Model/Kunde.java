package de.Standard.Model;

import javax.persistence.*;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Kunde extends Person
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int kunde_id;
	@Column
	private final String kundenNr;
	@Column
	private String anrede;
	@Column
	private double kontostand;

	public static int zahlkunde = 80070010;
	
	public Kunde(String anrede, String nachname, String vorname,
					short geburtstag, short geburtsmonat, short geburtsdatum, 
					String emailAdresse, int telefonnummer)
	{
		super(nachname, vorname, geburtstag, geburtsmonat,geburtsdatum, emailAdresse, telefonnummer);

		this.anrede = anrede;
		this.nachname = nachname;
		this.vorname = vorname;
		this.geburtstag = geburtstag;
		this.geburtsmonat = geburtsmonat;
		this.geburtsdatum = geburtsdatum;
		this.telefonnummer = telefonnummer;

		this.emailAdresse = emailAdresse;

		this.kontostand = 0.00;
		
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

	public int getKunde_id() {
		return kunde_id;
	}

	public double getKontostand() {
		return kontostand;
	}

	public void setKontostand(double kontostand) {
		this.kontostand = kontostand;
	}

}
