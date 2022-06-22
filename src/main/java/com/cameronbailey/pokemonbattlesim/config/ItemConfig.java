package com.cameronbailey.pokemonbattlesim.config;

import com.cameronbailey.pokemonbattlesim.models.Item;
import com.cameronbailey.pokemonbattlesim.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner commandLineRunneritem(ItemRepository repository) {
        return args -> {
            Item leftovers = new Item(
                    1L,
                    "Leftovers",
                    "Recovers 1/16th of the users Hp at the end of the turn"
            );
            Item choiceband = new Item(
                    2L,
                    "Choice Band",
                    "Increases users attack by 50% but locks them into the first move used"
            );

            repository.saveAll(
                    List.of(leftovers, choiceband)
            );
        };
    }
}
