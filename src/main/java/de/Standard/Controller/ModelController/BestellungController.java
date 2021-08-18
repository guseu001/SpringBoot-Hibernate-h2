package de.Standard.Controller;

import de.Standard.Model.Bestellung;

import de.Standard.Model.Items;
import de.Standard.Service.BestellungsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BestellungController
{
    @Autowired
    BestellungsService bestellungsService;

    @PostMapping("/bestellung")
    public void addbestellung(@RequestBody Bestellung bestellung){
        bestellungsService.addbestellung(bestellung);
        System.out.println(bestellung.getBestellung().size());
    }

    @GetMapping("/bestellung")
    public List<Bestellung> listOfBestellung(){
       return bestellungsService.getAllBestellung();
    }
}
