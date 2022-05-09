package edu.nju.sa2022.micropos.cart;

import edu.nju.sa2022.micropos.models.Cart;
import edu.nju.sa2022.micropos.models.Order;
import edu.nju.sa2022.micropos.models.Product;
import edu.nju.sa2022.micropos.services.CartService;
import edu.nju.sa2022.micropos.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;

    public CartServiceImpl(CartRepository cartRepository, ProductService productService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
    }

    @Override
    public Cart getCart() {
        final String userId = "zty";  // TODO: use real userID
        Optional<Cart> optional = cartRepository.findById(userId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            Cart cart = Cart.builder().userId(userId).build();
            cartRepository.save(cart);
            return cart;
        }
    }

    @Override
    public Cart addItem(String productId, int quantity) {
        Cart cart = getCart();
        cart.addItem(productId, quantity);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart removeItem(String productId) {
        Cart cart = getCart();
        cart.removeItem(productId);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public double getTotal() {
        Cart cart = getCart();
        return getTotal(cart);
    }

    private double getTotal(Cart cart) {
        return cart.getItems()
                .entrySet().stream()
                .mapToDouble((entry) -> {
                    final String productId = entry.getKey();
                    final Integer quantity = entry.getValue();
                    final Product product = productService.findProduct(productId);
                    return product.getPrice() * quantity;
                })
                .sum();
    }

    @Override
    public Order checkout() {
        Cart cart = getCart();
        cartRepository.delete(cart);
        return Order.builder()
                .userId(cart.getUserId())
                .items(cart.getItems())
                .total(getTotal(cart))
                .build();
    }

}
