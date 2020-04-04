package com.projectrecipes.natashastojanova.foodrecipes.service.implementation;

import com.projectrecipes.natashastojanova.foodrecipes.exceptions.UserNotFoundException;
import com.projectrecipes.natashastojanova.foodrecipes.model.User;
import com.projectrecipes.natashastojanova.foodrecipes.repository.UserRepository;
import com.projectrecipes.natashastojanova.foodrecipes.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author Natasha Stojanova
 */

@Service
public class UserServiceImpl extends BaseEntityCrudServiceImpl<User, UserRepository> implements UserService {

    private UserRepository repository;
    private BCryptPasswordEncoder encoder;
    private Logger logger = Logger.getLogger(UserService.class.getName());

    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    protected UserRepository getRepository() {
        return repository;
    }

    @Override
    public boolean passwordMatches(User user, String password) {
        return encoder.matches(password, user.getPassword());
    }

    @Override
    public User findByUsername(String username) {
        logger.info("[PERSISTENCE] Get entity by Username");
        Optional<User> user = repository.findByUsername(username);
        if (((Optional) user).isPresent())
            return user.get();
        throw new UserNotFoundException();
    }
}