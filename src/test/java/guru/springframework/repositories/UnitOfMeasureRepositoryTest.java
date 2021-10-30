package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by M.Şahin on 30/10/2021
 */


@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository m_unitOfMeasureRepository;



    @BeforeEach
    void setUp()
    {
    }

    @Test
    void findByDescription()
    {

        Optional<UnitOfMeasure> uom = m_unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", uom.get().getDescription());
    }

    @Test
    void findByDescriptionForCup()
    {

        Optional<UnitOfMeasure> uom = m_unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", uom.get().getDescription());
    }
}