package com.shopingcart.tryout.product;

import com.shopingcart.tryout.model.Product;

import java.util.List;

public interface IProductService {
    Product addProduct(Product product);

    Product getProductById(Long id);
    void deleteProduct(Long id);
    void updateProduct(Product product, long id);
    List<Product> getAllProducts();
    List<Product> getProductByCategory(Long categoryId);
    List<Product> getProductByBrand(String brand);
    List<Product> getProductByCategoryAndBrand(String category,String brand);
    List<Product> getProductByName(String name);
    List<Product> getProductsByBrandAndName(String category, String name);
    Long countProductsByBrandAndName(String Brand, String category);
}
