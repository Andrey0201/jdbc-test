package org.example.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.example.data.Customer;
import org.example.data.Order;

/**
 * @author Vladimir Bratchikov on 26.11.22
 */
public class CustomerReader {

    public List<Customer> readAll() {

        try (Connection connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/testDB",
            "postgres",
            "postgres");
            Statement statement = connection.createStatement();
            Statement statementOrders = connection.createStatement();) {


            ResultSet resultSet = statement.executeQuery("select * from my_store.customers WHERE age >= 18;");
            List<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                Customer customer = fillCustomer(resultSet);
                fillOrders(statementOrders, customer);
                customers.add(customer);
            }
            System.out.println(customers);
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private static Customer fillCustomer(ResultSet resultSet) throws SQLException {
        // Retrieve by column name
        Customer customer = new Customer();
        int id = resultSet.getInt("id");
        customer.setId(id);
        System.out.print("ID: " + id);

        String name = resultSet.getString("name");
        customer.setName(name);
        System.out.print(", name: " + name);

        String email = resultSet.getString("email");
        customer.setEmail(email);
        System.out.print(", email: " + email);

        int age = resultSet.getInt("age");
        customer.setAge(age);
        System.out.print(", age: " + age);

        Date date = resultSet.getDate("creation_date");
        LocalDate nDate = date.toLocalDate();
        customer.setCreationDate(nDate);
        System.out.print(", creation_date: " + nDate);
        System.out.println();
        return customer;
    }

    private static void fillOrders(Statement statementOrders, Customer customer) throws SQLException {
        ResultSet ordersRs = statementOrders.executeQuery("select *"
                                                              + "from my_store.orders "
                                                              + "left join my_store.customers custmrs on custmrs.id = orders.customer_id "
                                                              + "WHERE custmrs.id = " + customer.getId() + ";");
        while (ordersRs.next()) {
            Order order = new Order();
            int orderId = ordersRs.getInt("id");
            order.setId(orderId);
            String product = ordersRs.getString("product");
            order.setProduct(product);
            int price = ordersRs.getInt("price");
            order.setPrice(price);
            Date orderDate = ordersRs.getDate("creation_date");
            LocalDate nOrderDate = orderDate.toLocalDate();
            order.setCreationDate(nOrderDate);
            customer.getOrder().add(order);
        }
    }
}
