package edu.nju.sa2022.micropos.order;

import edu.nju.sa2022.micropos.models.Order;
import edu.nju.sa2022.micropos.order.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    OrderDto toOrderDto(Order order);

}
