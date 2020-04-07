package com.projectrecipes.natashastojanova.foodrecipes.web.controllers;

import com.projectrecipes.natashastojanova.foodrecipes.model.Ingredient;
import com.projectrecipes.natashastojanova.foodrecipes.service.IngredientService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Natasha Stojanova
 */

@RestController
@RequestMapping("/ingredients")
@CrossOrigin("*")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }


    @GetMapping
    public List<Ingredient> showIngredients() {

        List ingredients = new ArrayList<>();
        ingredientService.findAll().forEach(ingredient -> {
            ingredients.add(ingredient);
        });

        return ingredients;
    }

}
