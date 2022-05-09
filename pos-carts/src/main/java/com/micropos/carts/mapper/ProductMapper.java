package com.micropos.carts.mapper;

import com.micropos.carts.model.Product;
import com.micropos.carts.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    Product toProduct(ProductDto productDto);

    ProductDto toProductDto(Product product);
}
