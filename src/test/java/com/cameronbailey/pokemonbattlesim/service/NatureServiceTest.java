package com.cameronbailey.pokemonbattlesim.service;

import com.cameronbailey.pokemonbattlesim.models.Nature;
import com.cameronbailey.pokemonbattlesim.models.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class NatureServiceTest {

    @Autowired
    private NatureService service;

    @Test /* Tests getting all natures */
    public void testGetNature() {
        List<Nature> nature = service.getNature();
        assertThat(nature).isNotNull();
    }
}
