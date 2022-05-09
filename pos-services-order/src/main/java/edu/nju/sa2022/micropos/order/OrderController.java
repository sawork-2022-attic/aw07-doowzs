package edu.nju.sa2022.micropos.order;

import edu.nju.sa2022.micropos.models.Order;
import edu.nju.sa2022.micropos.order.api.OrdersApi;
import edu.nju.sa2022.micropos.order.dto.OrderDto;
import edu.nju.sa2022.micropos.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrderController implements OrdersApi {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @Override
    public ResponseEntity<List<OrderDto>> listOrders() {
        List<Order> orders = orderService.listOrders();
        return new ResponseEntity<>(orderMapper.toOrderDtos(orders), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDto> findOrder(String orderId) {
        Order order = orderService.findOrder(orderId);
        return new ResponseEntity<>(orderMapper.toOrderDto(order), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDto> createOrder() {
        Order order = orderService.createOrder();
        return new ResponseEntity<>(orderMapper.toOrderDto(order), HttpStatus.OK);
    }

}
