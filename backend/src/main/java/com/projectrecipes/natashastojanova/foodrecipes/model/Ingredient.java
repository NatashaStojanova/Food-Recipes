package com.projectrecipes.natashastojanova.foodrecipes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Natasha Stojanova
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ingredient {

    private String name;
    private boolean isVeggie;
    private boolean isSpicy;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "ingredient")
    private List<RecipeIngredient> recipeList;

}
