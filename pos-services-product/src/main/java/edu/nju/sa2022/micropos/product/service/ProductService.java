package edu.nju.sa2022.micropos.product.service;

import edu.nju.sa2022.micropos.product.model.Product;

import java.util.List;

public interface ProductService {


    public List<Product> products();

    public Product getProduct(String id);

    public Product randomProduct();
}
