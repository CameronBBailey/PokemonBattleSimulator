package com.cameronbailey.pokemonbattlesim.config;

import com.cameronbailey.pokemonbattlesim.models.User;
import com.cameronbailey.pokemonbattlesim.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TAUserConfig {
    @Bean
    CommandLineRunner commandLineRunner9(UserRepository repository) {
        return args -> {
            User User1 = new User(
                    "CameronBradBailey@Gmail.com",
                    "GenghisKham",
                    "12345"
            );
            User User2 = new User(
                    "Cameron2013@Gmail.com",
                    "Flyinninjakoala",
                    "12346"
            );
            repository.saveAll(
                    List.of(User1, User2)
            );
        };
    }
}
