package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by M.Şahin on 25/10/2021
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount; //numeric type in postgresql

    @ManyToOne
    private Recipe recipe; //this side holds fk to recipe

    @OneToOne(fetch = FetchType.EAGER) //this side holds fk to uom.
    private UnitOfMeasure uom; //unidirectional from this side so fk is in here.

    public Ingredient()
    {

    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe)
    {
        this.description = description;
        this.amount = amount;
        this.recipe = recipe;
        this.uom = uom;
    }

}
