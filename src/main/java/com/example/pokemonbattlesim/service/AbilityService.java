package com.example.pokemonbattlesim.service;

import com.example.pokemonbattlesim.models.Ability;
import com.example.pokemonbattlesim.repository.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityService {

    private final AbilityRepository abilityRepository;

    @Autowired
    public AbilityService(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }

    public List<Ability> getAbility() {
        return abilityRepository.findAll();
    }

}
