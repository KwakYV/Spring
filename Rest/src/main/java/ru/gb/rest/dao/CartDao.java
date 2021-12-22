package ru.gb.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.rest.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Long> {
    @Query("select max(c.number) from Cart c")
    public Long maxNumber();
    public Cart findByNumber(Long number);
}
