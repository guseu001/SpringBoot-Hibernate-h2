package de.Standard.Controller.ModelController;

import de.Standard.Model.Adresse;
import de.Standard.Model.Users;
import de.Standard.Service.AdresseService;
import de.Standard.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class KundeController
{

    @Autowired
    UserService kundenservice;
    @Autowired
    AdresseService adresseService;

    @GetMapping("/kunde")
    private List<Users> getAllKunde(){
        return  kundenservice.getAllKunde();
    }

    @GetMapping("/kunde/{email}/{password}")
    private Users getKunde(@PathVariable("email") String email, @PathVariable String password)
    {
        return kundenservice.getKunde(email, password);
    }

    @DeleteMapping("/kunde/{id}")
    private void deleteKunde(@PathVariable("id") int id){
        kundenservice.delete(id);
    }

    @PostMapping("/users")
    private String saveKunde(@RequestBody Users users, Adresse adress)
    {
        kundenservice.saveKunde(users, adress);
        return "Data save!";
    }

//    @PutMapping("/kunde/{id}")
//    private String updateKunde(@PathVariable("id") int id,
//                               @RequestBody Users kunde)
//    {
//        kundenservice.updateKunden(id, kunde);
//        return "changed";
//    }

}
