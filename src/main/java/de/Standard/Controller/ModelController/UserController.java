package de.Standard.Controller.ModelController;

import de.Standard.Model.Adresse;
import de.Standard.Model.Users;
import de.Standard.Service.AdresseService;
import de.Standard.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{

    @Autowired
    UserService userService;
    @Autowired
    AdresseService adresseService;

    @GetMapping("/users")
    private List<Users> getAllUser(){
        return  userService.getAllUser();
    }

    @GetMapping("/user/{email}/{password}")
    private Users getUser(@PathVariable("email") String email, @PathVariable String password)
    {
        return userService.getUser(email, password);
    }

    @DeleteMapping("/user/{id}")
    private void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }

    @PostMapping("/user")
    private String saveUser(@RequestBody Users users, Adresse adress)
    {
        userService.saveUser(users, adress);
        return "Data save!";
    }

//    @PutMapping("/user/{id}")
//    private String updateKunde(@PathVariable("id") int id,
//                               @RequestBody Users kunde)
//    {
//        kundenservice.updateKunden(id, kunde);
//        return "changed";
//    }

}
