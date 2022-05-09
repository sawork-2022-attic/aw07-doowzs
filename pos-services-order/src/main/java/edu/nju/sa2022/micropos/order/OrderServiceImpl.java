package edu.nju.sa2022.micropos.order;

import edu.nju.sa2022.micropos.models.Order;
import edu.nju.sa2022.micropos.services.OrderService;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findOrder(String orderId) {
        return orderRepository
                .findById(orderId)
                .orElse(null);
    }

    @Override
    public Order createOrder() {
        throw new UnsupportedOperationException("not implemented");
    }

}
