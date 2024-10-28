package com.zouftou.grocery.repository;

import com.zouftou.grocery.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
