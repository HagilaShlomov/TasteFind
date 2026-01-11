package org.example.Services;

import org.example.Entity.Recipe;
import org.example.Entity.User;
import org.example.Repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }


}
