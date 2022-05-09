package edu.nju.sa2022.micropos.product.repository;


import edu.nju.sa2022.micropos.product.model.Product;

import java.util.List;

public interface ProductRepository {

    public List<Product> allProducts();

    public Product findProduct(String productId);

}