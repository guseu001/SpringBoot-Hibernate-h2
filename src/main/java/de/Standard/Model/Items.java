package de.Standard.Model;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "Items")
public class Items implements Serializable
{

	@Column
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long Items_id;
	@Column(unique = true)
	private long itemNr;
	@Column
	private String kategorie;
	@Column(nullable = false)
	private String bezeichnung;
	@Column
	private String farbe;
	@Column
	private String beschreibung;
	@Column
	private String stoff;
	@Column
	private double preis;
	@Column
	private int menge;
	@Column
	private String savetime;
	@Column
	private String marke;
	@ManyToOne
	private Bestellung bestellung;
//	@Column
//	protected File bilder;

	public Items(String kategorie,
				 String bezeichnung,
				 String farbe,
				 String beschreibung ,
				 String stoff,
				 int menge,
				 double preis,
				 String marke)
	{
		this.preis = preis;
		this.kategorie = kategorie;
		this.bezeichnung = bezeichnung;
		this.farbe = farbe;
		this.beschreibung = beschreibung;
		this.stoff = stoff;
		this.menge = menge;
		this.marke = marke;

//		this.bilder = bilder;
	}

	public Items(){
		this.savetime ="" + new Date().toLocaleString();
		long random = new Random().nextInt();
		this.itemNr = (random > 0 ) ? random : -1 * random;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void SetKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public long getItemNr() {
		return itemNr;
	}
	
	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public String getStoff() {
		return stoff;
	}

	public void setStoff(String stoff) {
		this.stoff = stoff;
	}

	public long getItems_id() {
		return Items_id;
	}

	public void setItems_id(long items_id) {
		Items_id = items_id;
	}

	public void setItemNr(long itemNr) {
		this.itemNr = itemNr;
	}

	public String getSavetime() {
		return savetime;
	}

	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

//	public File getBilder() {
//		return bilder;
//	}
//
//	public void setBilder(File bilder) {
//		this.bilder = bilder;
//	}

	public Bestellung getBestellung() {
		return bestellung;
	}

	public void setBestellung(Bestellung bestellung) {
		this.bestellung = bestellung;
	}
}
