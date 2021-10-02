package com.mechague.testing.examples;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

    private final MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Autowired
    public ItemControllerTest(MockMvc mockMvc){
         this.mockMvc = mockMvc;
    }

    @Test
    public void dummyItem_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
                        .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1,name:Dummy,price:10,quantity:5}"))
                .andReturn();
        //assertEquals("Hello world", result.getResponse().getContentAsString());

        JSONAssert.assertEquals("{ id: 1 }", result.getResponse().getContentAsString(), false);
    }

    @Test
    public void dummyItemFromService_basic() throws Exception {

        Mockito.when(itemService.getDummyItem())
                .thenReturn(new Item(2,"Dummy from service", 10, 5));

        RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item-from-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        //assertEquals("Hello world", result.getResponse().getContentAsString());

        JSONAssert.assertEquals("{ id: 2 }", result.getResponse().getContentAsString(), false);
    }

    @Test
    public void retrieveAllItems_basic() throws Exception {

        Mockito.when(itemService.getItems())
                .thenReturn(Arrays.asList(
                        new Item(2,"Item", 10, 5),
                        new Item(3,"Item", 10, 5),
                        new Item(4,"Dummy from service", 10, 5)
                ));

        RequestBuilder request = MockMvcRequestBuilders.get("/items")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        //assertEquals("Hello world", result.getResponse().getContentAsString());

        JSONAssert.assertEquals("[{ id: 2 }, {id: 3}, {id: 4}]", result.getResponse().getContentAsString(), false);
    }
}
