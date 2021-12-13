package ru.gb.gbthymeleaf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.gbthymeleaf.entity.Cart;
import ru.gb.gbthymeleaf.service.CartService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping("/list")
    public String getCartProducts(Model model){
        model.addAttribute("cart", cartService.findByCartNumber(cartService.maxNumber()));
        return "cart";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id, @RequestParam(name = "productId") Long productId) {
        Cart cart = cartService.findById(id);
        if (cart != null){
            cart.getProducts().removeIf(product -> product.getId().equals(productId));
            cartService.saveOrUpdate(cart);
        }

        return "redirect:/cart/list";
    }
}
