package edu.nju.sa2022.micropos.product.raw;

import edu.nju.sa2022.micropos.models.Product;
import edu.nju.sa2022.micropos.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("raw")
public class RawProductController {

    private final ProductService productService;

    public RawProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId) {
        Product product = this.productService.findProduct(productId);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
