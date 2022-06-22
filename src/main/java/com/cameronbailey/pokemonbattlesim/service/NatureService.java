package com.cameronbailey.pokemonbattlesim.service;

import com.cameronbailey.pokemonbattlesim.repository.NatureRepository;
import com.cameronbailey.pokemonbattlesim.models.Nature;
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
