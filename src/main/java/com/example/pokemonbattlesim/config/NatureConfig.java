package com.example.pokemonbattlesim.config;

import com.example.pokemonbattlesim.models.Nature;
import com.example.pokemonbattlesim.repository.NatureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class NatureConfig {
    @Bean
    CommandLineRunner commandLineRunnerNature(NatureRepository repository) {
        return args -> {
            Nature bold = new Nature(
                    "bold",
                    "defense",
                    "attack"
            );
            Nature jolly = new Nature(
                        "jolly",
                        "speed",
                        "spAttack"
                );

            repository.saveAll(
                    List.of(
                            bold,jolly
                    )
            );
        };
    }
}
