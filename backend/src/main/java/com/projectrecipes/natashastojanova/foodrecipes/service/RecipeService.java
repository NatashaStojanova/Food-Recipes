package com.projectrecipes.natashastojanova.foodrecipes.service;

import com.projectrecipes.natashastojanova.foodrecipes.dto.RecipeDTO;
import com.projectrecipes.natashastojanova.foodrecipes.model.Recipe;

import java.util.List;
import java.util.Optional;

/**
 * @author Natasha Stojanova
 */
public interface RecipeService extends BaseEntityCrudService<Recipe> {

    public Optional<Recipe> findByName(String name);

    public Optional<Recipe> findByRating(Integer rating);

    public boolean existsByName(String name);

    List<Recipe> searchByName(String term);
}
