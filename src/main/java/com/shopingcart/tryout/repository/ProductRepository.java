package com.shopingcart.tryout.repository;

import com.shopingcart.tryout.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
