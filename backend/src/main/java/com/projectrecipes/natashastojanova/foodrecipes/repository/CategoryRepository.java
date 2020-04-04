package com.projectrecipes.natashastojanova.foodrecipes.repository;

import com.projectrecipes.natashastojanova.foodrecipes.model.Category;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Natasha Stojanova
 */
@Repository
public interface CategoryRepository extends JpaSpecificationRepository<Category>{

    Optional<Category> findById(Long id);

    Optional<Category> findByName(String name);
}
