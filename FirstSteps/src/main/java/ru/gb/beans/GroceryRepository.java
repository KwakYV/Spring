package ru.gb.beans;

import ru.gb.entity.Product;

import java.util.List;

public interface GroceryRepository {
    public List<Product> getProducts();
    public Product getProduct(int id);
}
