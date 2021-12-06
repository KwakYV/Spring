package ru.gb.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.gb.dao.CustomerDao;
import ru.gb.entity.Customer;

import javax.persistence.TypedQuery;

@Repository
@AllArgsConstructor
public class CustomerService {
    private final CustomerDao customerDao;

    public Customer getCustomerById(Long id) {
        return customerDao.getCustomerById(id);
    }
}
