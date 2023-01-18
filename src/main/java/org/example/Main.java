package org.example;

import java.util.List;
import org.example.data.Customer;
import org.example.sql.CustomerCreator;
import org.example.sql.CustomerReader;

/**
 * @author Vladimir Bratchikov on 26.11.22
 */
public class Main {

    public static void main(String[] args) {
        CustomerCreator customerCreator = new CustomerCreator();
        customerCreator.create();

        CustomerReader customerReader = new CustomerReader();
        List<Customer> customers = customerReader.readAll();
        System.out.println(customers.size());

        CustomerCounter customerCounter = new CustomerCounter(customerReader);
        System.out.println(customerCounter.getCountByName("Oleg"));
    }

}
