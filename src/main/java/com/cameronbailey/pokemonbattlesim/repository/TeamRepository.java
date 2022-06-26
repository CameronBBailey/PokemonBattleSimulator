package com.cameronbailey.pokemonbattlesim.repository;

import com.cameronbailey.pokemonbattlesim.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findTeamByUserId(Long id);

}
