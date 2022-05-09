package com.micropos.carts.service;

import com.micropos.carts.model.Cart;

public interface CartService {

    Cart getCart();

    Cart addItem(String productId, int amount);

    Cart removeItem(String productId);

    double checkout();

}
