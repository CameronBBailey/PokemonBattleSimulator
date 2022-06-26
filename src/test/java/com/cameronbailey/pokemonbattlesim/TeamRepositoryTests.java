package com.cameronbailey.pokemonbattlesim;

import com.cameronbailey.pokemonbattlesim.models.Team;
import com.cameronbailey.pokemonbattlesim.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class TeamRepositoryTests {

    @Autowired
    private TeamRepository repo;

    @Test
    public void testCreateTeam() {
        Team team = new Team(2L, "test");
        Team savedTeam = repo.save(team);


    }

}
