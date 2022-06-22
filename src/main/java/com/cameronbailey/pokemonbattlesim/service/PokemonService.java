package com.cameronbailey.pokemonbattlesim.service;

import com.cameronbailey.pokemonbattlesim.repository.PokemonRepository;
import com.cameronbailey.pokemonbattlesim.models.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getPokemon() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> getPokemonById(Long id) {
        Optional<Pokemon> pokemon = pokemonRepository.findPokemonById(id);
        return pokemon;
    }

}
