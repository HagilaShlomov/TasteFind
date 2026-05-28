package org.example.Repositories;

import org.example.Entity.Recipe;
import org.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    List<Recipe> findByUserId(User user);

    List<Recipe> findByTitleContaining(String keyword);

    boolean existsByUserIdAndTitle(User user, String title);
}
