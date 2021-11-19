package ru.gb.beans;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component("productRepository")
public class ProductRepository implements GroceryRepository {
    final private List<Product> productList;

    public ProductRepository(List<Product> productList) {
        this.productList = productList;
    }

    @PostConstruct
    public void initList(){
        for (int i = 0; i<=20; i++){
            productList.add(new Product(i, "Product - " + i, 10 + i));
        }
    }

    @Override
    public List<Product> getProducts() {
        return productList;
    }

    @Override
    public Product getProduct(int id) {
        List<Product> filtered = productList
                .stream()
                .filter(product -> product.getId() == id)
                .collect(Collectors.toList());
        return (filtered.isEmpty())? null:filtered.get(0);
    }
}
