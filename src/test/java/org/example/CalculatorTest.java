package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Vladimir Bratchikov on 03.12.22
 */
public class CalculatorTest {

    private static Calculator<Long> calc;

    @BeforeAll
    public static void prepare() {
        calc = new Calculator<>("long calc", 10);
    }

    @Test
    public void testCalcSum(){
        Double aDouble = calc.calcSum(100L, 50L);
        Assertions.assertNotNull(calc.getName());
        Assertions.assertEquals("long calc (10)", calc.getName());
        Assertions.assertEquals(150.0, aDouble, 0.01);
    }

}
