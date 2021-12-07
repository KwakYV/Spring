package ru.gb.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Order;
import ru.gb.entity.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    public Iterable<Product> findAll() {
        return productDao.findAll();
    }

    public Product findById(Long id){
        return productDao.findById(id).orElse(null);
    }

    public List<Product> findAllByOrderDesc(Order order){
        return productDao.findAllByOrders(order, Sort.by(Sort.Direction.DESC, "cost"));
    }

    public List<Product> findAllByOrderAsc(Order order){
        return productDao.findAllByOrders(order, Sort.by(Sort.Direction.ASC, "cost"));
    }
}
