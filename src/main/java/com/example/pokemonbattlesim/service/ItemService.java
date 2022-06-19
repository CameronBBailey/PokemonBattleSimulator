package com.example.pokemonbattlesim.service;

import com.example.pokemonbattlesim.models.Item;
import com.example.pokemonbattlesim.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItem() {
        return itemRepository.findAll();
    }

}
