package ru.gb.homework2;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@RequiredArgsConstructor
@Component
@Scope("prototype")
public class Buyer {

    private final ShopControllerImpl shopController;

    @PostConstruct
    public void init() {
        shopController.enterToShop();
    }

    public void purchase() {
        Random random = new Random();

        int productsNumber = random.nextInt(9) + 2;
        System.out.println("Buyer wants to buy " + productsNumber + " products");
        for (int i = 0; i < productsNumber; i++) {
            shopController.addProductFromCartById(random.nextInt(5));
        }
        shopController.deleteProductFromCartById(random.nextInt(5));
    }

    public void showCart() {
        System.out.println("Buyer bought");
        shopController.showProductsInCart();
        System.out.println("----------------------------------------");
    }


}
