package com.cameronbailey.pokemonbattlesim.repository;

import static org.assertj.core.api.Assertions.assertThat;
import com.cameronbailey.pokemonbattlesim.models.Team;
import com.cameronbailey.pokemonbattlesim.models.TeamMember;
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
@Rollback(value = true)
public class TeamMemberRepositoryTests {

    @Autowired
    private TeamMemberRepository repo;

    @Autowired
    private TeamRepository teamRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test /* Tests finding Team Member by Id */
    public void testFindTeamMemberById() {
        TeamMember teamMember = new TeamMember();
        teamMember.setId(123456789L);
        TeamMember savedTeamMember = repo.save(teamMember);

        TeamMember existTeamMember = entityManager.find(TeamMember.class, savedTeamMember.getId());
        TeamMember testTeam = repo.findTeamMemberById(existTeamMember.getId());
        assertThat(testTeam.getId()).isEqualTo(existTeamMember.getId());
    }

    @Test /* Tests finding Team Members by Team Id */
    public void testFindTeamMembersByTeamId() {
        Team team = new Team();
        team.setName("this is a test");
        Team savedTeam = teamRepo.save(team);

        Team existTeam = entityManager.find(Team.class, savedTeam.getId());

        TeamMember one = new TeamMember();
        one.setTeam(existTeam.getId());
        repo.save(one);
        List<TeamMember> teamMemberList = new ArrayList<>(1);
        teamMemberList.add(one);
        assertThat(teamMemberList).isEqualTo(repo.findTeamMembersByTeamId(existTeam.getId()));

    }

    @Test /* Tests Deleting Team Members by Team Id */
    public void testDeleteTeamMembersByTeamId() {
        Team team = new Team();
        team.setName("this is a test");
        Team savedTeam = teamRepo.save(team);
        Team existTeam = entityManager.find(Team.class, savedTeam.getId());
        TeamMember one = new TeamMember();
        one.setTeam(existTeam.getId());
        repo.save(one);
        repo.deleteTeamMembersByTeamId(existTeam.getId());
        List<TeamMember> emptyList = new ArrayList<>(0);
        assertThat(repo.findTeamMembersByTeamId(existTeam.getId())).isEqualTo(emptyList);
    }
}
