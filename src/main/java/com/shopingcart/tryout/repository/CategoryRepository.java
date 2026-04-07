package com.shopingcart.tryout.repository;

import com.shopingcart.tryout.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    // List<Category> findByCategoryByName(String name);

    boolean existsByName(String name);
}
