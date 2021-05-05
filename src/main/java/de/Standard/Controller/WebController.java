package de.Standard.Controller;

import de.Standard.Model.Kunde;
import de.Standard.Service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController
{
    @Autowired
    KundeService kundeService;

    @RequestMapping("/log")
    public String index(){
        return "LogUpForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Kunde kunde){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Antwort");
        modelAndView.addObject("kunde", kunde);
        kundeService.saveKunde(kunde);

        return modelAndView;
    }
}
