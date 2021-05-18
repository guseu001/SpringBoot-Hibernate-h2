package de.Standard.Controller;

import de.Standard.Model.Adresse;
import de.Standard.Model.Kunde;
import de.Standard.Model.Login;
import de.Standard.Service.AdresseService;
import de.Standard.Service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController
{
    @Autowired
    KundeService kundeService;
    @Autowired
    AdresseService adresseService;

    @RequestMapping("/log")
    public String index(){
        return "LogUpForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Kunde kunde, Adresse adress){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Antwort");
        modelAndView.addObject("kunde", kunde);
        modelAndView.addObject("adress" , adress);
        kundeService.saveKunde(kunde);
        adresseService.saveAdresse(adress);

        return modelAndView;
    }

    @RequestMapping("/login")
    public String userlogin(){
        return "Login";
    }

    @RequestMapping(value = "/userprofil", method = RequestMethod.GET)
    public ModelAndView getUser(@ModelAttribute Login login){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Antwort");

        return modelAndView;
    }
}
