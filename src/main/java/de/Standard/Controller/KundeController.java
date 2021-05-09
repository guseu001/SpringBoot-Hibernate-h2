package de.Standard.Controller;

import de.Standard.Model.Adresse;
import de.Standard.Model.Kunde;
import de.Standard.Service.AdresseService;
import de.Standard.Service.KundeService;
import de.Standard.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KundeController
{
    @Autowired
    KundeService kundenservice;
    @Autowired
    AdresseService adresseService;

    @GetMapping("/kunde")
    private @ResponseBody Iterable<Kunde> getAllKunde(){
        return  kundenservice.getAllKunde();
    }

    @GetMapping("/kunde/{id}")
    private @ResponseBody Kunde getKunde(@PathVariable("id") int id){
        return kundenservice.getKunde(id);
    }

    @DeleteMapping("/kunde/{id}")
    private void deleteKunde(@PathVariable("id") int id){
        kundenservice.delete(id);
    }

    @PostMapping("/kunde")
    private void saveKunde(@RequestBody Kunde kunde, Adresse adress)
    {
        kundenservice.saveKunde(kunde);
        adresseService.saveAdresse(adress);

    }
}
