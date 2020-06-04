package com.projectrecipes.natashastojanova.foodrecipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Recipe {

    private String name;
    private String description;
    private float time;
    private int rating;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "recipe")
    private List<RecipeIngredient> ingredientList;

    @JsonIgnore
    @ManyToOne
    private Category category;


}
