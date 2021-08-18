package de.Standard.Service;

import de.Standard.Model.Adresse;
import de.Standard.Repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdresseService
{
    private AdresseRepository adresseRepository;

    @Autowired
    public AdresseService(AdresseRepository adresseRepository){
        this.adresseRepository = adresseRepository;
    }

    public void saveAdresse(Adresse adress){
        adresseRepository.save(adress);
    }

    public void updatekunde(int id, Adresse adress){
        adresseRepository.findById(id);
        adresseRepository.save(adress);
    }

    public void deleteAdress(int id){
        adresseRepository.deleteById(id);
    }

    public Adresse getAdress(int id){
        return adresseRepository.findById(id).get();
    }

    public List<Adresse> getAllAdresse() {
        List<Adresse> adresslist = new ArrayList<Adresse>();
        adresseRepository.findAll().forEach(adress -> adresslist.add(adress));

        return adresslist;
    }
}
