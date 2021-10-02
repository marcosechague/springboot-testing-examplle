package com.mechague.testing.examples;


import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:test-application.properties"})
public class ItemControllerITest {


    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void retrieveAllItems_basic() throws Exception {
        String items  = testRestTemplate.getForObject("/items", String.class);
        JSONAssert.assertEquals("[{ id: 10001 }, {id: 10002}, {id: 10003}]", items, false);
    }
}
