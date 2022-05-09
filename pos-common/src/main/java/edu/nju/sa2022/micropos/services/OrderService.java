package edu.nju.sa2022.micropos.services;

import edu.nju.sa2022.micropos.models.Order;

public interface OrderService {

    Order findOrder(String orderId);

    Order createOrder();

}
