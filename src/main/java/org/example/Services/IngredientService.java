package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.Entity.Ingredient;
import org.example.Repositories.IngredientRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IngredientService {
    private IngredientRepository ingredientRepository;

    public void createIngredient(Ingredient ingredient) {
        if(ingredientRepository.existsById(ingredient.getId())) throw new IllegalArgumentException("ingredient already exists");
        ingredientRepository.save(ingredient);
    }

    public Ingredient getIngredientById(int id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    public void deleteIngredientById(int id) {
        if(!ingredientRepository.existsById(id)) throw new IllegalArgumentException("ingredient does not exist");
        ingredientRepository.deleteById(id);
    }




}
