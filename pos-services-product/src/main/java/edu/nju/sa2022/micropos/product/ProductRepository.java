package edu.nju.sa2022.micropos.product;

import edu.nju.sa2022.micropos.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}