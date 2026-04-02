package com.shopingcart.tryout.product;

import com.shopingcart.tryout.model.Category;
import com.shopingcart.tryout.model.Product;
import com.shopingcart.tryout.request.AddProductRequest;

import java.util.List;

public interface IProductService {
    Product createProduct(AddProductRequest product, Category category);
    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    void deleteProduct(Long id);
    void updateProduct(Product product, long id);
    List<Product> getAllProducts();
    List<Product> getProductByCategory(String category);
    List<Product> getProductByBrand(String brand);
    List<Product> getProductByCategoryAndBrand(String category,String brand);
    List<Product> getProductByName(String name);
    List<Product> getProductsByBrandAndName(String category, String name);
    Long countProductsByBrandAndName(String Brand, String category);
}
