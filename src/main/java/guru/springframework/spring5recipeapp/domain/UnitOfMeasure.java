package guru.springframework.spring5recipeapp.domain;

import javax.persistence.*;

/**
 * Created by M.Şahin on 25/10/2021
 */
@Entity
public class UnitOfMeasure { //not a bidirectional relationship and there
                            //there is no relationship annotations here
                            //this table is reference table so, we dont need to navigate
                            //from this side.

                            //here ref. table means info. table to get from
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

}
