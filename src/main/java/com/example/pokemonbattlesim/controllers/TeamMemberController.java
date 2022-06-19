package com.example.pokemonbattlesim.controllers;

import com.example.pokemonbattlesim.models.TeamMember;
import com.example.pokemonbattlesim.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/teamMember")
public class TeamMemberController {
    private final TeamMemberService teamMemberService;

    @Autowired
    public TeamMemberController(TeamMemberService teamMemberService) {
            this.teamMemberService = teamMemberService;
    }

    @GetMapping
    public List<TeamMember> getTeamMembers() {

        return teamMemberService.getTeamMembers();
    }

    @GetMapping(path = "{teamId}")
    public List<TeamMember> getTeamMembersByTeamId(@PathVariable("teamId") Long teamId) {
        return teamMemberService.getTeamMembersByTeamId(teamId);
    }

    @PostMapping
    public void createTeamMember(@RequestBody TeamMember teamMember) {
        teamMemberService.addNewTeamMember(teamMember);
    }
}
