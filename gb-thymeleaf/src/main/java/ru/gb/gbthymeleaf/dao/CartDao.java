package ru.gb.gbthymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.gbthymeleaf.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Long> {
    @Query("select max(c.number) from Cart c")
    public Long maxNumber();
}
