package de.Standard.Controller.WebController;

import de.Standard.Exception.UserNoFoundException;
import de.Standard.MailConfig.MailSending;
import de.Standard.Model.Adresse;
import de.Standard.Model.Bestellung;
import de.Standard.Model.Users;
import de.Standard.Model.Login;
import de.Standard.Service.AdresseService;
import de.Standard.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerKundeDatenController
{
    @Autowired
    UserService userService;
    AdresseService adresseService;
    MailSending mailSending;
    private Users users;
    private Login login;
    private Adresse adress;
    private Bestellung bestellungslist;
    private boolean islogin;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Users users,
                             @ModelAttribute Adresse adress){
        ModelAndView modelAndView = new ModelAndView();

        userService.saveUser(users, adress);
        mailSending.sendmail(users.getEmail(), "Confirmation Email", "Bitte Bestätigen Sie Ihre Email");
        modelAndView.setViewName("/HTML/LogUpConfirm");
        modelAndView.addObject("users", users);

        return modelAndView;
    }

    @RequestMapping(value = "userprofil" , method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String email,
                              @RequestParam String passwort)
            throws UserNoFoundException
    {

        ModelAndView modelAndView = new ModelAndView();

        this.users = userService.getUser(email, passwort);

        if (users != null) {
            modelAndView.addObject("users", users);
            modelAndView.setViewName("/HTML/userprofil");
            islogin = true;

            return modelAndView;
        }
        else{
            modelAndView.addObject("email", email);
            modelAndView.setViewName("/HTML/UserNoFound");

            return modelAndView;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute Users users){
        ModelAndView modelAndView = new ModelAndView();

        if(islogin)
        {
           userService.updateUser(this.users.getKunde_id(), this.users, users);

           modelAndView.setViewName("/HTML/LogUpConfirm");
           modelAndView.addObject("users", users);
           modelAndView.addObject("altKunde", this.users);
        }
        return modelAndView;
    }

    @GetMapping("UpdateKundenDaten")
    public ModelAndView Viewdaten(){
        ModelAndView modelAndView = new ModelAndView();

        if(islogin)
        {
            modelAndView.setViewName("/HTML/UpdateKundenDaten");
            modelAndView.addObject("users", users);
        }
        return modelAndView;
    }
    /*
    @GetMapping(path = "/{link}")
    public ModelAndView LoginHandling(@PathVariable String link)
    {
        ModelAndView modelAndView = new ModelAndView();

        while(islogin)
        {
            switch (link){
                case "UpdateKundenDaten" :
                    modelAndView.setViewName("/HTML/UpdateKundenDaten");
                    modelAndView.addObject("users", users);
                case "UpdateAdressenDaten" :
                    modelAndView.setViewName("HTML/UpdateAdressenDaten");
                    modelAndView.addObject("adress", adress);
                case "showAllBestellung" :
                    modelAndView.setViewName("HTML/showAllBestellungen");
                    modelAndView.addObject("bestellungslist", bestellungslist);
                case "showAllStornierung" :
                    modelAndView.setViewName("HTML/showAllStornierung");
                    modelAndView.setViewName("storniert");
                case "Abmelden" :
                    users = null;
                    adress = null;
                    islogin = false;
                    break;
                default: ;
            }
        }
        return modelAndView;
    }

     */
}
