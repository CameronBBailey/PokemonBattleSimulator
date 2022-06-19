package com.example.pokemonbattlesim.service;

import com.example.pokemonbattlesim.models.Team;
import com.example.pokemonbattlesim.repository.TeamRepository;
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
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }


    public Team getTeamById(Long id) {
        return teamRepository.findById(id).get();
    }

    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }
    public List<Team> getTeamByUserId(Long userId) {
        List<Team> teams = teamRepository.findTeamByUserId(userId);
        return teams;
    }
}
