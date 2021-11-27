package homework2;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ShopControllerImpl implements ShopController {
    private final ProductRepository productRepository;
    private Cart cart;

    @Lookup
    @Override
    public Cart getCart() {
        return null;
    }

    public void showAssortment() {
        System.out.println(productRepository.findAll());
    }

    public void addProductFromCartById(Integer id) {
        productRepository.findById(id).ifPresent(cart);
    }

    public void deleteProductFromCartById(Integer id) {
        cart.deleteByProductId(id);
    }

    public void showProductsInCart() {
        cart.showProductList();
    }

    public void enterToShop() {
        this.cart = getCart();
    }
}
