package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.JpaConfig;
import ru.gb.dao.CustomerDao;
import ru.gb.dao.OrderDao;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Customer;
import ru.gb.entity.Order;
import ru.gb.entity.Product;
import ru.gb.service.CustomerService;
import ru.gb.service.OrderService;
import ru.gb.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class HomeWork6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        ProductService productService = context.getBean(ProductService.class);
        CustomerService customerService = context.getBean(CustomerService.class);

        Customer customer = customerService.getCustomerById(5L);
        List<Product> listOfProduct = (List<Product>) productService.findAll();
        Long orderNumber = orderService.maxNumber();
        for (int i = 1; i <= 3; i++) {
            orderService.save(Order.builder()
                    .customer(customer)
                    .products(listOfProduct.subList(i+3, i+10))
                    .number((long) i + orderNumber)
                    .build());
        }

        customer = customerService.getCustomerById(5L);
        System.out.println("********** Customer - " + customer.getName() + " ****************");
        for (Order order : customer.getOrders()) {
            System.out.println("===================== Order number - " + order.getNumber());
            order.getProducts().stream().forEach(product -> {
                System.out.println(product.getTitle());
            });
        }
    }
}
