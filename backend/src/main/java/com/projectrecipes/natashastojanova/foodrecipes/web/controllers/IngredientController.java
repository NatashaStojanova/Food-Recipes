package com.projectrecipes.natashastojanova.foodrecipes.web.controllers;

import com.projectrecipes.natashastojanova.foodrecipes.dto.IngredientDTO;
import com.projectrecipes.natashastojanova.foodrecipes.exceptions.IngredientAlreadyExistsException;
import com.projectrecipes.natashastojanova.foodrecipes.exceptions.IngredientNotFoundException;
import com.projectrecipes.natashastojanova.foodrecipes.model.Ingredient;
import com.projectrecipes.natashastojanova.foodrecipes.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Natasha Stojanova
 */

@RestController
@RequestMapping("/ingredients")
@CrossOrigin("*")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.findAll();
    }

    //create new ingredient
    @PostMapping
    public Ingredient addNewIngredient(IngredientDTO ingredientDTO) {
        Optional<Ingredient> ingredient = Optional.of(ingredientService.findByName(ingredientDTO.getName()).get());
        if (!ingredient.isPresent()) {
            ingredient.get().setName(ingredientDTO.getName());
            ingredient.get().setSpicy(ingredientDTO.isSpicy());
            ingredient.get().setVeggie(ingredientDTO.isVeggie());
            ingredient.get().setRecipeList(ingredientDTO.getRecipeList());
            ingredientService.save(ingredient.get());
            return ingredient.get();
        } else
            throw new IngredientAlreadyExistsException();
    }

    @GetMapping("/{id}")
    public Optional<Ingredient> getIngredient(@PathVariable("id") Long id) {
        Optional<Ingredient> ingredient = ingredientService.findOne(id);
        if (ingredient.isPresent()) {
            return ingredient;
        } else
            throw new IngredientNotFoundException();
    }

    //edit ingredients
    @PatchMapping("/{id}")
    public Ingredient editIngredient(@PathVariable("id") Long id, IngredientDTO ingredientDTO) {
        Optional<Ingredient> ingredient = Optional.of(ingredientService.findOne(ingredientDTO.getId()).get());
        if (ingredient.isPresent()) {
            ingredient.get().setName(ingredientDTO.getName());
            ingredient.get().setSpicy(ingredientDTO.isSpicy());
            ingredient.get().setVeggie(ingredientDTO.isVeggie());
            ingredient.get().setRecipeList(ingredientDTO.getRecipeList());
            ingredientService.save(ingredient.get());
            return ingredient.get();
        } else
            throw new IngredientNotFoundException();
    }

    //show spicy ingredients
    @GetMapping("/spicyIngredients")
    public List<Ingredient> getSpicyIngredients() {
        List ingredients = new ArrayList();
        ingredientService.findAll().forEach(ingredient -> {
            if (ingredient.isSpicy())
                ingredients.add(ingredient);
        });
        return ingredients;
    }

    //show veggie ingredients
    @GetMapping("/veggieIngredients")
    public List<Ingredient> getVeggieIngredients() {
        List ingredients = new ArrayList();
        ingredientService.findAll().forEach(ingredient -> {
            if (ingredient.isVeggie())
                ingredients.add(ingredient);
        });
        return ingredients;
    }

    //show spicy and veggie ingredients
    @GetMapping("spicy&veggieIngredients")
    public List<Ingredient> getSpicyAndVeggieIngredients() {
        List ingredients = new ArrayList();
        ingredientService.findAll().forEach(ingredient -> {
            if (ingredient.isVeggie() && ingredient.isSpicy())
                ingredients.add(ingredient);
        });
        return ingredients;
    }


}

