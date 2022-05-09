package edu.nju.sa2022.micropos.product.service;

import edu.nju.sa2022.micropos.product.model.Product;
import edu.nju.sa2022.micropos.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> products() {
        return productRepository.allProducts();
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.findProduct(id);
    }

    @Override
    public Product randomProduct() {
        return null;
    }
}
