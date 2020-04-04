package com.projectrecipes.natashastojanova.foodrecipes.repository;

import com.projectrecipes.natashastojanova.foodrecipes.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Natasha Stojanova
 */
@Repository
public interface RecipeRepository extends JpaSpecificationRepository<Recipe>{
    Optional<Recipe> findByName(String name);

    Optional<Recipe> findByRating(Integer rating);
}
