package com.cameronbailey.pokemonbattlesim.service;

import com.cameronbailey.pokemonbattlesim.models.TeamMember;
import com.cameronbailey.pokemonbattlesim.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;

    @Autowired
    public TeamMemberService(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    public List<TeamMember> getTeamMembers() {
        return teamMemberRepository.findAll();
    }

    public void addNewTeamMember(TeamMember teamMember) {
        teamMemberRepository.save(teamMember);
    }

    public List<TeamMember> getTeamMembersByTeamId(Long teamId) {
        List<TeamMember> teamMembers = teamMemberRepository.findTeamMembersByTeamId(teamId);
        return teamMembers;
    }

    public void deleteTeamMembersByTeamId(Long id) {
        teamMemberRepository.deleteTeamMembersByTeamId(id);
    }
}
