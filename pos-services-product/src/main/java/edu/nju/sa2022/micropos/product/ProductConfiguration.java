package edu.nju.sa2022.micropos.product;

import edu.nju.sa2022.micropos.services.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }

}
