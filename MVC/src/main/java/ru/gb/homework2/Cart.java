package ru.gb.homework2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Component
@Scope("prototype")
public class Cart implements Consumer<Product> {
    private final Map<Integer, Pair> products = new HashMap<>(); // дз

    public void add(Product product) {
        if (products.containsKey(product.getId())){
            Pair pair = products.get(product.getId());
            pair.setCount(pair.getCount() + 1);
        }else {
            products.put(product.getId(), new Pair(product, 1));
        }
    }

    public void deleteByProductId(Integer id) {
        products.remove(id);
    }

    public void showProductList() {
        System.out.println(products);
    }


    @Override
    public void accept(Product product) {
        add(product);
    }
}
