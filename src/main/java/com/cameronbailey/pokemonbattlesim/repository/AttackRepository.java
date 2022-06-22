package com.cameronbailey.pokemonbattlesim.repository;

import com.cameronbailey.pokemonbattlesim.models.Attack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttackRepository extends JpaRepository<Attack, Long> {
}
