package gb.ru.order.dto.mapper;

import gb.ru.order.dto.OrderDto;
import gb.ru.order.dto.ProductDto;
import gb.ru.order.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = ProductMapper.class)
public interface OrderMapper {
    OrderDto toOrderDto(Order order);
    Order toOrder(OrderDto orderDto);
  }
