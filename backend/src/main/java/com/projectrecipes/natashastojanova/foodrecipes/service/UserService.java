package com.projectrecipes.natashastojanova.foodrecipes.service;

import com.projectrecipes.natashastojanova.foodrecipes.model.User;

/**
 * @author Natasha Stojanova
 */
public interface UserService extends BaseEntityCrudService<User> {

    boolean passwordMatches(User user, String password);

    User findByUsername(String username);
}
