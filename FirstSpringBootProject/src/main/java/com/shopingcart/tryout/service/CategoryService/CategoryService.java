package com.shopingcart.tryout.service.CategoryService;

import com.shopingcart.tryout.exceptions.CategoryNotFoundException;
import com.shopingcart.tryout.exceptions.ProductNotFoundException;
import com.shopingcart.tryout.model.Category;
import com.shopingcart.tryout.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;


    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() ->new CategoryNotFoundException("Category was not found"));
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return Optional.of(category)
                .filter(c -> !categoryRepository.existsByName(c.getName()))
                .map(categoryRepository :: save)
                .orElseThrow(() -> new ProductNotFoundException(category.getName() + "already exists"));
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return Optional.ofNullable(getCategoryById(id)).map(oldCategory -> {
            oldCategory.setName(category.getName());
            return categoryRepository.save(oldCategory);
        }).orElseThrow(() -> new CategoryNotFoundException("Category does not exist in our DB"));
    }
    @Override
    public void deleteCategory(Long id) {
        categoryRepository.findById(id)
                .ifPresentOrElse(categoryRepository :: delete
                        ,() -> {throw new CategoryNotFoundException("Category does not exist in the DB");});
    }
}
