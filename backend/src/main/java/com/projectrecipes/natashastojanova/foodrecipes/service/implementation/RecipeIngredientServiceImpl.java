package com.projectrecipes.natashastojanova.foodrecipes.service.implementation;

import com.projectrecipes.natashastojanova.foodrecipes.model.Recipe;
import com.projectrecipes.natashastojanova.foodrecipes.model.RecipeIngredient;
import com.projectrecipes.natashastojanova.foodrecipes.repository.RecipeIngredientRepository;
import com.projectrecipes.natashastojanova.foodrecipes.repository.RecipeRepository;
import com.projectrecipes.natashastojanova.foodrecipes.service.RecipeIngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Natasha Stojanova
 */
@Service
public class RecipeIngredientServiceImpl extends BaseEntityCrudServiceImpl<RecipeIngredient, RecipeIngredientRepository> implements RecipeIngredientService {
    private RecipeIngredientRepository recipeIngredientRepository;


    @Override
    protected RecipeIngredientRepository getRepository() {
        return recipeIngredientRepository;
    }
}
