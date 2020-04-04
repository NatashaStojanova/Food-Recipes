package com.projectrecipes.natashastojanova.foodrecipes.repository;

import com.projectrecipes.natashastojanova.foodrecipes.model.UserRole;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Natasha Stojanova
 */
@Repository
public interface UserRoleRepository extends JpaSpecificationRepository<UserRole>{

    Optional<UserRole> findByName(String name);
}
