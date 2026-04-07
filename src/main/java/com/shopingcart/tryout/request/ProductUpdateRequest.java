package com.shopingcart.tryout.request;

import com.shopingcart.tryout.model.Category;
import com.shopingcart.tryout.model.Image;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class ProductUpdateRequest {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;
    private List<Image> images;
}
