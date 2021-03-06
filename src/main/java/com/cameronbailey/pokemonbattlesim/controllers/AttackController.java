package com.cameronbailey.pokemonbattlesim.controllers;

import com.cameronbailey.pokemonbattlesim.service.AttackService;
import com.cameronbailey.pokemonbattlesim.models.Attack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/attacks")
public class AttackController {
    private final AttackService attackService;

    @Autowired
    public AttackController(AttackService attackService) {
        this.attackService = attackService;
    }

    @GetMapping
    public List<Attack> getAttack() {
        return attackService.getAttack();
    }
}
