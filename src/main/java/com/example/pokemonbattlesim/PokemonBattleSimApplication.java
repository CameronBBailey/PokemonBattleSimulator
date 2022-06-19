package com.example.pokemonbattlesim;

import com.example.pokemonbattlesim.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class PokemonBattleSimApplication  {

    public static void main(String[] args) {
        SpringApplication.run(PokemonBattleSimApplication.class, args);
    }

}




