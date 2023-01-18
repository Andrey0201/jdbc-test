package org.example.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladimir Bratchikov on 26.11.22
 */
public class Customer { // POJO, Entity

    private int id;
    private String name;
    private String email;
    private LocalDate creationDate;
    private int age;
    private List<Order> order = new ArrayList<>();

    public Customer(int id, String name, String email, LocalDate creationDate, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.creationDate = creationDate;
        this.age = age;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", creationDate=" + creationDate +
            ", age=" + age +
            ", order=" + order +
            '}';
    }
}
