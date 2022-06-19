package com.example.pokemonbattlesim.controllers;

import com.example.pokemonbattlesim.models.Nature;
import com.example.pokemonbattlesim.service.NatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/nature")
public class NatureController {

    private final NatureService natureService;
    @Autowired
    public NatureController(NatureService natureService) {
        this.natureService = natureService;
    }

    @GetMapping
    public List<Nature> getNature() {
        return natureService.getNature();
    }
}
