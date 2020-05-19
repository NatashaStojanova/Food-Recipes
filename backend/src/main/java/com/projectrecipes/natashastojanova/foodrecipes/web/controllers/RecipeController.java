package com.projectrecipes.natashastojanova.foodrecipes.web.controllers;

import com.projectrecipes.natashastojanova.foodrecipes.dto.RecipeDTO;
import com.projectrecipes.natashastojanova.foodrecipes.exceptions.RecipeAlreadyExistsException;
import com.projectrecipes.natashastojanova.foodrecipes.exceptions.RecipeNotFoundException;
import com.projectrecipes.natashastojanova.foodrecipes.model.Category;
import com.projectrecipes.natashastojanova.foodrecipes.model.Ingredient;
import com.projectrecipes.natashastojanova.foodrecipes.model.Recipe;
import com.projectrecipes.natashastojanova.foodrecipes.model.RecipeIngredient;
import com.projectrecipes.natashastojanova.foodrecipes.service.CategoryService;
import com.projectrecipes.natashastojanova.foodrecipes.service.IngredientService;
import com.projectrecipes.natashastojanova.foodrecipes.service.RecipeIngredientService;
import com.projectrecipes.natashastojanova.foodrecipes.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    private final RecipeIngredientService recipeIngredientService;

    public RecipeController(RecipeService recipeService,
                            IngredientService ingredientService,
                            CategoryService categoryService,
                            RecipeIngredientService recipeIngredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.categoryService = categoryService;
        this.recipeIngredientService = recipeIngredientService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }


    //create new Recipe
    @PostMapping
    public Recipe addNewRecipe(@Valid @RequestBody RecipeDTO recipeDTO) {
        if (recipeService.existsByName(recipeDTO.getName()))
            throw new RecipeAlreadyExistsException();

        Recipe newRecipe = new Recipe();
        newRecipe.setName(recipeDTO.getName());
        newRecipe.setDescription(recipeDTO.getDescription());
        newRecipe.setTime(recipeDTO.getTime());
        Optional<Category> category = categoryService.findById(recipeDTO.getCategory());
        newRecipe.setCategory(category.get());
        recipeService.save(newRecipe);

        recipeDTO.getIngredientsList().forEach(ingID -> {
            Optional<Ingredient> ing = ingredientService.findOne(ingID);
            if (ing.isPresent()) {
                RecipeIngredient recipeIngredient = new RecipeIngredient();
                recipeIngredient.setIngredient(ing.get());
                recipeIngredient.setRecipe(newRecipe);
                recipeIngredientService.save(recipeIngredient);
            }
        });
        return newRecipe;
    }

    //give me the recipe with specific ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RecipeDTO getRecipe(@PathVariable("id") Long id) {
        Recipe recipe;
        RecipeDTO recipeDTO = new RecipeDTO();
        if (recipeService.findOne(id).isPresent()) {
            recipe = recipeService.findOne(id).get();
            List<Ingredient> list = new ArrayList<>();
            recipe.getIngredientList().stream().forEach(item -> {
                list.add(item.getIngredient());
            });
            recipeDTO.setIngredients(list);
            recipeDTO.setName(recipe.getName());
            recipeDTO.setTime(recipe.getTime());
            recipeDTO.setDescription(recipe.getDescription());
        } else
            throw new RecipeNotFoundException();

        return recipeDTO;
    }

    /*//give me the pizza with specific ID
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
*/
    //give me all recipes that contain this ingredients
    @GetMapping("/comboIngredients")
    public List<Recipe> comboIngredients(List<Long> list_ID) {
        list_ID.add((long) 1);
        list_ID.add((long) 2);
        list_ID.add((long) 3);

        List<Recipe> recipeList = new ArrayList<>();
        recipeService.findAll().forEach(recipe -> {
            List<Long> ing_ID = new ArrayList<>();
            recipeService.findOne(recipe.getId()).get().getIngredientList().forEach(ingredient -> {
                ing_ID.add(ingredient.getId());
            });
            if (ing_ID.containsAll(list_ID)) {
                recipeList.add(recipe);
            }
        });
        return recipeList;
    }
}


