package edu.nju.sa2022.micropos.order;

import edu.nju.sa2022.micropos.models.Order;
import edu.nju.sa2022.micropos.services.CartService;
import edu.nju.sa2022.micropos.services.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartService cartService;

    public OrderServiceImpl(OrderRepository orderRepository, CartService cartService) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
    }

    @Override
    public List<Order> listOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrder(String orderId) {
        return orderRepository
                .findById(orderId)
                .orElse(null);
    }

    @Override
    public Order createOrder() {
        Order order = cartService.checkout();
        return orderRepository.save(order);
    }

}
