package edu.nju.sa2022.micropos.product.mapper;

import com.micropos.products.dto.ProductDto;
import edu.nju.sa2022.micropos.product.model.Product;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper
public interface ProductMapper {

    Collection<ProductDto> toProductsDto(Collection<Product> products);

    Collection<Product> toProducts(Collection<ProductDto> products);

    Product toProduct(ProductDto productDto);

    ProductDto toProductDto(Product pet);
}
