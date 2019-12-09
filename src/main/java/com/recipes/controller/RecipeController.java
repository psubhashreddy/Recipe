package com.recipes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipes.exception.NoDataFoundException;
import com.recipes.model.Recipe;
import com.recipes.service.RecipeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = {"http://localhost:8081"})
@RestController
@RequestMapping("/api")
@Api(value = "Recipe Management Application")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@ApiOperation(value = "Search Recipe by Id", response = ResponseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Search is Successfull"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(value = "/recipe/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Recipe> getRecipeById(
			@ApiParam(value = "Recipe is fetched from database", required = true)
			@PathVariable int id) throws NoDataFoundException {
		Recipe recipe = recipeService.getRecipeById(id);
		return new ResponseEntity<>(recipe, new HttpHeaders(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Search Recipe by Name", response = ResponseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Search is Successfull"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(value = "/recipe/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Recipe> getRecipeByName(
			@ApiParam(value = "Recipe is fetched from database", required = true)
			@PathVariable String name) throws NoDataFoundException {
		Recipe recipe = recipeService.getRecipeByName(name.toUpperCase());
		return new ResponseEntity<>(recipe, new HttpHeaders(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "List All Recipes", response = ResponseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Listed all Recipes Successfully"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(value = "/recipe/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recipe>> getAllRecipes() throws NoDataFoundException{
		List<Recipe> recipes = recipeService.getAllRecipes();
		return new ResponseEntity<>(recipes, new HttpHeaders(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add a new Recipe")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "New Recipe added successfully"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@PostMapping(value = "/recipe/save")
	public void saveRecipe(
			@ApiParam(value = "Recipe is added in database", required = true)
			@Valid @RequestBody Recipe recipe) throws NoDataFoundException {
			recipeService.saveRecipe(recipe);
	}
	
	@ApiOperation(value = "Update Recipe Details", response = ResponseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Recipe updated successfully"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@PutMapping(value = "/recipe/update")
	public ResponseEntity<Recipe> updateRecipe(
			@ApiParam(value = "Recipe is updated in database", required = true)
			@Valid @RequestBody Recipe recipe) throws NoDataFoundException{
		Recipe recipeSaved = recipeService.updateRecipe(recipe);
		return new ResponseEntity<>(recipeSaved, new HttpHeaders(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete a Recipe")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Recipe deleted successfully"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@DeleteMapping(value = "/recipe/delete/{id}")
	public String deleteRecipe(
			@ApiParam(value = "Recipe is being deleted from database", required = true)
			@PathVariable int id) throws NoDataFoundException{
		recipeService.deleteRecipe(id);
		return "Deleted Recipe id:"+id+" Successfully!";
	}
}
