package com.recipes.utilities;

import java.util.List;

import com.google.common.collect.Lists;
import com.recipes.model.Recipe;

public class ResponseFilter {
	
	public static List<Recipe> filterObjectList(List<Recipe> recipes) {
		
		List<Recipe> recipeList = Lists.newArrayList();
		for(Recipe recipe : recipes) {
			recipeList.add(filterObject(recipe));
		}
		return recipeList;
	}
	
	public static Recipe filterObject(Recipe recipe) {
		return recipe;
	}

}
