package com.projectrecipes.natashastojanova.foodrecipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Natasha Stojanova
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredient {

    @EmbeddedId
    RecipeIngredientCompositeKey id;

    private float amount;

    @JsonIgnore
    @ManyToOne
    @MapsId("recipe_id")
    @JoinColumn(name = "recipe_id")
    Recipe recipe;

    @JsonIgnore
    @ManyToOne
    @MapsId("ingredient_id")
    @JoinColumn(name = "ingredient_id")
    Ingredient ingredient;

}
