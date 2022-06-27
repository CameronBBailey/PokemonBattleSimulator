package com.cameronbailey.pokemonbattlesim.service;

import com.cameronbailey.pokemonbattlesim.models.Team;
import com.cameronbailey.pokemonbattlesim.models.TeamMember;
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
public class TeamMemberServiceTest {
    @Autowired
    private TeamMemberService service;

    @Test /* Tests getting all teams members */
    public void testGetTeamsMembers() {
        List<TeamMember> teamMembers = service.getTeamMembers();
        assertThat(teamMembers).isNotNull();
    }
}
