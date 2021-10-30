package guru.springframework.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by M.Şahin on 30/10/2021
 */
@Slf4j
class CategoryTest {

    Category m_category;

    @BeforeEach
    public void setUp()
    {
        m_category = new Category();

        Long idVal = 3L;
        String desc = "products";

        m_category.setId(idVal);
        log.info(String.format("id value is set up \"%d\"%n", idVal));
        m_category.setDescription(desc);
        log.info(String.format("description is set up \"%s\"%n", desc));
    }

    @Test
    void getId()
    {
        log.info("getId() method is being tested.");
        assertEquals(3L, m_category.getId());
    }

    @Test
    void getDescription()
    {
        log.info("getDescription() method is being tested.");
        assertEquals("products",m_category.getDescription());
    }
}