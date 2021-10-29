package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by M.Şahin on 25/10/2021
 */

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob //contains both clob (character large objects and binary large objects)
    private String directions; //except char and string related fields, all fields
                                //defaults to blob (binary large objects)
    //so above declaration directions are text. (clob)

    @Lob
    private Byte [] image; //but here image is blob cuz declaration is done by Byte...

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty; //ordinary var char (255) variable but get info
                                //as enum and EnumType.STRING is used in db.

    /*
        this side has cascade operation because we want to cascade from this side to
        child side.

        So, We want one recipe is deleted, all notes is deleted related to that recipe.

        But we dont want deletion of recipe when notes are deleted. this does not make
        sense.
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;        //both sides have fk of each other (Notes)
                            //fk -> Notes id (pk)

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") //ordinary one to many rs
    private Set<Ingredient> ingredients = new HashSet<>(); //this side does not hold fk

    /*
        recipe_id -> fk to recipe table
        category_id -> fk to category table
        recipe_id + category_id -> pk of recipe_category table
     */
    @ManyToMany     //this is not owning side and not mappedBy side. Owning side is join table.
    @JoinTable(name = "recipe_category",  //specify join table characteristics and column names
    joinColumns = @JoinColumn(name = "recipe_id"), //pk of recipe is going to recipe_category as fk
    inverseJoinColumns = @JoinColumn(name = "category_id"))//pk of category is going to recipe_category as fk
    private Set<Category> categories = new HashSet<>(); //dont forget to init collections not to take npe


    public void setNotes(Notes notes)
    {
        this.notes = notes;
        notes.setRecipe(this); //for sync helper
    }

    public Recipe addIngredient(Ingredient ingredient){ //helper method for sync
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);

        return this;
    }
}
