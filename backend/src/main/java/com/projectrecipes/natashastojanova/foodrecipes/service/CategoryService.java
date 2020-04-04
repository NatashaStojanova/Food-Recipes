package com.projectrecipes.natashastojanova.foodrecipes.service;

import com.projectrecipes.natashastojanova.foodrecipes.model.Category;


import java.util.Optional;

/**
 * @author Natasha Stojanova
 */
public interface CategoryService  extends BaseEntityCrudService<Category>{

    public Optional<Category> findByName(String name);

    public Optional<Category> findById(Long id);

}
