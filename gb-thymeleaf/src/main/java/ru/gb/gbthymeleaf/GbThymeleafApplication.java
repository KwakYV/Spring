package ru.gb.gbthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GbThymeleafApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GbThymeleafApplication.class, args);
    }

}
