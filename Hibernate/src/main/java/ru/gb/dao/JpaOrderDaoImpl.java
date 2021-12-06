package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class JpaOrderDaoImpl implements OrderDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> findOrdersByCustomer(Long customerId) {
        String sql = "select o from Order o where o.customer.id = :customer_id";
        return entityManager.createQuery(sql, Order.class)
                .setParameter("customer_id", customerId)
                .getResultList();
    }

    @Override
    public Order save(Order order) {
        if (order.getId() == null){
            entityManager.persist(order);
        } else {
            entityManager.merge(order);
        }
        return order;
    }

    @Override
    public Long maxNumber() {
        String sql = "select max(o.number) from Order o";
        return entityManager.createQuery(sql, Long.class).getSingleResult();
    }
}
