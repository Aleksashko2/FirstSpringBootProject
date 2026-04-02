package com.shopingcart.tryout.repository;

import com.shopingcart.tryout.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findById(Long id);
}
