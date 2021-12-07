package ru.gb.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.entity.Order;
import ru.gb.entity.Product;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {
    public List<Product> findAllByOrders(Order order, Sort sort);
}
