package com.example.pokemonbattlesim.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Item {

    @Id
    private Long id;
    private String name;
    private String Description;


    public Item() {

    }

    public Item(Long id) {
        this.id = id;
    }

    public Item(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        Description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
