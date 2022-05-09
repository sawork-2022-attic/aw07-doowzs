package edu.nju.sa2022.micropos.services.rest;

import edu.nju.sa2022.micropos.models.Cart;
import edu.nju.sa2022.micropos.models.Order;
import edu.nju.sa2022.micropos.services.CartService;
import org.springframework.web.client.RestTemplate;

public class CartServiceRestImpl implements CartService {

    private final RestTemplate restTemplate;

    public CartServiceRestImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Cart getCart() {
        throw new UnsupportedOperationException("not implemented in rest impl");
    }

    @Override
    public Cart addItem(String productId, int quantity) {
        throw new UnsupportedOperationException("not implemented in rest impl");
    }

    @Override
    public Cart removeItem(String productId) {
        throw new UnsupportedOperationException("not implemented in rest impl");
    }

    @Override
    public double getTotal() {
        throw new UnsupportedOperationException("not implemented in rest impl");
    }

    @Override
    public Order checkout() {
        String url = "lb://cart-service/raw/checkout";
        return restTemplate.getForEntity(url, Order.class).getBody();
    }

}
