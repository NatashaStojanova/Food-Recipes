package com.projectrecipes.natashastojanova.foodrecipes.dto;

import com.projectrecipes.natashastojanova.foodrecipes.model.Category;
import com.projectrecipes.natashastojanova.foodrecipes.model.Ingredient;
import com.projectrecipes.natashastojanova.foodrecipes.model.RecipeIngredient;
import com.projectrecipes.natashastojanova.foodrecipes.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author Natasha Stojanova
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeDTO {

    private String name;

    private String description;

    private float time;

    private MultipartFile image;

    private int rating;

    private Long id;

    // TODO: Remove username
    private String username;

    private User user;

    private String ingredientsList;

    private String imageURL;

    private List<Ingredient> ingredients;

    private Category recipeCategory;

    private Long category;


}
