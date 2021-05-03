package de.Standard.Model;

public abstract class Item 
{
	
	private final int itemNr;
	protected String type;
	protected String bezeichnung;
	protected String farbe;
	protected String beschreibung;
	protected Object[] photos = new Object[10];
	protected double preis;



	public Item(String type, String bezeichnung, String farbe, String beschreibung , double preis) {
		this.itemNr = iniItemNr();
		this.type = type;
		this.bezeichnung = bezeichnung;
		this.farbe = farbe;
		this.beschreibung = beschreibung;
		this.preis = preis;
//		this.photos = photos;

		
	}
	
	// to do
	public int iniItemNr() {
		return 0;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public int getItemNr() {
		return itemNr;
	}
	
	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
		
}
