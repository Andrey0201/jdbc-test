package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.example.data.Customer;
import org.example.sql.CustomerReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * @author Vladimir Bratchikov on 03.12.22
 */
public class CustomerCounterTest {

    @Test
    public void testCalcCount() {
        List<Customer> testList = new ArrayList<>();
        testList.add(new Customer(1, "Ivan", "i1@gmail.com", LocalDate.now(),19));
        testList.add(new Customer(2, "Olga", "i2@gmail.com", LocalDate.now(),29));
        testList.add(new Customer(3, "Ivan", "i3@gmail.com", LocalDate.now(),39));
        testList.add(new Customer(4, "Oleg", "i4@gmail.com", LocalDate.now(),49));

        CustomerReader reader = Mockito.mock(CustomerReader.class);//!!!!
        Mockito.when(reader.readAll()).thenReturn(testList);

        CustomerCounter customerCounter = new CustomerCounter(reader);
        long res = customerCounter.getCountByName("Ivan");
        Assertions.assertEquals(2, res);

        res = customerCounter.getCountByName(null);
        Assertions.assertEquals(0, res);
    }

}
