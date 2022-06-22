package com.cameronbailey.pokemonbattlesim.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Nature {

    @Id
    private String name;
    private String boon;
    private String bane;

    public Nature() {

    }

    public Nature(String name) {
        this.name = name;
    }

    public Nature(String name, String boon, String bane) {
        this.name = name;
        this.boon = boon;
        this.bane = bane;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBoon() {
        return boon;
    }

    public void setBoon(String boon) {
        this.boon = boon;
    }

    public String getBane() {
        return bane;
    }

    public void setBane(String bane) {
        this.bane = bane;
    }
}
