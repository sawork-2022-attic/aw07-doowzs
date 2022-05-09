package edu.nju.sa2022.micropos.product;

import edu.nju.sa2022.micropos.models.Product;
import edu.nju.sa2022.micropos.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listProducts() {
        return productRepository
                .findAll(Example.of(new Product()), Pageable.ofSize(100))
                .getContent();
    }

    @Override
    public Product findProduct(String productId) {
        return productRepository
                .findById(productId)
                .orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
