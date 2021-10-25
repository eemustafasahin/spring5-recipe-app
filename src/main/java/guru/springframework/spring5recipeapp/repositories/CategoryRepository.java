package guru.springframework.spring5recipeapp.repositories;

import guru.springframework.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by M.Şahin on 25/10/2021
 */
public interface CategoryRepository extends CrudRepository<Category,Long> {


}
