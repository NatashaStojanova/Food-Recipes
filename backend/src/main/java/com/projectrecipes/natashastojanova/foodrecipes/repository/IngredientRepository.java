package com.projectrecipes.natashastojanova.foodrecipes.repository;

import com.projectrecipes.natashastojanova.foodrecipes.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Natasha Stojanova
 */
@Repository
public interface IngredientRepository extends JpaSpecificationRepository<Ingredient>{
    Optional<Ingredient> findById(Long id);

    Optional<Ingredient> findByName(String name);


}
