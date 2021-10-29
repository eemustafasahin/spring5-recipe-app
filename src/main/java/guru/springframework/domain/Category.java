package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by M.Şahin on 25/10/2021
 */
@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description; //by default varchar (255 len)

    @ManyToMany(mappedBy = "categories") //mappedBy side a.k.a inverse side
    private Set<Recipe> recipes = new HashSet<>(); //this does not exists in category table but in join table

}
