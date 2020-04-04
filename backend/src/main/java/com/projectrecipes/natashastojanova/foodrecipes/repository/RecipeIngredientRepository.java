package com.projectrecipes.natashastojanova.foodrecipes.repository;

import com.projectrecipes.natashastojanova.foodrecipes.model.Recipe;
import com.projectrecipes.natashastojanova.foodrecipes.model.RecipeIngredient;
import com.projectrecipes.natashastojanova.foodrecipes.model.RecipeIngredientCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author Natasha Stojanova
 */
@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, RecipeIngredientCompositeKey>{

    @Transactional
    @Modifying
    void deleteRecipeIngredientByRecipe(Recipe recipe);

}
