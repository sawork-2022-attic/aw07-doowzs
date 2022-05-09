package edu.nju.sa2022.micropos.delivery;

import edu.nju.sa2022.micropos.models.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DeliveryRepository extends MongoRepository<Delivery, String> {

    List<Delivery> findAllByOrderId(String orderId);

}
