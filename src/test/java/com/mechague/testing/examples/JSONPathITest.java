package com.mechague.testing.examples;


import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:test-application.properties"})
public class JSONPathITest {


    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void retrieveAllItems_JSONPath() throws Exception {
        String items  = testRestTemplate.getForObject("/items", String.class);
        DocumentContext context = JsonPath.parse(items);
        int length = context.read("$.length()");

        assertThat(length)
                .isEqualTo(length);

        List<Integer> ids = context.read("$..id");
        assertThat(ids)
                .allMatch(x->x>1);
    }
}
