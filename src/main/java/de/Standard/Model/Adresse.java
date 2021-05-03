/*
 * @author Guy Seuleu
 * @datum 27.04.2021 
 */

package de.Standard.Model;

import javax.persistence.*;

@Entity
@Table
public class Adresse
{
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected int id;
	@Column
	protected String strassenname;
	@Column
	protected short hausnummer;
	@Column
	protected int plz;
	@Column
	protected String stadt;
	
	public Adresse(String strassenname, short hausnummer, int plz, String stadt) {
		this.strassenname = strassenname;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.stadt = stadt;
	}
	
	public String getStrassenname() {
		return strassenname;
	}

	public void setStrassenname(String strassenname) {
		this.strassenname = strassenname;
	}

	public short getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(short hausnummer) {
		this.hausnummer = hausnummer;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(short plz) {
		this.plz = plz;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

}
