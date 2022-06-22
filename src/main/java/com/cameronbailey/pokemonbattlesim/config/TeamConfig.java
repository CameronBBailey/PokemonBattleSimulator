package com.cameronbailey.pokemonbattlesim.config;

import com.cameronbailey.pokemonbattlesim.models.Team;
import com.cameronbailey.pokemonbattlesim.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeamConfig {

    @Bean
    CommandLineRunner commandLineRunner3(TeamRepository repository) {
        return args -> {
            Team team1 = new Team(
                    1L,
                    "Team 1"

            );

            Team team2 = new Team(
                    1L,
                    "Team 2"

            );

            Team team3 = new Team(
                    1L,
                    "Team 3"

            );
            repository.saveAll(List.of(team1, team2, team3)
            );
        };
    }
}
