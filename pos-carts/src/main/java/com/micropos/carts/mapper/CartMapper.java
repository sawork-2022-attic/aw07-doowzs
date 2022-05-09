package com.micropos.carts.mapper;

import com.micropos.carts.model.Cart;
import com.micropos.carts.dto.CartDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface CartMapper {

    Cart toCart(CartDto cartDto);

    CartDto toCartDto(Cart cart);
}
