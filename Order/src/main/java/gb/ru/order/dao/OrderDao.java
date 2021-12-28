package gb.ru.order.dao;

import gb.ru.order.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Order, Long> {
    @Query("select max(o.number) from Order o")
    public Long findMaxNumber();
}
