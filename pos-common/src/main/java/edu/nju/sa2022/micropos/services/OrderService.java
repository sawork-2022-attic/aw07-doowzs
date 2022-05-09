package edu.nju.sa2022.micropos.services;

import edu.nju.sa2022.micropos.models.Order;

import java.util.List;

public interface OrderService {

    List<Order> listOrders();

    Order findOrder(String orderId);

    Order createOrder();

}
