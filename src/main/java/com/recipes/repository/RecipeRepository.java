package com.recipes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipes.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>{
	
	Optional<Recipe> findById(int recipeId);
	Optional<Recipe> findByName(String recipeName);
	List<Recipe> findAll();
}
	