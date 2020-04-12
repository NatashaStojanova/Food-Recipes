package com.projectrecipes.natashastojanova.foodrecipes.web.controllers;

import com.projectrecipes.natashastojanova.foodrecipes.exceptions.CategoryNotFoundException;
import com.projectrecipes.natashastojanova.foodrecipes.model.Category;
import com.projectrecipes.natashastojanova.foodrecipes.service.CategoryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Natasha Stojanova
 */

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            return category;
        } else
            throw new CategoryNotFoundException();

    }

}
