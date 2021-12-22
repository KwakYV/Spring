package ru.gb.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.rest.entity.Cart;
import ru.gb.rest.entity.Product;
import ru.gb.rest.service.CartService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<Product> getCartProducts(){
        return cartService.findByCartNumber(cartService.maxNumber()).getProducts();
    }


    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("productId") Long id) {
        Cart cart = cartService.findByCartNumber(cartService.maxNumber());
        if (cart != null){
            cart.getProducts().removeIf(product -> product.getId().equals(id));
            cartService.saveOrUpdate(cart);
        }
    }
}
