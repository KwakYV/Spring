package ru.gb.beans;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("cart")
@Scope("prototype")
@Getter
public class Cart {

    @Autowired
    private GroceryRepository productRepository;

    private final List<Product> productList = new ArrayList<>();

    public void add(Product product){
        productList.add(product);
    }

    public void remove(int id){
        Optional<Product> pop = productList
                .stream()
                .filter(product -> product.getId() == id)
                .findFirst();
        if (pop.isPresent()){
            productList.remove(pop.get());
        }
    }

}
