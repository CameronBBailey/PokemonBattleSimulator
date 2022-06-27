package com.cameronbailey.pokemonbattlesim.service;

import com.cameronbailey.pokemonbattlesim.models.Team;
import com.cameronbailey.pokemonbattlesim.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) { this.teamRepository = teamRepository; }


    public List<Team> getTeams() {
        return teamRepository.findAll();
    } /* Finds all teams */

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }/* Saves our team */


    public Team getTeamById(Long id) {
        return teamRepository.findTeamById(id);
    } /* Find a specific team by team id */

    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }/* Updates a team */

    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    } /* Deletes a team by Id */
    public List<Team> getTeamByUserId(Long userId) {
        List<Team> teams = teamRepository.findTeamByUserId(userId);
        return teams;
    } /* Gets a list of team by a specific user id */
}
