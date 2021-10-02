package com.mechague.testing.examples;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping("/dummy-item")
    public Item getDummyItem(){
        return new Item(1,"Dummy", 10, 5);
    }

    @GetMapping("/dummy-item-from-service")
    public Item getDummyItemFromService(){
        return itemService.getDummyItem();
    }

    @GetMapping("/items")
    public List<Item> getItemsFromDatabase(){
        return itemService.getItems();
    }
}

