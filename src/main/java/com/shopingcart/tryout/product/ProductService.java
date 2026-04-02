package com.shopingcart.tryout.product;

import com.shopingcart.tryout.model.Product;
import com.shopingcart.tryout.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public List<Product> getProductByCategory(Long categoryId) {
        return List.of();
    }

    @Override
    public List<Product> getProductByBrand(String brand) {
        return List.of();
    }

    @Override
    public List<Product> getProductByCategoryAndBrand(String category, String brand) {
        return List.of();
    }

    @Override
    public List<Product> getProductByName(String name) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByBrandAndName(String category, String name) {
        return List.of();
    }

    @Override
    public Long countProductsByBrandAndName(String Brand, String category) {
        return 0L;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(()-> new ProductNotFoundException("Product not found"));
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public void updateProduct(Product product, long id) {

    }
}
