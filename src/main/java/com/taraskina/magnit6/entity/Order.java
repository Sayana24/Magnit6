package com.taraskina.magnit6.entity;

import java.util.Date;
import java.util.List;

public class Order {
    int id;
    Date date;

    public Order(int id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Order(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
