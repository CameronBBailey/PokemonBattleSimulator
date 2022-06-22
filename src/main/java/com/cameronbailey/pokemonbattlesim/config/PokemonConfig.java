package com.cameronbailey.pokemonbattlesim.config;

import com.cameronbailey.pokemonbattlesim.models.Pokemon;
import com.cameronbailey.pokemonbattlesim.repository.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PokemonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PokemonRepository repository) {
        return args -> {
            Pokemon treeko = new Pokemon(
                    1L,
                    1L,
                    "treeko",
                    "grass",
                    "",
                    "overgrow",
                    "",
                    "",
                    50L,50L,50L,50L,50L,50L
            );

            Pokemon torchic = new Pokemon(
                    2L,
                    2L,
                    "torchic",
                    "fire",
                    "",
                    "blaze",
                    "",
                    "",
                    50L,50L,50L,50L,50L,50L
            );

            repository.saveAll(
                    List.of(treeko, torchic)
            );

        };
    }
}
