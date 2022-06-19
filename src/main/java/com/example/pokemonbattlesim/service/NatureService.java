package com.example.pokemonbattlesim.service;

import com.example.pokemonbattlesim.models.Nature;
import com.example.pokemonbattlesim.repository.NatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NatureService {

    private final NatureRepository natureRepository;

    @Autowired
    public NatureService(NatureRepository natureRepository) {
        this.natureRepository = natureRepository;
    }

    public List<Nature> getNature() {
        return natureRepository.findAll();
    }
}
