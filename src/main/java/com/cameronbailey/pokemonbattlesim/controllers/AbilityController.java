package com.cameronbailey.pokemonbattlesim.controllers;

import com.cameronbailey.pokemonbattlesim.models.Ability;
import com.cameronbailey.pokemonbattlesim.service.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/ability")
public class AbilityController {

    private final AbilityService abilityService;

    @Autowired
    public AbilityController(AbilityService abilityService) {
        this.abilityService = abilityService;
    }

    @GetMapping
    public List<Ability> getAbility() {
        return abilityService.getAbility();
    }
}
