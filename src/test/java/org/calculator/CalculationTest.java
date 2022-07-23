package org.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest {

    private Calculation calculation=new Calculation();

    @BeforeEach
    public void setUp() throws Exception {
        calculation = new Calculation();
    }

    @Test
    @DisplayName("Simple multiplication should work")
    public void testMultiply() {
        assertEquals(20, calculation.multiply(4,5),
                "Regular multiplication should work");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    public void testMultiplyWithZero() {
        assertEquals(0, calculation.multiply(0,5), "Multiple with zero should be zero");
        assertEquals(0, calculation.multiply(5,0), "Multiple with zero should be zero");
    }

    @Test
    @DisplayName("Simple add should work")
    public void testAdd() {
        assertEquals(9, calculation.add(4,5),
                "Regular add should work");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero in add")
    public void testADDWithZero() {
        assertEquals(5, calculation.add(0,5), "Add with zero should be zero");
        assertEquals(5, calculation.add(5,0), "Add with zero should be zero");
    }

//    @Test
//    @DisplayName("Divide by zero")
//    public void testDevideByZero() {
//        assertThrows(ArithmeticException.class,()-> calculator.divide(4,0), "Divide by zero work");
//    }

    @Test
   @DisplayName("Simple divide should work")
    public void testDivide() {
        double x=7/6;
        assertEquals(x, calculation.divide(7,6),
                "Regular devide should work");
    }

}