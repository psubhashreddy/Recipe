package com.recipes.controller;

import static org.mockito.Matchers.anyString;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.recipes.service.RecipeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RecipeController.class, secure = false)
public class RecipeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RecipeService recipeService;
	
	@Before
	public void init() throws Exception{
		
	}
	
	@Test
	public void getRecipeByNameTest() throws Exception{
		Mockito.when(recipeService.getRecipeByName(anyString())).thenReturn(null);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/recipe/id/recipeId").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println("******"+result.getResponse().toString());
		
		//JSONAssert.assertEquals(expectedResponse, result.getResponse().getContentAsString(), false);
	}

}
