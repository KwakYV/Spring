package ru.gb.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.rest.entity.Cart;
import ru.gb.rest.entity.Product;
import ru.gb.rest.service.CartService;
import ru.gb.rest.service.ProductService;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;
    private final CartService cartService;
    private Cart cart;

    @GetMapping
    public List<Product> getProductList() {
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable("productId") Long id){
        Product product;
        if (id != null){
            product = productService.findById(id);
            if (product != null){
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        product.setManufactureDate(LocalDate.now());
        Product savedProduct = productService.save(product);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("/api/v1/product/" +  savedProduct.getId()));
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping("/{productId}/add")
    public ResponseEntity<?> addToCart(@PathVariable("productId") Long id, @RequestBody Product product){
        product.setId(id);
        if (cart == null) {
            List<Product> products = new ArrayList<>();
            products.add(product);
            cart = Cart.builder()
                    .number(cartService.maxNumber() + 1)
                    .products(products)
                    .build();
        } else {
            cart = cartService.findById(cart.getId());
            cart.getProducts().add(product);
        }
        cart = cartService.saveOrUpdate(cart);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("/api/v1/cart/"));
        return new ResponseEntity<>(httpHeaders, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> handleUpdate(@PathVariable("productId") Long id, @RequestBody Product product){
        product.setId(id);
        product.setManufactureDate(LocalDate.now());
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("productId") Long id) {
        productService.deleteById(id);
    }
}
