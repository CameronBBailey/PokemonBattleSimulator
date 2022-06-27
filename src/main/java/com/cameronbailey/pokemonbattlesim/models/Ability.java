package com.cameronbailey.pokemonbattlesim.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Ability {
    @Id
    private String name;
    private String Description;

    public Ability() {

    }

    public Ability(String name) {
        this.name = name;
    }
    public Ability(String name, String description) {
        this.name = name;
        Description = description;
    }

    /* Getters and Setters */
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
