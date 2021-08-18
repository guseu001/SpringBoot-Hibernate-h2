package de.Standard.Controller.ModelController;

import de.Standard.Model.Users;
import de.Standard.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController
{
    @Autowired
    private UserService userService;
    private boolean ISLOGGING = false;

    @GetMapping("/login/user")
    public Users getKunde(@PathVariable("id") String email, String password){
        ISLOGGING = true;
        return userService.getUser(email, password);
    }
}
