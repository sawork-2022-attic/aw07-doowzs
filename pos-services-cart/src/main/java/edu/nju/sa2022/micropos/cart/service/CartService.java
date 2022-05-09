package edu.nju.sa2022.micropos.cart.service;

import edu.nju.sa2022.micropos.cart.model.Cart;

public interface CartService {

    Cart getCart();

    Cart addItem(String productId, int amount);

    Cart removeItem(String productId);

    double checkout();

}
