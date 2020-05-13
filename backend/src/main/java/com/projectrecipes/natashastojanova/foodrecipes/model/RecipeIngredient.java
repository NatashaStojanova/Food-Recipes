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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private float amount;

    @JsonIgnore
    @ManyToOne
    Recipe recipe;

    @JsonIgnore
    @ManyToOne
    Ingredient ingredient;

}
