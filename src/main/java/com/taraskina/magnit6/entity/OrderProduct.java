package com.taraskina.magnit6.entity;

import java.util.List;

public class OrderProduct {
    int id;
    Order order;
    Product product;
    int amount;

    public OrderProduct(int id, Order order, Product product, int amount) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.amount = amount;
    }

    public OrderProduct(Order order, Product product, int amount) {
        this.order = order;
        this.product = product;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}