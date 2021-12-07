package ru.gb.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.gb.dao.CustomerDao;
import ru.gb.entity.Customer;

import javax.persistence.TypedQuery;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerDao customerDao;

    public Customer getCustomerById(Long id) {
        return customerDao.findById(id).orElse(null);
    }
}
