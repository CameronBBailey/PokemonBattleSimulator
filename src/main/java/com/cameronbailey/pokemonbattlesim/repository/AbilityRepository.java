package com.cameronbailey.pokemonbattlesim.repository;

import com.cameronbailey.pokemonbattlesim.models.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepository extends JpaRepository<Ability, Long> {
}
