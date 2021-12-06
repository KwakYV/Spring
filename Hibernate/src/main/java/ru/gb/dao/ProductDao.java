package ru.gb.dao;

import ru.gb.entity.Product;

import java.util.List;

public interface ProductDao {
    public Iterable<Product> findAll();
    public Product findById(Long id);
    public String findTitleById(Long id);
}
