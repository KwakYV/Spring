package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class JpaCustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Customer getCustomerById(Long id) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c left join fetch  c.orders where c.id = :id", Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
