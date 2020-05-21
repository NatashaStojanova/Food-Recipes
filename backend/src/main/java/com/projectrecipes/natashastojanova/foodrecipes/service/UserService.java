package com.projectrecipes.natashastojanova.foodrecipes.service;

import com.projectrecipes.natashastojanova.foodrecipes.model.User;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @author Natasha Stojanova
 */
public interface UserService extends BaseEntityCrudService<User> {

    boolean passwordMatches(User user, String password);

    Optional<User> findByUsername(String username);

    User findByEmail(String email);
}
