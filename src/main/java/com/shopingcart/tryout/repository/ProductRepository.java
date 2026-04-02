package com.shopingcart.tryout.repository;

import com.shopingcart.tryout.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    static List<Product> finddByName(String name) {
    }

    static List<Product> findByBrandAndName(String brand, String name) {
    }

    List<Product> findByCategoryByName(String category);

    List<Product> findByBrand(String brand);

    List<Product> findByCategoryAndBrand(String category, String brand);

    Long countProductByBrandAndName(String brand, String name);
}
