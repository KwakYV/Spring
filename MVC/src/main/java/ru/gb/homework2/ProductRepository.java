package ru.gb.homework2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        products.add(new Product(0, "Bread", 30));
        products.add(new Product(1, "Milk", 40));
        products.add(new Product(2, "Orange", 50));
        products.add(new Product(3, "Banana", 60));
        products.add(new Product(4, "Water", 70));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public Optional<Product> findById(Integer id) {
        if (id >= 0 && id < (products.size())) {
            return Optional.of(products.get(id));
        } else {
            return Optional.empty();
        }
    }
}
