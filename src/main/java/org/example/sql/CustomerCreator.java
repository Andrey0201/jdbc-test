package org.example.sql;

import com.google.common.collect.Lists;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Vladimir Bratchikov on 26.11.22
 */
public class CustomerCreator {

    private static final List<String> NAMES = Lists.newArrayList("Oleg", "Olena", "Igor");
    private static final List<String> LAST_NAMES = Lists.newArrayList("Overko", "Petrenko", "Sternenko");
    private static final List<String> PRODUCTS = Lists.newArrayList("Morshynska", "CocaCola", "Powerbank", "Tuna");

    public void create() {

        try (Connection connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/testDB",
            "postgres",
            "postgres")) {
            createRandomCustomer(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createRandomCustomer(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String name = getRandomName();
            int age = getRandomNumber(10, 80);
            String email = name + "_" + getRandomLastName() + "@gm.com";
            statement.execute("insert into my_store.customers (creation_date, email, name, age)"
                                  + "values ('" + LocalDate.now() + "', '" + email + "', '" + name + "', " + age
                                  + ");");
            createRandomOrder(statement);
            createRandomOrder(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createRandomOrder(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select currval('my_store.my_store_id_seq');");
        resultSet.next();
        int anInt = resultSet.getInt(1);
        statement.execute("insert into my_store.orders (customer_id, creation_date, product, price)\n"
                              + "values (" + anInt + ", '" + LocalDate.now() + "', '" + getRandomProduct() + "', "
                              + getRandomNumber(1, 10) + ")");
    }

    private static String getRandomName() {
        int i = getRandomNumber(0, NAMES.size());
        return NAMES.get(i);
    }

    private static String getRandomLastName() {
        int i = getRandomNumber(0, LAST_NAMES.size());
        return LAST_NAMES.get(i);
    }

    private static String getRandomProduct() {
        int i = getRandomNumber(0, PRODUCTS.size());
        return PRODUCTS.get(i);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
