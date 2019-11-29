package com.recipes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Table(name = "INGREDIENTS")
@Data
public class Ingredients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INGREDIENT_ID")
	private int ingredientId;
	
	@Column(name = "INGREDIENT_NAME")
	private String ingredientName;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="RECIPE_ID", nullable=false)
	private Recipe recipe;

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "Ingredients [ingredientId=" + ingredientId + ", ingredientName=" + ingredientName + ", recipe=" + recipe
				+ "]";
	}
	
}
