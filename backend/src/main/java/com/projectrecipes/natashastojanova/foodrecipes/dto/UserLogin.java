package com.projectrecipes.natashastojanova.foodrecipes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Natasha Stojanova
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {

    private String username;
    private String password;
    private String name;
    private String email;

}
