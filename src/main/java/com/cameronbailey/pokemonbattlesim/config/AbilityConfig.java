package com.cameronbailey.pokemonbattlesim.config;

import com.cameronbailey.pokemonbattlesim.models.Ability;
import com.cameronbailey.pokemonbattlesim.repository.AbilityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AbilityConfig {

    @Bean
    CommandLineRunner commandLineRunner4(AbilityRepository repository) {

        return args -> {
            Ability blaze = new Ability(
                    "blaze",
                    "fire type attacks powered up by 1.5x when under 33% hp"
                    );
            Ability staticability = new Ability(
                    "static",
                    "chance to cause paralysis when foe makes contact"
            );

            repository.saveAll(
                    List.of(blaze, staticability)
            );
        };
    }


}
