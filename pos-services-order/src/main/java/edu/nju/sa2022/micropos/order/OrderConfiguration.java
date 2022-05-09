package edu.nju.sa2022.micropos.order;

import edu.nju.sa2022.micropos.services.CartService;
import edu.nju.sa2022.micropos.services.OrderService;
import edu.nju.sa2022.micropos.services.rest.CartServiceRestImpl;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository, CartService cartService) {
        return new OrderServiceImpl(orderRepository, cartService);
    }

    @Bean
    public CartService cartService(RestTemplate restTemplate) {
        return new CartServiceRestImpl(restTemplate);
    }

}
