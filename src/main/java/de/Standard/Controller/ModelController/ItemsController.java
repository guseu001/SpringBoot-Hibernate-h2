package de.Standard.Controller;

import de.Standard.Model.Items;
import de.Standard.Model.Rolle;
import de.Standard.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/store")
public class ItemsController
{
    @Autowired
    ItemsService itemsService;

    @GetMapping("/items")
    private List<Items> getAllItems(){
        return itemsService.getAllItems();
    }

    @GetMapping("/items/{id}")
    private Items getItem(@PathVariable("id") long id){
        return itemsService.getItems(id);
    }

    @DeleteMapping("/items/{id}")
    private void deleteItem(@PathVariable("id") long id){
        itemsService.deleteItem(id);
    }

    @PostMapping("/items")
    private void saveItem(@RequestBody Items item){
         itemsService.saveItem(item);
    }

}
