package de.Standard.Service;

import de.Standard.Model.Adresse;
import de.Standard.Model.Kunde;
import de.Standard.Repository.AdresseRepository;
import de.Standard.Repository.KundeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KundeService
{
    @Autowired
    KundeRepository kundeRepository;

    public void saveKunde(Kunde kunde){
        kundeRepository.save(kunde);
    }

    public void updatekunde(int id, Kunde kunde){
        kundeRepository.findById(id);
        kundeRepository.save(kunde);
    }

    public void delete(int id){
        kundeRepository.deleteById(id);
    }

    public Kunde getKunde(int id){
        return kundeRepository.findById(id).get();
    }

    public List<Kunde> getAllKunde() {
        List<Kunde> kundelist = new ArrayList<Kunde>();
        kundeRepository.findAll().forEach(kunde -> kundelist.add(kunde));

        return kundelist;
    }
}