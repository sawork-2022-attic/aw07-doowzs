package edu.nju.sa2022.micropos.order;

import edu.nju.sa2022.micropos.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
