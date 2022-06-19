package com.example.pokemonbattlesim.repository;

import com.example.pokemonbattlesim.models.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepository extends JpaRepository<Ability, Long> {
}
