package homework2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Component
@Scope("prototype")
public class Cart implements Consumer<Product> {
    private final Map<Integer, Product> products = new HashMap<>(); // дз

    public void add(Product product) {
        products.put(product.getId(), product);
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
