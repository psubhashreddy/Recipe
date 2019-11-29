/*
 * package com.recipes.service;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.mockito.Matchers.anyString; import static org.mockito.Mockito.when;
 * 
 * import java.util.List;
 * 
 * import org.junit.Before; import org.junit.Test; import
 * org.junit.runner.RunWith; import org.mockito.Mock; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.recipes.exception.NoDataFoundException; import
 * com.recipes.model.Recipe; import com.recipes.repository.RecipeRepository;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest public class RecipeServiceTest {
 * 
 * @Autowired private RecipeService recipeService;
 * 
 * @Mock private RecipeRepository recipeRepository;
 * 
 * private static final String RECIPE_NAME_EXISTED = "BIRYANI"; private static
 * final String RECIPE_NAME_NOT_EXIST = "MUTTON"; private static final String
 * RECIPE_TYPE = "N"; private static final int DEFAULT_RECIPES_COUNT = 5;
 * 
 * @Before public void init() {
 * 
 * }
 * 
 * @Test public void dbTableCreationTest() throws NoDataFoundException {
 * List<Recipe> recipes = recipeService.getAllRecipes();
 * 
 * assertEquals(recipes.size(), DEFAULT_RECIPES_COUNT); }
 * 
 * @Test public void getRecipeByNameTest() throws NoDataFoundException { Recipe
 * recipe = recipeService.getRecipeByName(RECIPE_NAME_EXISTED);
 * 
 * assertEquals(recipe.getName(), RECIPE_NAME_EXISTED); }
 * 
 * @Test public void getRecipeByNameNotFoundTest() throws NoDataFoundException {
 * when(recipeRepository.findByName(anyString())).thenReturn(null);
 * 
 * recipeService.getRecipeByName(RECIPE_NAME_NOT_EXIST);
 * 
 * //assertThat(NoDataFoundException.class,
 * equalTo(NoDataFoundException.class));
 * 
 * }
 * 
 * @Test public void getAllRecipesTest() throws NoDataFoundException {
 * List<Recipe> recipes = recipeService.getAllRecipes();
 * 
 * assertEquals(recipes.size(), DEFAULT_RECIPES_COUNT); }
 * 
 * }
 */