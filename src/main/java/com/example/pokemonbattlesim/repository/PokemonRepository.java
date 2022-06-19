package com.example.pokemonbattlesim.repository;

import com.example.pokemonbattlesim.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon,Long> {
    Optional<Pokemon> findPokemonById(Long id);
}
