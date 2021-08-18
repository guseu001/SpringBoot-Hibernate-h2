package de.Standard.Controller;

import de.Standard.Model.Adresse;
import de.Standard.Model.Items;
import de.Standard.Model.Kunde;
import de.Standard.Model.Login;
import de.Standard.Service.AdresseService;
import de.Standard.Service.ItemsService;
import de.Standard.Service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController
{
    @Autowired
    KundeService kundeService;
    @Autowired
    AdresseService adresseService;
    @Autowired
    ItemsService itemsService;

    int count = 1;
    @RequestMapping("/HTML/log")
    public String index(){
        System.out.println(count++);
        return "HTML/LogUpForm";
    }

    @GetMapping("/HTML/log")
    public String log(){
        System.out.println(count++);
        return "HTML/LogUpForm";
    }

    @RequestMapping("/HTML/itemView")
    public String itemview(){
        return "HTML/itemView";
    }

    @GetMapping("/HTML/itemView")
    public String item(){
        return "HTML/itemView";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Kunde kunde, Adresse adress){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/HTML/LogUpConfirm");
        modelAndView.addObject("kunde", kunde);
        modelAndView.addObject("adress" , adress);

//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String passwortCodieren = passwordEncoder.encode(kunde.getPasswort());
//        kunde.setPasswort(passwortCodieren);

        kundeService.saveKunde(kunde, adress);

        return modelAndView;
    }

    @RequestMapping("/HTML/login")
    public String userlogin(){
        return "/HTML/Login";
    }

    @RequestMapping(value = "userprofil" , method = RequestMethod.GET)
    public ModelAndView login(@ModelAttribute Login login)
    {
        System.out.println(login.getEmail() + " " + login.getPasswort());

        Kunde kunde = kundeService.getKunde(login.getEmail(), login.getPasswort());
//        modelMap.put("kunde" , kundeService.getAllKunde());
//        modelMap.addAttribute("kunde", kunde);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("kunde" , kunde);
        modelAndView.setViewName("/HTML/userprofil");

        return modelAndView;
    }


    @RequestMapping("/HTML/ItemErfassungsView")
    public String itemerfassungview(){
        return "/HTML/ItemErfassungsView";
    }

    @RequestMapping(value = "/Itemsave" , method = RequestMethod.POST)
    public ModelAndView saveItem(@ModelAttribute Items item){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/HTML/ItemView");
        modelAndView.addObject("item", item);
        itemsService.saveItem(item);

        return modelAndView;
    }

}
