package com.mechague.testing.examples;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @InjectMocks
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void retrieveAllItems_basic() throws Exception {
        Mockito.when(itemRepository.findAll())
                .thenReturn(Arrays.asList(
                        new Item(2,"Item", 10, 5),
                        new Item(3,"Item", 10, 5),
                        new Item(4,"Dummy from service", 10, 5)
                ));

        List<Item> items = itemService.getItems();

        assertEquals(10*5, items.get(0).getValue());

    }
}
