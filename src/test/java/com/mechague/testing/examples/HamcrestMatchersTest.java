package com.mechague.testing.examples;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void hamcrestTest() {
        List<Integer> ints = Arrays.asList(1,2,3);
        assertThat(ints, hasSize(3));
        assertThat(ints, hasItems(3,2));
        assertThat(ints, everyItem(greaterThan(0)));
    }
}
