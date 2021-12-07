package ru.gb.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.entity.Order;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Long> {
//    public List<Order> findOrdersByCustomer(Long customerId);
//    public Order save(Order order);
    @Query("select max(o.number) from Order o")
    public Long maxNumber();
    public List<Order> findAllByCustomer_Id(Long customer_id);
    public List<Order> findAllByCustomer_Id(Long customer_id, Sort sort);

}
