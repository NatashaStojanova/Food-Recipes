package com.projectrecipes.natashastojanova.foodrecipes.service;

import com.projectrecipes.natashastojanova.foodrecipes.model.Ingredient;
import com.projectrecipes.natashastojanova.foodrecipes.model.Recipe;

import java.util.Optional;

/**
 * @author Natasha Stojanova
 */
public interface IngredientService extends BaseEntityCrudService<Ingredient> {


    public Optional<Ingredient> findByName(String name);

    public Optional<Ingredient> findById(Long id);

}
