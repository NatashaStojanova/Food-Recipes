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

    @JsonIgnore
    @ManyToOne
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private List<Recipe> recipeList;


    public User(String username, String password, String name, String email, UserRole userRole) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userRole = userRole;

    }


}
