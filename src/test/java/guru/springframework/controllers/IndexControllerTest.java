package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
    void getIndexPage()
    {
        String viewName = m_controller.getIndexPage(m_model);
        assertEquals("index", viewName);
        verify(m_recipeService, times(1)).getRecipes();
        verify(m_model, times(1)).addAttribute(eq("recipes"),anySet());

    }
}