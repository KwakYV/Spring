package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.DbConfig;
import ru.gb.config.HibernateConfig;
import ru.gb.dao.JdbcProductDaoImpl;
import ru.gb.dao.ManufacturerDao;
import ru.gb.dao.OldJdbcManufacturerDao;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

public class ShopApp {



    public static void main(String[] args) {

        /**
         * Native Jdbc connetion usage
         */
//        JdbcProductDaoImpl jdbcProductDao = new JdbcProductDaoImpl();
//        jdbcProductDao.findAll().forEach(product -> System.out.println(product));
//
//        System.out.println("Find product by Id - " + jdbcProductDao.findById(3L));
//        System.out.println("Find Titlde of product by Id - " + jdbcProductDao.findTitleById(3L));


        /**
         * Spring Jdbc
         * Jdbc template
         * Named Jdbc template
         * Для естирования нужно включать нужный бин и выключать, который не используется.
         */
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
//        ProductDao productDao = context.getBean(ProductDao.class);
//        System.out.println(productDao.findTitleById(3L));
//        System.out.println("-----------------------");
//        System.out.println(productDao.findById(3L));
//        System.out.println("-----------------------");
//        for (Product product : productDao.findAll()) {
//            System.out.println(product);
//        }

        /**
         * Hibernate usage
         *
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        System.out.println(productDao.findTitleById(3L));
        System.out.println("-----------------------");
        System.out.println(productDao.findById(3L));
        System.out.println("-----------------------");
        for (Product product : productDao.findAll()) {
            System.out.println(product);
        }

    }
}
