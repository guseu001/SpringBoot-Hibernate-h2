package de.Standard.Controller;

import de.Standard.Model.Adresse;
import de.Standard.Service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdressController
{
    @Autowired
    AdresseService adresseService;

    @GetMapping("/adress")
    private List<Adresse> getAllAdresse(){
        return adresseService.getAllAdresse();
    }

    @GetMapping("/adress/{adress_id}")
    private Adresse getAdress(@PathVariable("adress_id") int id){
        return adresseService.getAdress(id);
    }

    @DeleteMapping("/adress/{id}")
    private void deleteAdress(@PathVariable("id") int id){
        adresseService.deleteAdress(id);
    }

    @PostMapping("/adress")
    private void saveAdress(@RequestBody Adresse adress)
    {
        adresseService.saveAdresse(adress);
    }
}