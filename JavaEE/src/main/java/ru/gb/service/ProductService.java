package ru.gb.service;

import ru.gb.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class ProductService {
    public List<Product> getProducts(int count){
        List<Product> result = new ArrayList<>();
        for (int i = 1; i <= count; i++){
            result.add(new Product(i, "Product " + i, i +10));
        }
        return result;
    }
}
