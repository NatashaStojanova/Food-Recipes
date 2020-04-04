package com.projectrecipes.natashastojanova.foodrecipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

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

public class User {

    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private UserRole userRole;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "user_recipe",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "recipe_id")})
    private List<Recipe> recipeList;


}
