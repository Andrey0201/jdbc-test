package org.example;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import org.example.data.Customer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Vladimir Bratchikov on 03.12.22
 */
public class MainTest {

    private List<Long> testList = new ArrayList<>();
    private static Customer testCustomer;

    @BeforeAll
    public static void createCustomer() {
        System.out.println("BeforeAll");
        testCustomer = new Customer();
        testCustomer.setName("Vasya");
    }

    @AfterAll
    public static void cleanCustomer() {
        System.out.println("AfterAll");
        testCustomer = null;
        // TODO and clear session
    }

    @BeforeEach
    public void generateData() {
        System.out.println("Generate");
        for (int i = 0; i < 10; i++) {
            testList.add(i * 10L);
        }
    }

    @AfterEach
    public void cleanData() {
        System.out.println("Clear");
        testList.clear();
    }

    @Test
    //    @Timeout(value = 5, unit = TimeUnit.MILLISECONDS)
    public void testDemo() {
        testHello();
        System.out.println("Test 1 " + testCustomer.getName());
        testList.add(999L);
        testList.forEach(System.out::println);
        Assertions.assertEquals(11, testList.size(), "List is broken");
        Assertions.assertTrue(true);
        Assertions.assertFalse(false);
        Assertions.assertNull(null);
        Assertions.assertNotNull("asdasdasd");
        assertThrows(RuntimeException.class, () -> {
            System.out.println("hello throw");
            throw new RuntimeException("test excp");
        });
    }

    @Test
    public void testDemo2() {
        testHello();
        System.out.println("Test 2 " + testCustomer.getName());
        testList.add(777L);
        testList.forEach(System.out::println);
    }

    private void testHello() {
        System.out.println("Hello");
    }

}
