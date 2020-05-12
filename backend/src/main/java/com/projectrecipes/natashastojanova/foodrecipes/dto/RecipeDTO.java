package com.projectrecipes.natashastojanova.foodrecipes.dto;

import com.projectrecipes.natashastojanova.foodrecipes.model.Category;
import com.projectrecipes.natashastojanova.foodrecipes.model.RecipeIngredient;
import com.projectrecipes.natashastojanova.foodrecipes.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private int rating;


    private Long id;


    private List<User> userList;


    private List<Long> ingredientsList;


    private Long category;


}
