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
    } /* Gets all Team Members */

    public void addNewTeamMember(TeamMember teamMember) {
        teamMemberRepository.save(teamMember);
    } /* Saves a new Team Members */

    public List<TeamMember> getTeamMembersByTeamId(Long teamId) {
        List<TeamMember> teamMembers = teamMemberRepository.findTeamMembersByTeamId(teamId);
        return teamMembers;
    } /* Finds all Team Members with a specific teamId */

    public void deleteTeamMembersByTeamId(Long id) {
        teamMemberRepository.deleteTeamMembersByTeamId(id);
    } /* Deletes Team Members by a specific team member id */

    public  TeamMember getTeamMemberById(Long id) { return teamMemberRepository.findTeamMemberById(id); } /* Find a specific Team Member by Team Member id */

    public TeamMember updateTeamMember(TeamMember teamMember) { return teamMemberRepository.save(teamMember);} /*  Updates a team member */
}
