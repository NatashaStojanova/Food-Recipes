package com.projectrecipes.natashastojanova.foodrecipes.web.controllers;

import com.projectrecipes.natashastojanova.foodrecipes.dto.RecipeDTO;
import com.projectrecipes.natashastojanova.foodrecipes.exceptions.RecipeAlreadyExistsException;
import com.projectrecipes.natashastojanova.foodrecipes.exceptions.RecipeNotFoundException;
import com.projectrecipes.natashastojanova.foodrecipes.model.Category;
import com.projectrecipes.natashastojanova.foodrecipes.model.Recipe;
import com.projectrecipes.natashastojanova.foodrecipes.service.CategoryService;
import com.projectrecipes.natashastojanova.foodrecipes.service.IngredientService;
import com.projectrecipes.natashastojanova.foodrecipes.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Natasha Stojanova
 */

@RestController
@RequestMapping("/recipes")
@CrossOrigin("*")
public class RecipeController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final CategoryService categoryService;

    public RecipeController(RecipeService recipeService,
                            IngredientService ingredientService,
                            CategoryService categoryService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }


    //create new Recipe
    @PostMapping
    public Recipe addNewRecipe(RecipeDTO recipeDTO) {
        Optional<Recipe> recipe = Optional.of(recipeService.findByName(recipeDTO.getName()).get());
        if (!recipe.isPresent()) {
            recipe.get().setName(recipeDTO.getName());
            recipe.get().setTime(recipeDTO.getTime());
            recipe.get().setRating(recipeDTO.getRating());
            recipe.get().setIngredientList(recipeDTO.getIngredientList());
            recipe.get().setCategory(recipeDTO.getCategory());
            recipe.get().setDescription(recipeDTO.getDescription());
            recipe.get().setUserList(recipeDTO.getUserList());
            recipeService.save(recipe.get());
            return recipe.get();
        } else
            throw new RecipeAlreadyExistsException();
    }

    //give me the pizza with specific ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Recipe getRecipe(@PathVariable("id") Long id) {
        Recipe recipe;
        if (recipeService.findOne(id).isPresent()) {
            recipe = recipeService.findOne(id).get();
        } else
            throw new RecipeNotFoundException();

        return recipe;
    }

    //give me the pizza with specific ID
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Recipe editRecipe(@PathVariable("id") Long id, RecipeDTO recipeDTO) {
        Recipe recipe;
        if (recipeService.findOne(id).isPresent()) {
            recipe = recipeService.findOne(id).get();
            recipe.setName(recipeDTO.getName());
            recipe.setDescription(recipeDTO.getDescription());
            recipe.setRating(recipeDTO.getRating());
            recipe.setCategory(recipeDTO.getCategory());
            recipe.setTime(recipeDTO.getTime());
            recipe.setIngredientList(recipeDTO.getIngredientList());
            recipeService.save(recipe);
        } else
            throw new RecipeNotFoundException();
        return recipe;
    }
}


