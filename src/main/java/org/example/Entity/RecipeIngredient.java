package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "recipeId", nullable = false)
    private Recipe recipeId;

    @ManyToOne
    @JoinColumn(name = "ingredientId", nullable = false)
    private Ingredient ingredientId;

    @Column(nullable = false)
    private String quantity;

    private Integer position;
}
