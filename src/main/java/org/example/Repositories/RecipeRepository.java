package org.example.Repositories;

import org.example.Entity.Recipe;
import org.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    List<Recipe> findByUserId(User user);

    // חיפוש לפי כותרת (לדוגמה לחיפוש חופשי)
    List<Recipe> findByTitleContaining(String keyword);

    // האם למשתמש יש מתכון בשם מסוים
    boolean existsByUserIdAndTitle(User user, String title);
}
