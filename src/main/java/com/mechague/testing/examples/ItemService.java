package com.mechague.testing.examples;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item getDummyItem(){
        return new Item(2,"Dummy from service", 10, 5);
    }

    public List<Item> getItems(){
        List<Item> items = itemRepository.findAll();
        items.forEach( item -> item.setValue(item.getQuantity() * item.getPrice()));

        return items;
    }

}
