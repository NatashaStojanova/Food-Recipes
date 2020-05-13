package com.projectrecipes.natashastojanova.foodrecipes.service.implementation;

import com.projectrecipes.natashastojanova.foodrecipes.model.Recipe;
import com.projectrecipes.natashastojanova.foodrecipes.repository.RecipeRepository;
import com.projectrecipes.natashastojanova.foodrecipes.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Natasha Stojanova
 */
@Service
public class RecipeServiceImpl extends BaseEntityCrudServiceImpl<Recipe, RecipeRepository> implements RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository){
        this.recipeRepository=recipeRepository;
    }

    @Override
    protected RecipeRepository getRepository() {
        return recipeRepository;
    }

    @Override
    public Optional<Recipe> findByName(String name) {
        return recipeRepository.findByName(name);
    }

    @Override
    public Optional<Recipe> findByRating(Integer rating) {
        return recipeRepository.findByRating(rating);
    }

    @Override
    public boolean existsByName(String name) {
        return getRepository().existsByName(name);
    }
}
