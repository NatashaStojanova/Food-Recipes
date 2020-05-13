package com.projectrecipes.natashastojanova.foodrecipes.service.implementation;

import com.projectrecipes.natashastojanova.foodrecipes.model.RecipeIngredient;
import com.projectrecipes.natashastojanova.foodrecipes.repository.RecipeIngredientRepository;
import com.projectrecipes.natashastojanova.foodrecipes.service.RecipeIngredientService;
import org.springframework.stereotype.Service;

/**
 * @author Natasha Stojanova
 */
@Service
public class RecipeIngredientServiceImpl extends BaseEntityCrudServiceImpl<RecipeIngredient, RecipeIngredientRepository> implements RecipeIngredientService {
    private RecipeIngredientRepository recipeIngredientRepository;

    public RecipeIngredientServiceImpl(RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
    }


    @Override
    protected RecipeIngredientRepository getRepository() {
        return recipeIngredientRepository;
    }
}
