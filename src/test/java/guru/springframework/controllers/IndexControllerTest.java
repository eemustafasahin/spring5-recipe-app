package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by M.Şahin on 30/10/2021
 */
class IndexControllerTest {

    //dependencies for run method i.e. model and recipe service needs to be added with mock objects

    @Mock
    RecipeService m_recipeService;

    @Mock
    Model m_model;

    IndexController m_controller;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
        //initialize unit that we want to test to set up environment
        m_controller = new IndexController(m_recipeService);
    }

    @Test
    void testMockMVC() throws Exception
    {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(m_controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/index.html"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void getIndexPage()
    {
        //given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        recipes.add(new Recipe());

        when(m_recipeService.getRecipes()).thenReturn(recipes);

        @SuppressWarnings(value = "unchecked")
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String viewName = m_controller.getIndexPage(m_model);
        assertEquals("index", viewName);
        verify(m_recipeService, times(1)).getRecipes();
        verify(m_model, times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());

        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(1, setInController.size());

    }
}