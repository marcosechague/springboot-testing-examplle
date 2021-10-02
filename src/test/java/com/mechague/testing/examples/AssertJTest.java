package com.mechague.testing.examples;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void assertJTest() {
        List<Integer> ints = Arrays.asList(1,2,3);
        assertThat(ints)
                .hasSize(3)
                .contains(2,1)
                .allMatch(x->x>0);
    }
}
