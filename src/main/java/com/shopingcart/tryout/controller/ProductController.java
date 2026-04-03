package com.shopingcart.tryout.controller;

import com.shopingcart.tryout.exceptions.AlreadyExistsException;
import com.shopingcart.tryout.exceptions.ProductNotFoundException;
import com.shopingcart.tryout.exceptions.ResourceNotFoundException;
import com.shopingcart.tryout.model.Product;
import com.shopingcart.tryout.repository.ProductRepository;
import com.shopingcart.tryout.request.AddProductRequest;
import com.shopingcart.tryout.request.ProductUpdateRequest;
import com.shopingcart.tryout.response.ApiResponse;
import com.shopingcart.tryout.service.ProductSerice.IProductService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/products")
public class ProductController {
    private final IProductService productService;


    @GetMapping("/all}")
    public ResponseEntity<ApiResponse> getAllPRoducts() {
        try {
            List<Product> products = productService.getAllProducts();
            return ResponseEntity.ok(new ApiResponse("Success", products));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }
    @GetMapping("/products/{productId}/product")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long productId){
        try{
            Product product = productService.getProductById(productId);
            return ResponseEntity.ok(new ApiResponse("Success", product));
        }catch(ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }
    @GetMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody AddProductRequest product){
        try {
            Product theProduct = productService.addProduct(product);
            return ResponseEntity.ok(new ApiResponse("Success", product));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }
    @PutMapping("/product/{productId}/update")
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody ProductUpdateRequest request,@PathVariable Long productId){
        try {
            Product theproduct = productService.updateProduct(request, productId);
            return ResponseEntity.ok(new ApiResponse("Product was updated", theproduct));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/product/{productId}/delete")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId){
        try {
            productService.deleteProduct(productId);
            return ResponseEntity.ok(new ApiResponse("Product was deleted Successfully", null));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/products/by/brand-and-name")
    public ResponseEntity<ApiResponse> getProductByBrandAndName(@RequestParam String brandName, @RequestParam String productName){
        try {
            List <Product> products= productService.getProductsByBrandAndName(brandName, productName);
            if(products.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No products were found", null));
            }
            return ResponseEntity.ok(new ApiResponse("There were matches", products));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/products/by/category-and-brand")
    public ResponseEntity<ApiResponse> getProductByCategoruAndName(@RequestParam String categoryName, @RequestParam String brandName){
        try {
            List <Product> products= productService.getProductByCategoryAndBrand(categoryName, brandName);
            if(products.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No products were found", null));
            }
            return ResponseEntity.ok(new ApiResponse("There were matches", products));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/products/by/brand-and-category")
    public ResponseEntity<ApiResponse> getProductByBrand(@RequestParam String brandName){
        try {
            List <Product> products= productService.getProductByBrand(brandName);
            if(products.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No products were found", null));
            }
            return ResponseEntity.ok(new ApiResponse("There were matches", products));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/products/by/brand-and-category")
    public ResponseEntity<ApiResponse> getProductByCategory(@RequestParam    String categoryName){
        try {
            List <Product> products= productService.getProductByCategory(categoryName);
            if(products.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No products were found", null));
            }
            return ResponseEntity.ok(new ApiResponse("There were matches", products));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

}
