package com.cameronbailey.pokemonbattlesim.service;

import com.cameronbailey.pokemonbattlesim.models.Item;
import com.cameronbailey.pokemonbattlesim.repository.ItemRepository;
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
