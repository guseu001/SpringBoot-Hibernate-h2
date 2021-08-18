package de.Standard.Controller;

import de.Standard.Model.Kunde;
import de.Standard.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class LoginController
{
    @GetMapping
    public Kunde getKunde(@PathVariable("id") String email, String passwort){
        return null;
    }
}
