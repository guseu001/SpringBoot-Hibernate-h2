package de.Standard.Controller.WebController;

import de.Standard.Exception.PageNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController
{
    static int count = 1;

    /*
        URL Request Webseite
     */
    @RequestMapping(path = "/{webseite}")
    public String link(@PathVariable("webseite") String webseite) throws PageNotFoundException
    {
        System.out.println(count + " bin hier Request");

        switch (webseite)
        {
            case "login" : return "HTML/login";
            case "log" : return "HTML/LogUpForm";
            case "itemView" : return "HTML/itemView";
            case "ItemErfassungsView": return "HTML/ItemErfassungsView";
//            case "HTML/UpdateKundenDaten": return "HTML/UpdateKundenDaten";

            default: return "HTML/HomeView";
        }

    }
    /*
        Verlinkung für andere Seite
    */
    @GetMapping(path = "/{webseite}")
    public String getLink(@PathVariable("webseite") String webseite)
    {
        System.out.println("GETMapping " + count++);
        switch (webseite)
        {
            case "login": return "HTML/login";
            case "log" : return "HTML/LogUpForm";
            case "itemView" : return "HTML/itemView";
            case "ItemErfassungsView": return "HTML/ItemErfassungsView";
//            case "UpdateKundenDaten": return "HTML/UpdateKundenDaten";

            default: return "HTML/HomeView";
        }
    }

}
