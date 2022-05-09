package edu.nju.sa2022.micropos.services.rest;

import edu.nju.sa2022.micropos.models.Product;
import edu.nju.sa2022.micropos.services.ProductService;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProductServiceRestImpl implements ProductService {

    private final RestTemplate restTemplate;

    public ProductServiceRestImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> listProducts() {
        throw new UnsupportedOperationException("not implemented in rest impl");
    }

    @Override
    public Product findProduct(String productId) {
        String url = String.format("http://product-service/raw/products/%s", productId);
        return restTemplate.getForEntity(url, Product.class).getBody();
    }

    @Override
    public Product saveProduct(Product product) {
        throw new UnsupportedOperationException("not implemented in rest impl");
    }
}
