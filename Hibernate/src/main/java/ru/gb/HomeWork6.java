package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeWork6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        ProductService productService = context.getBean(ProductService.class);
        CustomerService customerService = context.getBean(CustomerService.class);

        System.out.println(productService.findById(1L).getTitle());
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
        Map<Long, List<Product>> map = new HashMap<>();
        for (Order order : customer.getOrders()) {
            map.put(order.getNumber(), productService.findAllByOrderDesc(order));
        }
        System.out.println("********** Customer - " + customer.getName() + " ****************");
        for (Long aLong : map.keySet()) {
            System.out.println("===================== Order number - " + aLong);
            map.get(aLong).stream().forEach(product -> {
                System.out.println(String.format("%s === %s", product.getTitle(), product.getCost().toString()));
            });
            Double sum = map.get(aLong).stream().map(product -> product.getCost().doubleValue()).reduce(0.0, (first, second) -> {
                double v = first + second;
                return v;
            });
            System.out.println("---------Total cost of order - " + sum);

        }
    }
}
