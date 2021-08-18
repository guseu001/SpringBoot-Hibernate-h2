package de.Standard.Controller.WebController;

import de.Standard.Model.Items;
import de.Standard.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaveItemController
{
    @Autowired
    ItemsService itemsService;

    @RequestMapping(value = "/Itemsave" , method = RequestMethod.POST)
    public ModelAndView saveItem(@ModelAttribute Items item){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/HTML/ItemView");
        modelAndView.addObject("item", item);
        itemsService.saveItem(item);

        return modelAndView;
    }
}
