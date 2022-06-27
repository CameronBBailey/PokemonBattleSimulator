package com.cameronbailey.pokemonbattlesim.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.cameronbailey.pokemonbattlesim.models.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
class TeamServiceTest {


    @Autowired
    private TeamService service;

    @Test
    public void testGetTeams() {
        List<Team> teams = service.getTeams();
        assertThat(teams).isNotNull();
    }
}