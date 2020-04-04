package com.projectrecipes.natashastojanova.foodrecipes.repository;

import com.projectrecipes.natashastojanova.foodrecipes.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Natasha Stojanova
 */
@Repository
public interface UserRepository extends JpaSpecificationRepository<User>{

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

}
