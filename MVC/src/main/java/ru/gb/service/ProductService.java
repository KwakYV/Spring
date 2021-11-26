package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import ru.gb.entity.Product;
import ru.gb.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product edit(Product product){
        return productRepository.edit(product);
    }

    public Product findById(int id){
        return productRepository.findById(id).orElse(new Product());
    }

    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    public long count() {
        return productRepository.count();
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    public Product getRandomProduct() {
        Random rand = new Random();
        return getProductProvider().getProduct(rand.nextInt(6));
    }

    @Lookup
    public ProductProvider getProductProvider(){
        return null;
    }
}
