package com.example.pokemonbattlesim.models;

import javax.persistence.*;

@Entity
@Table(name = "Pokemon")
public class Pokemon {

    @Id
    private Long id;
    @Column(nullable = false)
    private Long dexNum;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String typeOne;
    private String typeTwo;
    @Column(nullable = false)
    private String abilityOne;
    private String abilityTwo;

    private String abilityHidden;
    @Column(nullable = false)
    private Long hp;
    @Column(nullable = false)
    private Long attack;
    @Column(nullable = false)
    private Long defense;
    @Column(nullable = false)
    private Long spAtt;
    @Column(nullable = false)
    private Long spDef;
    @Column(nullable = false)
    private Long speed;

    public Pokemon() {
    }

    public Pokemon(Long id) {
        this.id = id;
    }
    public Pokemon(Long id, Long dexNum,String name, String typeOne, String typeTwo, String abilityOne, String abilityTwo, String abilityThree, Long hp, Long attack, Long defense, Long spAtt, Long spDef, Long speed) {
        this.id = id;
        this.dexNum = dexNum;
        this.name = name;
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
        this.abilityOne = abilityOne;
        this.abilityTwo = abilityTwo;
        this.abilityHidden= abilityThree;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAtt = spAtt;
        this.spDef = spDef;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", dexNum=" + dexNum +
                ", typeOne='" + typeOne + '\'' +
                ", typeTwo='" + typeTwo + '\'' +
                ", abilityOne='" + abilityOne + '\'' +
                ", abilityTwo='" + abilityTwo + '\'' +
                ", abilityThree='" + abilityHidden + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", spAtt=" + spAtt +
                ", spDef=" + spDef +
                ", speed=" + speed +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDexNum() {
        return dexNum;
    }

    public void setDexNum(Long dexNum) {
        this.dexNum = dexNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOne() {
        return typeOne;
    }

    public void setTypeOne(String typeOne) {
        this.typeOne = typeOne;
    }

    public String getTypeTwo() {
        return typeTwo;
    }

    public void setTypeTwo(String typeTwo) {
        this.typeTwo = typeTwo;
    }

    public String getAbilityOne() {
        return abilityOne;
    }

    public void setAbilityOne(String abilityOne) {
        this.abilityOne = abilityOne;
    }

    public String getAbilityTwo() {
        return abilityTwo;
    }

    public void setAbilityTwo(String abilityTwo) {
        this.abilityTwo = abilityTwo;
    }

    public String getAbilityThree() {
        return abilityHidden;
    }

    public void setAbilityThree(String abilityThree) {
        this.abilityHidden = abilityThree;
    }

    public Long getHp() {
        return hp;
    }

    public void setHp(Long hp) {
        this.hp = hp;
    }

    public Long getAttack() {
        return attack;
    }

    public void setAttack(Long attack) {
        this.attack = attack;
    }

    public Long getDefense() {
        return defense;
    }

    public void setDefense(Long defense) {
        this.defense = defense;
    }

    public Long getSpAtt() {
        return spAtt;
    }

    public void setSpAtt(Long spAtt) {
        this.spAtt = spAtt;
    }

    public Long getSpDef() {
        return spDef;
    }

    public void setSpDef(Long spDef) {
        this.spDef = spDef;
    }

    public Long getSpeed() {
        return speed;
    }

    public void setSpeed(Long speed) {
        this.speed = speed;
    }
}
