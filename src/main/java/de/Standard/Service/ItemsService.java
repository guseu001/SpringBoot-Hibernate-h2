package de.Standard.Service;

import de.Standard.Model.Items;
import de.Standard.Repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemsService
{
    private ItemsRepository itemsRepo;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository){
        this.itemsRepo = itemsRepository;
    }

    public void saveItem(Items item){
        itemsRepo.save(item);
    }

    public String updateItems(long id, Items item){
        itemsRepo.save(item);

        return "Changed !";
    }

    public void deleteItem(long id){
        itemsRepo.deleteById(id);
    }

    public Items getItems(long id){
        return itemsRepo.findById(id).get();
    }

    public List<Items> getAllItems(){
        List<Items> listOfItem = new ArrayList<Items>();
        itemsRepo.findAll().forEach(item -> listOfItem.add(item));
        return listOfItem;
    }
}
