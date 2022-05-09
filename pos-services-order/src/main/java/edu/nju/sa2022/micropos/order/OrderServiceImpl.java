package edu.nju.sa2022.micropos.order;

import edu.nju.sa2022.micropos.models.Order;
import edu.nju.sa2022.micropos.services.CartService;
import edu.nju.sa2022.micropos.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;

import java.util.List;

@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final StreamBridge streamBridge;

    public OrderServiceImpl(OrderRepository orderRepository,
                            CartService cartService,
                            StreamBridge streamBridge) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.streamBridge = streamBridge;
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
        order = orderRepository.save(order);
        log.info(String.format("Order created: %s total=%f", order.getId(), order.getTotal()));
        streamBridge.send("createOrder-out-0", order);
        return order;
    }

}
