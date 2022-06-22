package com.cameronbailey.pokemonbattlesim.config;

import com.cameronbailey.pokemonbattlesim.models.TeamMember;
import com.cameronbailey.pokemonbattlesim.repository.TeamMemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeamMemberConfig {

    @Bean
    CommandLineRunner commandLineRunner2(TeamMemberRepository repository) {
        return args -> {
            TeamMember pikachu = new TeamMember(
                1L,
                    1L,
                    2L,
                    "static",
                    "bold",
                    1L,2L,3L,4L,
                    255L,255L,0L,0L,0L,0L,
                    31L,31L,31L,31L,31L,31L

            );
                    repository.saveAll(
                            List.of(pikachu)

            );
        };
    }
}
