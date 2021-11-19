package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.beans.Cart;
import ru.gb.config.Config;
import ru.gb.entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("=================Cart management==========================");
        System.out.println("1 - Create new cart");
        System.out.println("2 - Add product to cart");
        System.out.println("3 - Remove product from cart");
        System.out.println("4 - Add all grocery to cart");
        System.out.println("5 - Exit from cart management system");
        System.out.println("Please enter your choice");
        Scanner scanner = new Scanner(System.in);
        int a;
        int count_carts = 0;
        Cart current = null;
        List<Cart> cartList = new ArrayList<>();
        while ((a= scanner.nextInt()) != 5) {
            switch (a){
                case(1): {
                    if (count_carts == 0){
                        current = context.getBean("cart", Cart.class);
                        count_carts++;
                    } else {
                        cartList.add(current);
                        current = context.getBean("cart", Cart.class);
                    }
                    break;
                }
                case(2):{
                    if(count_carts == 0){
                        System.out.println("Before processing with products add cart");
                        break;
                    }
                    System.out.println("Select product id from 0 to 20");
                    int id;
                    while ((id = scanner.nextInt())!=999){
                        if (id > 20 || id < 0){
                            System.out.println("Wrong number, please select correct id or type 999 to exit");
                            continue;
                        }
                        current.add(current.getProductRepository().getProduct(id));
                    }
                    System.out.println("Adding product by id has finished");
                    break;
                }
                case(3):{
                    if(count_carts == 0){
                        System.out.println("Before processing with products add cart");
                        break;
                    }
                    int id;
                    List<Integer> ids = current.getProductList()
                            .stream()
                            .map((product)->{
                                return product.getId();
                            }).collect(Collectors.toList());
                    System.out.println("Select id of product to delete from current cart - " + Arrays.toString(ids.toArray()));
                    while ((id = scanner.nextInt())!=999){
                        if (!ids.contains(id)){
                            System.out.println("Select id from given list or type 999 to exit from deletion");
                            continue;
                        }

                        ids.remove(ids.indexOf(id));
                        current.remove(id);
                        System.out.println("Select next id to delete from cart - " + Arrays.toString(ids.toArray()));
                        System.out.println("Or press 999 to exit from deletion");
                    }
                    System.out.println("Exiting from deletion");
                    break;
                }
                case(4):{
                    if(count_carts == 0){
                        System.out.println("Before processing with products add cart");
                        break;
                    }
                    for (Product product : current.getProductRepository().getProducts()) {
                        current.getProductList().add(product);
                    }
                    break;
                }
                default:
                    System.out.println("Wrong operation");
            }
        }

        cartList.add(current);
        cartList.forEach((cart)->{
            for (Product product : cart.getProductList()) {
                System.out.println(cart + "----> " + product.getId() + " - " + product.getName());
            }
        });

    }
}
