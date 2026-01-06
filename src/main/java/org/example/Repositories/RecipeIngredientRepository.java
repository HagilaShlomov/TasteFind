package org.example.Repositories;

import org.example.Entity.Ingredient;
import org.example.Entity.Recipe;
import org.example.Entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Integer> {

    List<RecipeIngredient> findByRecipeId(Recipe recipe);
    boolean existsByRecipeIdAndIngredientId(Recipe recipe, Ingredient ingredient);

}
