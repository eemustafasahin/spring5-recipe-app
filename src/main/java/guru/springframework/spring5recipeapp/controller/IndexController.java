package guru.springframework.spring5recipeapp.controller;

import guru.springframework.spring5recipeapp.domain.Category;
import guru.springframework.spring5recipeapp.domain.UnitOfMeasure;
import guru.springframework.spring5recipeapp.repositories.CategoryRepository;
import guru.springframework.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by M.Şahin on 23/10/2021
 */

@Controller
public class IndexController {

    private final CategoryRepository m_categoryRepository;
    private final UnitOfMeasureRepository m_unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository)
    {
        m_categoryRepository = categoryRepository;
        m_unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getIndexPage()
    {
        Optional<Category> cat  = m_categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> uom = m_unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println(cat.isPresent() ? "Cat ID is : " + cat.get().getId() : "There is nothing to show");
        System.out.println(uom.isPresent() ? "UOM ID is : " + cat.get().getId() : "There is nothing to show");

        return "index"; //this index must match with index.html file we specify
    }
}
