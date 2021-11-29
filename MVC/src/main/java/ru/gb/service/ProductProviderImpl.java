package ru.gb.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class ProductProviderImpl implements ProductProvider{
    private final List<Product> productList = new ArrayList<>();


    @PostConstruct
    public void init() {
        for (int i = 0; i<=10; i++){
            productList.add(Product.builder()
                    .title("Product_" + i)
                    .cost(10 + i)
                    .build()
            );
        }
    }

    @Override
    public Product getProduct(int id) {
        return productList.get(id);
    }
}
