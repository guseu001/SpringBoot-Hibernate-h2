package de.Standard.Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Warenkorb implements Serializable
{
    @Id
    @Column
    @GeneratedValue
    private long Id;
    @Column
    private List<Items> warenkorb;
    @Column
    private String bestellDatum;

    public Warenkorb(){
        this.bestellDatum = "" + new Date().toLocaleString();
    }

    public Warenkorb(List<Items> bestellung){
        this.warenkorb = bestellung;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public List<Items> getBestellung() {
        return warenkorb;
    }

    public void setBestellung(List<Items> warenkorb) {
        this.warenkorb = warenkorb;
    }

    public String getBestellDatum() {
        return bestellDatum;
    }

    public void setBestellDatum(String bestellDatum) {
        this.bestellDatum = bestellDatum;
    }
}
