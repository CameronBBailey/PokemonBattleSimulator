package com.cameronbailey.pokemonbattlesim.service;

import com.cameronbailey.pokemonbattlesim.models.Attack;
import com.cameronbailey.pokemonbattlesim.repository.AttackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttackService {

    private final AttackRepository attackRepository;

    @Autowired
    public AttackService(AttackRepository attackRepository) {
        this.attackRepository = attackRepository;
    }
    public List<Attack> getAttack() {
        return attackRepository.findAll();
    }
}
