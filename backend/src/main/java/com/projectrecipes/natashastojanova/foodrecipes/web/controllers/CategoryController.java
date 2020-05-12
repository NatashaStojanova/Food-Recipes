package com.projectrecipes.natashastojanova.foodrecipes.web.controllers;

import com.projectrecipes.natashastojanova.foodrecipes.dto.CategoryDTO;
import com.projectrecipes.natashastojanova.foodrecipes.exceptions.CategoryAlreadyExistsException;
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

    //get all categories
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    //show the category with specific ID
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            return category;
        } else
            throw new CategoryNotFoundException();
    }

    //create new category
    @PostMapping
    public Category addNewCategory(CategoryDTO categoryDTO) {
        Optional<Category> category = Optional.of(categoryService.findByName(categoryDTO.getName()).get());
        if (!category.isPresent()) {
            category.get().setName(categoryDTO.getName());
            category.get().setRecipeList(categoryDTO.getRecipeList());
            categoryService.save(category.get());
            return category.get();
        } else
            throw new CategoryAlreadyExistsException();
    }
}
