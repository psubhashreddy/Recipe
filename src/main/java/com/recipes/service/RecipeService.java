package com.recipes.service;

import java.util.List;

import com.recipes.exception.NoDataFoundException;
import com.recipes.model.Recipe;

public interface RecipeService {
	
	Recipe getRecipeById(int id) throws NoDataFoundException;
	
	Recipe getRecipeByName(String recipeName) throws NoDataFoundException;
	
	List<Recipe> getAllRecipes() throws NoDataFoundException;

	void saveRecipe(Recipe recipe) throws NoDataFoundException;
	
	Recipe updateRecipe(Recipe recipe) throws NoDataFoundException;
	
	void deleteRecipe(int recipeId) throws NoDataFoundException;
}
