package de.Standard.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "Bestellung")
public class Bestellung implements Serializable
{
    @Id
    @Column(name = "Bestell_ID")
    @GeneratedValue
    private long Id;
    @Column(name = "Bestellung_Nr")
    private int bestellungNr;
    @OneToMany(mappedBy = "bestellung")
    @OrderBy("bestellung")
    private List<Items> bestellung;
    @Column
    private String bestellDatum;
    @OneToOne
    private Auftrag auftrag;
    @Column
    private int anzahlItem;

    public Bestellung(){
        int erstellBestellNummer = new Random().nextInt();
        this.bestellungNr = erstellBestellNummer > 0 ? erstellBestellNummer : erstellBestellNummer * -1;
        this.bestellDatum = "" + new Date().toLocaleString();
        this.bestellung = new ArrayList<Items>();
        this.anzahlItem = bestellung.size();
    }

//    public Bestellung(List<Items> bestellungList){
//        this.bestellung = bestellungList;
//    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getBestellungNr() {
        return bestellungNr;
    }

    public void setBestellungNr(int bestellungNr) {
        this.bestellungNr = bestellungNr;
    }

    public List<Items> getBestellung() {
        return bestellung;
    }

    public void setBestellung(List<Items> bestellung) {
        this.bestellung = bestellung;
    }

    public String getBestellDatum() {
        return bestellDatum;
    }

    public void setBestellDatum(String bestellDatum) {
        this.bestellDatum = bestellDatum;
    }

    public Auftrag getAuftrag() {
        return auftrag;
    }

    public void setAuftrag(Auftrag auftrag) {
        this.auftrag = auftrag;
    }

    public int getAnzahlItem() {
        return anzahlItem;
    }

    public void setAnzahlItem(int anzahlItem) {
        this.anzahlItem = anzahlItem;
    }

}
