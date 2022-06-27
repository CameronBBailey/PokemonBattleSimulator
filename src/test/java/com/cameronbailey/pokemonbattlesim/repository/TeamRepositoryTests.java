package com.cameronbailey.pokemonbattlesim.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.cameronbailey.pokemonbattlesim.models.Team;
import com.cameronbailey.pokemonbattlesim.models.User;
import com.cameronbailey.pokemonbattlesim.repository.TeamRepository;
import com.cameronbailey.pokemonbattlesim.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class TeamRepositoryTests {

    @Autowired
    private TeamRepository repo;

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateTeam() {
        Team team = new Team();
        Team savedTeam = repo.save(team);
        Team existTeam = entityManager.find(Team.class, savedTeam.getId());

        assertThat(team.getId()).isEqualTo(existTeam.getId());
    }

    @Test
    public void testFindTeamByUserId() {

        User user = new User();
        user.setEmail("TestTestTestTestTest@gmail.com");
        user.setPassword("12345");
        user.setUsername("Flavor Blasted");

        User savedUser = userRepo.save(user);

        Team team = new Team();
        team.setUser(savedUser.getId());
        Team savedTeam = repo.save(team);
        Team existTeam = entityManager.find(Team.class, savedTeam.getId());
        List<Team> teamList = new ArrayList<Team>(1);
        teamList.add(existTeam);
        assertThat(existTeam).isEqualTo(repo.findTeamByUserId(savedUser.getId()).get(0));

    }

    @Test
    public void testFindTeamById() {
        Team team = new Team();
        team.setName("this is a test");
        Team savedTeam = repo.save(team);

        Team existTeam = entityManager.find(Team.class, savedTeam.getId());
        Team testTeam = repo.findTeamById(existTeam.getId());
        assertThat(testTeam.getName()).isEqualTo(existTeam.getName());

    }

}
