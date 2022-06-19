package com.example.pokemonbattlesim.repository;

import com.example.pokemonbattlesim.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findTeamByUserId(Long id);

    Team findTeamById(Long id);


    Team getTeamById(Long id);

//    Team saveTeam(Team team);

//    Team updateTeam(Team team);
//
    void deleteTeamById(Long id);
}
