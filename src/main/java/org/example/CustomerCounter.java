package org.example;

import java.util.List;
import org.example.data.Customer;
import org.example.sql.CustomerReader;

/**
 * @author Vladimir Bratchikov on 03.12.22
 */
public class CustomerCounter {

    private CustomerReader reader;

    public CustomerCounter(CustomerReader reader) {
        this.reader = reader;
    }

    public long getCountByName(String name) {
        if (name == null) {
            return 0;
        }

        List<Customer> list = reader.readAll();
        return list.stream()
            .filter(customer -> name.equals(customer.getName()))
            .count();
    }

}
