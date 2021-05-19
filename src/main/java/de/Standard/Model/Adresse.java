/*
 * @author Guy Seuleu
 * @datum 27.04.2021 
 */

package de.Standard.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Adresse implements Serializable
{
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adress_id;
	@Column
	private String strassenname;
	@Column
	private int hausnummer;
	@Column
	private int plz;
	@Column
	private String stadt;
	@Column
	private String land;

	public Adresse(){}

	public Adresse(String strassenname, int hausnummer, int plz, String stadt, String land) {
		this.strassenname = strassenname;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.stadt = stadt;
		this.land = land;
	}
	
	public String getStrassenname() {
		return strassenname;
	}

	public void setStrassenname(String strassenname) {
		this.strassenname = strassenname;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public int getAdress_id() {
		return adress_id;
	}

	public void setAdress_id(int adress_id) {
		this.adress_id = adress_id;
	}
	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}
}
