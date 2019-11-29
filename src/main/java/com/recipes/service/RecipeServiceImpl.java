package com.recipes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipes.exception.NoDataFoundException;
import com.recipes.model.Recipe;
import com.recipes.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
	
	Logger log = LoggerFactory.getLogger(RecipeServiceImpl.class);
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Override
	public Recipe getRecipeById(final int recipeId) throws NoDataFoundException {
		log.info("In get method of recipe Service by Id:{}", recipeId);
		Optional<Recipe> recipe = recipeRepository.findById(recipeId);
		if(recipe.isPresent()) {
			return recipe.get();
		}else {
			throw new NoDataFoundException("There is no recipe by name : "+recipeId);
		}
	}
	
	
	@Override
	public Recipe getRecipeByName(final String recipeName) throws NoDataFoundException {
		log.info("In get method of recipe Service by name:{}",recipeName);
		Optional<Recipe> recipe = recipeRepository.findByName(recipeName);
		if(recipe.isPresent()) {
			return recipe.get();
		}else {
			throw new NoDataFoundException("There is no recipe by name : "+recipeName);
		}
	}
	
	@Override
	public final List<Recipe> getAllRecipes(){
		List<Recipe> recipes = recipeRepository.findAll();
		if(recipes.size() > 0) {
			return recipes;
		}else {
			return new ArrayList<Recipe>();
		}
	}

	public void saveRecipe(Recipe recipe) throws NoDataFoundException{
		recipeRepository.save(recipe);
	}
	
	public Recipe updateRecipe(Recipe recipe) throws NoDataFoundException {
		Optional<Recipe> recipeExisting = recipeRepository.findById(recipe.getId());
		if(recipeExisting.isPresent()) {
			Recipe recipeCurrent = recipeExisting.get();
			recipeCurrent.setName(recipe.getName());
			recipeCurrent.setDescription(recipe.getDescription());
			recipeCurrent.setServedTo(recipe.getServedTo());
			recipeCurrent.setIngredients(recipe.getIngredients());
			recipeCurrent.setInstructions(recipe.getInstructions());
			return recipeRepository.save(recipeCurrent);
		}else {
			return recipeRepository.save(recipe);
		}
	}
	
	public void deleteRecipe(final int recipeId) throws NoDataFoundException{
		Optional<Recipe> recipeExisting = recipeRepository.findById(recipeId);
		log.info("In delete method of recipe service, recipe with id:{} exists",recipeId);
		if(recipeExisting.isPresent()) {
			log.info("recipe with id:{} got deleted successfully", recipeExisting.get().getId());
			recipeRepository.delete(recipeExisting.get().getId());
			
		}else {
			throw new NoDataFoundException("There is no such recipe by Id : "+recipeId);
		}
	}
	
}
