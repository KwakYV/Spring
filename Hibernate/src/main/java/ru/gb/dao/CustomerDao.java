package ru.gb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {
}
