package ru.gb.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.gb.dao.OrderDao;
import ru.gb.entity.Order;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderDao orderDao;

    public List<Order> findOrdersByCustomer(Long customerId) {
        return orderDao.findOrdersByCustomer(customerId);
    }

    public Order save(Order order) {
        return orderDao.save(order);
    }

    public Long maxNumber(){
        return orderDao.maxNumber();
    }
}
