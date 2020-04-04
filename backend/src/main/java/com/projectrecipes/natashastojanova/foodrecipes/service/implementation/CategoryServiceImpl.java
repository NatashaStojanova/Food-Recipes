package com.projectrecipes.natashastojanova.foodrecipes.service.implementation;

import com.projectrecipes.natashastojanova.foodrecipes.model.Category;
import com.projectrecipes.natashastojanova.foodrecipes.repository.CategoryRepository;
import com.projectrecipes.natashastojanova.foodrecipes.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Natasha Stojanova
 */
@Service
public class CategoryServiceImpl extends BaseEntityCrudServiceImpl<Category, CategoryRepository> implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    @Override
    protected CategoryRepository getRepository() {
        return categoryRepository;
    }

    @Override
    public Optional<Category> findById(Long id){return categoryRepository.findById(id);}

    @Override
    public Optional<Category> findByName(String name){return categoryRepository.findByName(name);}

}
