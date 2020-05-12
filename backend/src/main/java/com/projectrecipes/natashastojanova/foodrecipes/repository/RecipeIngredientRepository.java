package com.projectrecipes.natashastojanova.foodrecipes.repository;

import com.projectrecipes.natashastojanova.foodrecipes.model.RecipeIngredient;
import com.projectrecipes.natashastojanova.foodrecipes.model.RecipeIngredientCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Natasha Stojanova
 */
@Repository
public interface RecipeIngredientRepository extends JpaSpecificationRepository<RecipeIngredient> {


}
