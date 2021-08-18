package de.Standard.Controller.WebController;

import de.Standard.Model.Adresse;
import de.Standard.Model.Kunde;
import de.Standard.Service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaveKundeController
{
    @Autowired
    KundeService kundeService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Kunde kunde,
                             @ModelAttribute Adresse adress){
        ModelAndView modelAndView = new ModelAndView();

//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String passwortCodieren = passwordEncoder.encode(kunde.getPasswort());
//        kunde.setPasswort(passwortCodieren);

        kundeService.saveKunde(kunde, adress);
        modelAndView.setViewName("/HTML/LogUpConfirm");
        modelAndView.addObject("kunde", kunde);

        return modelAndView;
    }
}
