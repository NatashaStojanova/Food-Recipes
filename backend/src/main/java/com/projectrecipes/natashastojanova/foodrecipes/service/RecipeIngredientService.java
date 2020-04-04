package com.projectrecipes.natashastojanova.foodrecipes.service;

import com.projectrecipes.natashastojanova.foodrecipes.model.Recipe;
import com.projectrecipes.natashastojanova.foodrecipes.model.RecipeIngredient;

import java.util.List;

/**
 * @author Natasha Stojanova
 */
public interface RecipeIngredientService {

    public List<RecipeIngredient> findAll();

    public void save(RecipeIngredient pizzaIngredient);

    public void deleteAllByRecipe(Recipe recipe);

}
