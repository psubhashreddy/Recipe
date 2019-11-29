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
@Table(name = "INSTRUCTIONS")
@Data
public class Instructions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INSTRUCTION_ID")
	private int instructionId;
	
	@Column(name = "INSTRUCTION_DESCRIPTION")
	private String instructionDescription;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="RECIPE_ID", nullable=false)
	private Recipe recipe;

	public int getInstructionId() {
		return instructionId;
	}

	public void setInstructionId(int instructionId) {
		this.instructionId = instructionId;
	}

	public String getInstructionDescription() {
		return instructionDescription;
	}

	public void setInstructionDescription(String instructionDescription) {
		this.instructionDescription = instructionDescription;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "Instructions [instructionId=" + instructionId + ", instructionDescription=" + instructionDescription
				+ ", recipe=" + recipe + "]";
	}
	
}
