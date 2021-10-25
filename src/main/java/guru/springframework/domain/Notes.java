package guru.springframework.domain;

import javax.persistence.*;

/**
 * Created by M.Şahin on 25/10/2021
 */

@Entity
public class Notes { //this is bidirectional one to one table because both side has
                    //relationship annotations

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne       //both sides have fk of each other (Notes)
    private Recipe recipe;  //fk -> Notes id (pk)

    @Lob
    private String recipeNotes; //this is text type used for large strings

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Recipe getRecipe()
    {
        return recipe;
    }

    public void setRecipe(Recipe recipe)
    {
        this.recipe = recipe;
    }

    public String getRecipeNotes()
    {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes)
    {
        this.recipeNotes = recipeNotes;
    }
}
