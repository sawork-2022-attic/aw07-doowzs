package edu.nju.sa2022.micropos.cart;

import edu.nju.sa2022.micropos.cart.dto.CartDto;
import edu.nju.sa2022.micropos.models.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface CartMapper {

    Cart toCart(CartDto cartDto);

    CartDto toCartDto(Cart cart);

}
