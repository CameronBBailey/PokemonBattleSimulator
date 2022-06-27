package com.cameronbailey.pokemonbattlesim.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Attack {

    @Id
    private Long attackId;
    private String name;
    private String effect;
    private String type;
    private String kind;
    private Long power;
    private String accuracy;
    private Long pp;


    public Attack() {

    }
    public Attack(Long id) {
        this.attackId = id;
    }

    public Attack(Long id, String name, String effect, String type, String kind, Long power, String accuracy, Long pp) {
        this.attackId = id;
        this.name = name;
        this.effect = effect;
        this.type = type;
        this.kind = kind;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
    }

    /* Getters and Setters */
    public Long getId() {
        return attackId;
    }

    public void setId(Long id) {
        this.attackId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public Long getPp() {
        return pp;
    }

    public void setPp(Long pp) {
        this.pp = pp;
    }
}
