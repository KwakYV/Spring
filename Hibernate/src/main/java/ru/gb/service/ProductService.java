package ru.gb.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Product;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    public Iterable<Product> findAll() {
        return productDao.findAll();
    }
}
