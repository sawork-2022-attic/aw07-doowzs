package com.micropos.carts.mapper;

import com.micropos.carts.model.Item;
import com.micropos.carts.dto.ItemDto;
import org.mapstruct.Mapper;

@Mapper
public interface ItemMapper {

    Item toItem(ItemDto itemDto);

    ItemDto toItemDto(Item item);
}
