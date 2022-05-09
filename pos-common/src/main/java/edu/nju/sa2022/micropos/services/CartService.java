package edu.nju.sa2022.micropos.services;

import edu.nju.sa2022.micropos.models.Cart;
import edu.nju.sa2022.micropos.models.Order;

public interface CartService {

    Cart getCart();

    Cart addItem(String productId, int quantity);

    Cart removeItem(String productId);

    double getTotal();

    Order checkout();

}
