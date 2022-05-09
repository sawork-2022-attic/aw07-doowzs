package edu.nju.sa2022.micropos.cart.mapper;

import edu.nju.sa2022.micropos.cart.model.Cart;
import edu.nju.sa2022.micropos.cart.dto.CartDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface CartMapper {

    Cart toCart(CartDto cartDto);

    CartDto toCartDto(Cart cart);
}
