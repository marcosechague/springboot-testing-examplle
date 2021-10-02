package com.mechague.testing.examples;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ItemRepositoryTest {

    private final ItemRepository itemRepository;
    @Autowired
    public ItemRepositoryTest(ItemRepository itemRepository){
         this.itemRepository  = itemRepository;
    }

    @Test
    public void findAllIItems_basic() throws Exception {
        List<Item> items = itemRepository.findAll();
        assertEquals(3 , items.size());
    }
}
