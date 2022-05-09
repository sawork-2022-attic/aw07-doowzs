package edu.nju.sa2022.micropos.cart;

import edu.nju.sa2022.micropos.cart.dto.CartDto;
import edu.nju.sa2022.micropos.models.Cart;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CartMapper {

    Cart toCart(CartDto cartDto);

    CartDto toCartDto(Cart cart);

}
