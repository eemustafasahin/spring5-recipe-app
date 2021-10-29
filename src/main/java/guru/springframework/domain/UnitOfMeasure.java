package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by M.Şahin on 25/10/2021
 */
@Data
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

}
