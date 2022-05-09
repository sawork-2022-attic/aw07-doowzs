package edu.nju.sa2022.micropos.cart.mapper;

import edu.nju.sa2022.micropos.cart.model.Item;
import edu.nju.sa2022.micropos.cart.dto.ItemDto;
import org.mapstruct.Mapper;

@Mapper
public interface ItemMapper {

    Item toItem(ItemDto itemDto);

    ItemDto toItemDto(Item item);
}
