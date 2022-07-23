package org.add;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTest {

    private Addition main = new Addition();

    @BeforeEach
    public void setUp() {
        main = new Addition();
    }

    @Test
    public void testAddition(){
        assertEquals(16, main.addition(9,7));
    }
}
