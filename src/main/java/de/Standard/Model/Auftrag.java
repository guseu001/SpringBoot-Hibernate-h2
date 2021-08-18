package de.Standard.Model;

import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;

@Entity
@Table
public class Auftrag implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Auftrag_ID")
    private int id;
    @Column(name = "AuftragNr")
    private int auftragNummer;
    @OneToOne
    private Bestellung bestellung;

    @Column
    private boolean sortieren;

    public Auftrag(){
        int erstellAuftragnummer = new Random().nextInt();
        this.auftragNummer = erstellAuftragnummer > 0 ? erstellAuftragnummer : erstellAuftragnummer * -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuftragNummer() {
        return auftragNummer;
    }

    public void setAuftragNummer(int auftragNummer) {
        this.auftragNummer = auftragNummer;
    }

    public Bestellung getBestellung() {
        return bestellung;
    }

    public void setBestellung(Bestellung bestellung) {
        this.bestellung = bestellung;
    }

}
