package com.mechague.testing.examples;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(value = HelloWorldController.class)
public class HelloWorldControllerTest {

    private final MockMvc mockMvc;

    @Autowired
    public HelloWorldControllerTest(MockMvc mockMvc){
         this.mockMvc = mockMvc;
    }

    @Test
    public void helloWorld_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello-world")
                        .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world"))
                .andReturn();
        //assertEquals("Hello world", result.getResponse().getContentAsString());
    }


}
