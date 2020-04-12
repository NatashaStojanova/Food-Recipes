package com.projectrecipes.natashastojanova.foodrecipes.web.controllers;

import com.projectrecipes.natashastojanova.foodrecipes.exceptions.RecipeNotFoundException;
import com.projectrecipes.natashastojanova.foodrecipes.model.Category;
import com.projectrecipes.natashastojanova.foodrecipes.model.Recipe;
import com.projectrecipes.natashastojanova.foodrecipes.service.CategoryService;
import com.projectrecipes.natashastojanova.foodrecipes.service.IngredientService;
import com.projectrecipes.natashastojanova.foodrecipes.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        List<Recipe> recipes = new ArrayList<>();
        recipeService.findAll().forEach(recipe -> {
            recipes.add(recipe);
        });

        return recipes;
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
    public Recipe editRecipe(@PathVariable("id") Long id, Recipe recipeDTO) {
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
