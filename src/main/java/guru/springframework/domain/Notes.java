package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by M.Şahin on 25/10/2021
 */

@Data
@EqualsAndHashCode(exclude = {"recipe"})
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

}
