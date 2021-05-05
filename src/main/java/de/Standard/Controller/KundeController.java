package de.Standard.Controller;

import de.Standard.Model.Kunde;
import de.Standard.Service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KundeController
{
    @Autowired
    KundeService kundenservice;

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
    private void saveKunde(@RequestBody Kunde kunde)
    {
        kundenservice.saveKunde(kunde);
    }
}
