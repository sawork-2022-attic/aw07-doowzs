package edu.nju.sa2022.micropos.cart;

import edu.nju.sa2022.micropos.services.CartService;
import edu.nju.sa2022.micropos.services.ProductService;
import edu.nju.sa2022.micropos.services.rest.ProductServiceRestImpl;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CartConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CartService cartService(CartRepository cartRepository,
                                   ProductService productService) {
        return new CartServiceImpl(cartRepository, productService);
    }

    @Bean
    public ProductService productService(RestTemplate restTemplate) {
        return new ProductServiceRestImpl(restTemplate);
    }

}
