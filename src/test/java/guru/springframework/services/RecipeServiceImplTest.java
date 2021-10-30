package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Created by M.Şahin on 30/10/2021
 */
class RecipeServiceImplTest {

    RecipeServiceImpl m_recipeService;

    @Mock
    RecipeRepository m_recipeRepository;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);

        m_recipeService = new RecipeServiceImpl(m_recipeRepository);
    }

    @Test
    void getRecipes()
    {
        Recipe recipe = new Recipe();
        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);

        when(m_recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = m_recipeService.getRecipes(); //no data available without when expression
        assertEquals(recipes.size(), 1);
        verify(m_recipeRepository, times(1)).findAll();


    }
}