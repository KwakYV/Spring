package ru.gb.gbthymeleaf.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.gbthymeleaf.dao.CartDao;
import ru.gb.gbthymeleaf.entity.Cart;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {
    private final CartDao cartDao;

    public Cart saveOrUpdate(Cart cart){
        if (cart.getId() != null){
            Optional<Cart> cartOptional = cartDao.findById(cart.getId());
            if (cartOptional.isPresent()){
                Cart cartFromDb = cartOptional.get();
                cartFromDb.setProducts(cart.getProducts());
                cartDao.save(cartFromDb);
            }
        }
        return cartDao.save(cart);
    }

    public Long maxNumber(){
        return (cartDao.maxNumber() == null) ? 0 : cartDao.maxNumber();
    }
    public Cart findByCartNumber(Long number){
        return cartDao.findByNumber(number);
    }

    public Cart findById(Long id){
        return cartDao.findById(id).orElse(null);
    }
}
