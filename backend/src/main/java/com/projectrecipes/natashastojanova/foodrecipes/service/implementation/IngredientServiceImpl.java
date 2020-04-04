package com.projectrecipes.natashastojanova.foodrecipes.service.implementation;

import com.projectrecipes.natashastojanova.foodrecipes.model.Category;
import com.projectrecipes.natashastojanova.foodrecipes.model.Ingredient;
import com.projectrecipes.natashastojanova.foodrecipes.repository.IngredientRepository;
import com.projectrecipes.natashastojanova.foodrecipes.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Natasha Stojanova
 */
@Service
public class IngredientServiceImpl extends BaseEntityCrudServiceImpl<Ingredient, IngredientRepository> implements IngredientService {
    private IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository){
        this.ingredientRepository=ingredientRepository;
    }

    @Override
    protected IngredientRepository getRepository(){
        return ingredientRepository;
    }

    @Override
    public Optional<Ingredient> findById(Long id){return ingredientRepository.findById(id);}

    @Override
    public Optional<Ingredient> findByName(String name){return ingredientRepository.findByName(name);}
}
