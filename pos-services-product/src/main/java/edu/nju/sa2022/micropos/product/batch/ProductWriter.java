package edu.nju.sa2022.micropos.product.batch;

import edu.nju.sa2022.micropos.models.Product;
import edu.nju.sa2022.micropos.services.ProductService;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ProductWriter implements ItemWriter<Product>{

    private final ProductService productService;

    public ProductWriter(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void write(List<? extends Product> products) throws Exception {
        for (Product product : products) {
            productService.saveProduct(product);
        }
    }

}
