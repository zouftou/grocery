package com.zouftou.grocery.repository;

import com.zouftou.grocery.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
