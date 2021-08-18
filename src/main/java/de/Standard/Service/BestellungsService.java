package de.Standard.Service;

import de.Standard.Model.Bestellung;
import de.Standard.Repository.BestellungsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BestellungsService
{
    private BestellungsRepository bestellungsRepository;

    @Autowired
    Warenkorb warenkorb;

    @Autowired
    public BestellungsService(BestellungsRepository bestellungsRepository){
        this.bestellungsRepository = bestellungsRepository;
    }

    public Bestellung getBestellung(long id){
        return bestellungsRepository.findById(id).get();
    }

    public List<Bestellung> getAllBestellung(){
        List<Bestellung> allOfBestellung = new ArrayList<Bestellung>();
        bestellungsRepository.findAll().forEach(bestellung -> allOfBestellung.add(bestellung));

        return allOfBestellung;
    }

    public void addbestellung(Bestellung bestellung){
        bestellung.setBestellung(warenkorb.getlistOfItems());

        if (bestellung.getBestellung().size() > 0 )
            bestellungsRepository.save(bestellung);
        else
            System.out.println("du hast keine Item in der Warenkorb");

        warenkorb.listOfItemLeeren();
    }

}
