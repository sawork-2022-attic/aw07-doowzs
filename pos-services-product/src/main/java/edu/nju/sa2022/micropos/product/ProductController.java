package edu.nju.sa2022.micropos.product;

import edu.nju.sa2022.micropos.models.Product;
import edu.nju.sa2022.micropos.product.api.ProductsApi;
import edu.nju.sa2022.micropos.product.dto.ProductDto;
import edu.nju.sa2022.micropos.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductController implements ProductsApi {

    private final ProductMapper productMapper;
    private final ProductService productService;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @Override
    public ResponseEntity<List<ProductDto>> listProducts() {
        List<ProductDto> products = productMapper.toProductsDto(this.productService.listProducts());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDto> showProductById(String productId) {
        Product product = this.productService.getProduct(productId);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productMapper.toProductDto(product), HttpStatus.OK);
    }

}
