package guru.springframework.repositories;

import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by M.Şahin on 25/10/2021
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
