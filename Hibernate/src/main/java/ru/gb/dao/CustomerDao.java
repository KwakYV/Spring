package ru.gb.dao;

import ru.gb.entity.Customer;

public interface CustomerDao {
    public Customer getCustomerById(Long id);
}
