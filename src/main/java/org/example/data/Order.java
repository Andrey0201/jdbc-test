package org.example.data;

import java.time.LocalDate;

/**
 * @author Vladimir Bratchikov on 26.11.22
 */
public class Order { // POJO, Entity

    private int id;
    private LocalDate creationDate;
    private String product;
    private int price;

    public Order(int id, String product, int count) {
        this.id = id;
        this.product = product;
        this.price = count;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
