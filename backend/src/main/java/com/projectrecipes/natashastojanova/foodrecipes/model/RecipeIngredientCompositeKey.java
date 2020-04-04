package com.projectrecipes.natashastojanova.foodrecipes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Natasha Stojanova
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class RecipeIngredientCompositeKey implements Serializable {

    @Column(name = "recipe_id")
    Long recipe_id;

    @Column(name = "ingredient_id")
    Long ingredient_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredientCompositeKey that = (RecipeIngredientCompositeKey) o;
        return recipe_id.equals(that.recipe_id) &&
                ingredient_id.equals(that.ingredient_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe_id, ingredient_id);
    }


}
