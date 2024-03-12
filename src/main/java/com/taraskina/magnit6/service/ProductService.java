package com.taraskina.magnit6.service;

import com.taraskina.magnit6.DbManager;
import com.taraskina.magnit6.entity.Order;
import com.taraskina.magnit6.entity.OrderProduct;
import com.taraskina.magnit6.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductService {
    public List<OrderProduct> getAllByNumber(int number){

        List<OrderProduct> products = new ArrayList<>();

        try(Connection connection = DbManager.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select p.name, oP.amount, p.price, oP.amount*p.price, o.date " +
                            "from product p join orderProduct oP on p.id = oP.productId " +
                            "             join orders o on o.id = oP.orderId " +
                            "where o.id = "+ number)) {

            int i = 0;
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int amount = resultSet.getInt(2);
                double price = resultSet.getDouble(3);
                double cost = resultSet.getDouble(4);
                Date date = resultSet.getDate(5);
                products.add(new OrderProduct(new Order(date), new Product(name,
                        "select description from product where name = " + name,
                        price), amount));
                //System.out.println(name+"  "+ amount+ "  " +price+"  " +date);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public List<Order> task2(double maxSum, int quantity ){

       List<Order> orders = new ArrayList<>();

        try(Connection connection = DbManager.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select o.id, o.date from orders o " +
                            "join orderProduct oP on o.id = oP.orderId  " +
                            "join product p on p.id = oP.productId " +
                            "group by 1 " +
                            "having  sum(p.price*oP.amount)<" + maxSum +
                            " and count(oP.productId)=" + quantity)){

            while (resultSet.next()) {
                int orderId = resultSet.getInt(1);
                Date date = resultSet.getDate(2);
                orders.add(new Order(orderId, date));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    public List<Order> task3(String productName){

        List<Order> orders = new ArrayList<>();

        try(Connection connection = DbManager.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select o.id, o.date from orders o " +
                            "join orderProduct oP on o.id = oP.orderId "+
                            "join product p on p.id = oP.productId " +
                            "where p.name = \'" + productName +"\'")){

            while (resultSet.next()) {
                int orderId = resultSet.getInt(1);
                Date date = resultSet.getDate(2);
                orders.add(new Order(orderId, date));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
}
