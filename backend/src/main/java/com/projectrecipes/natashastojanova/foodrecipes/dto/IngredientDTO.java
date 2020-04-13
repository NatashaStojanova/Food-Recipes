package com.projectrecipes.natashastojanova.foodrecipes.dto;

import com.projectrecipes.natashastojanova.foodrecipes.model.RecipeIngredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Natasha Stojanova
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IngredientDTO {

    private String name;
    private boolean isVeggie;
    private boolean isSpicy;
    private Long id;
    private List<RecipeIngredient> recipeList;

}