package com.recipes.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.recipes.utilities.DateUtil;

@Entity
@Table(name = "RECIPE")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "FOOD_TYPE")
	private String foodType;
	
	@Column(name = "SERVED_TO")
	private int servedTo;
	
	@Column(name = "CREATED_ON")
	private LocalDateTime createdOn = LocalDateTime.now();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)    
	private Set<Ingredients> ingredients = new HashSet<Ingredients>();

	@JsonManagedReference
	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Instructions> instructions = new HashSet<Instructions>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getFoodType() {
		if(foodType.equalsIgnoreCase("VEGETARIAN")) {
			return 'Y';
		}else {
			return 'N';
		}
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getServedTo() {
		return servedTo;
	}

	public void setServedTo(int servedTo) {
		this.servedTo = servedTo;
	}

	public String getCreatedOn() {
		return DateUtil.formatDate(createdOn);
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public Set<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	public Set<Instructions> getInstructions() {
		return instructions;
	}

	public void setInstructions(Set<Instructions> instructions) {
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", foodType=" + foodType
				+ ", servedTo=" + servedTo + ", createdOn=" + createdOn + ", ingredients=" + ingredients
				+ ", instructions=" + instructions + "]";
	}

}
