package com.micropos.carts.service;

import com.micropos.carts.model.Cart;
import com.micropos.carts.model.Item;
import com.micropos.carts.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartServiceImpl implements CartService {

    private Cart cart; // session scope

    public CartServiceImpl(Cart cart) {
        this.cart = cart;
    }

    @Override
    public Cart getCart() {
        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }

    @Override
    public Cart addItem(String productId, int amount) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> productResponse = restTemplate
                .getForEntity("http://localhost:8080/api/products/" + productId, Product.class);
        cart.addItem(new Item(productResponse.getBody(), amount));
        return cart;
    }

    @Override
    public Cart removeItem(String productId) {
        cart.removeItem(productId);
        return cart;
    }

    @Override
    public double checkout() {
        double total = cart.getTotal();
        cart.clear();
        return total;
    }
}
