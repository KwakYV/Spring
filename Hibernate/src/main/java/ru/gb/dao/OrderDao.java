package ru.gb.dao;

import ru.gb.entity.Order;

import java.util.List;

public interface OrderDao {
    public List<Order> findOrdersByCustomer(Long customerId);
    public Order save(Order order);
    public Long maxNumber();
}
