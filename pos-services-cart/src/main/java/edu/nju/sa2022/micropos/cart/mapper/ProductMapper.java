package edu.nju.sa2022.micropos.cart.mapper;

import edu.nju.sa2022.micropos.cart.model.Product;
import edu.nju.sa2022.micropos.cart.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    Product toProduct(ProductDto productDto);

    ProductDto toProductDto(Product product);
}
