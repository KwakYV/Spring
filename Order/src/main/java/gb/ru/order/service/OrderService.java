package gb.ru.order.service;

import gb.ru.order.dao.OrderDao;
import gb.ru.order.dto.OrderDto;
import gb.ru.order.dto.mapper.OrderMapper;
import gb.ru.order.entity.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderDao orderDao;
    private final OrderMapper orderMapper;


    @Transactional
    public OrderDto save(OrderDto orderDto){
        Order order = orderMapper.toOrder(orderDto);
        if (order.getId() != null) {
            //TODO update order in DB
        }
        return orderMapper.toOrderDto(orderDao.save(order));
    }

    @Transactional(readOnly = true)
    public Long findMaxNumber(){
        return orderDao.findMaxNumber();
    }

    public OrderDto findById(Long id){
        return orderMapper.toOrderDto(orderDao.findById(id).orElse(Order.builder().build()));
    }
}
