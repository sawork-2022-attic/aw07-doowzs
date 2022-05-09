package edu.nju.sa2022.micropos.services;

import edu.nju.sa2022.micropos.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProducts();

    Product getProduct(String productId);

}
