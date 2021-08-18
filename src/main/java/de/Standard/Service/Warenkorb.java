package de.Standard.Service;

import de.Standard.Model.Items;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Warenkorb
{
    /*
        list of Item zur Bestellung
     */
    private List<Items> listofItems;

    public Warenkorb(){
        this.listofItems = new ArrayList<Items>();
    }

    public List<Items> getlistOfItems() {
        return listofItems;
    }

    public void setListofItems(List<Items> warenkorb) {
        this.listofItems = warenkorb;
    }

    public void addItemIntoList(Items item){
        listofItems.add(item);
    }

    public void deleteItem(Items item){
        listofItems.remove(item);
    }

    public void listOfItemLeeren(){
        listofItems.clear();
    }

}
