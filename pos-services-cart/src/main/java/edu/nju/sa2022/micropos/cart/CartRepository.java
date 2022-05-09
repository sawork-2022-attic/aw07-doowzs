package edu.nju.sa2022.micropos.cart;

import edu.nju.sa2022.micropos.models.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {
}
