package com.cameronbailey.pokemonbattlesim.repository;

import com.cameronbailey.pokemonbattlesim.models.Nature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NatureRepository extends JpaRepository<Nature, Long> {

}
