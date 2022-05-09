package edu.nju.sa2022.micropos.cart.raw;

import edu.nju.sa2022.micropos.models.Order;
import edu.nju.sa2022.micropos.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("raw")
public class RawCartController {

    private final CartService cartService;

    public RawCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("checkout")
    public ResponseEntity<Order> checkout() {
        Order order = this.cartService.checkout();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
