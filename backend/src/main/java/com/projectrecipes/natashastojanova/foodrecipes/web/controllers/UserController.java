package com.projectrecipes.natashastojanova.foodrecipes.web.controllers;

import com.projectrecipes.natashastojanova.foodrecipes.exceptions.UserAlreadyExistsException;
import com.projectrecipes.natashastojanova.foodrecipes.model.User;
import com.projectrecipes.natashastojanova.foodrecipes.service.UserRoleService;
import com.projectrecipes.natashastojanova.foodrecipes.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.util.Optional;

/**
 * @author Natasha Stojanova
 */
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    private final UserRoleService userRoleService;
    private BCryptPasswordEncoder encoder;

    public UserController(UserService userService, UserRoleService userRoleService, BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.encoder = encoder;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user) throws RoleNotFoundException {

        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        String password = user.getPassword();
        newUser.setPassword(encoder.encode(password));
        newUser.setUserRole(userRoleService.findByName("ROLE_USER"));
        userService.save(newUser);
        return newUser;


    }

}
