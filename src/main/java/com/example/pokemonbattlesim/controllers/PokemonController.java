package com.example.pokemonbattlesim.controllers;


import com.example.pokemonbattlesim.models.Pokemon;
import com.example.pokemonbattlesim.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getPokemon() {
        return pokemonService.getPokemon();
    }

    @GetMapping(path = "{pokemonId}")
    public Optional<Pokemon> getPokemonById(@PathVariable("pokemonId") Long pokemonId) {
        return pokemonService.getPokemonById(pokemonId);
    }


}

