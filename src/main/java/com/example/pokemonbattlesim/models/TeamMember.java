package com.example.pokemonbattlesim.models;

import javax.persistence.*;

@Entity
@Table
public class TeamMember {
    @Id
    @SequenceGenerator(
            name = "member_sequence",
            sequenceName = "member_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_sequence"
    )
    private Long id;
    @ManyToOne
    private Team team;

    @ManyToOne
    private Pokemon pokemon;
    @ManyToOne
    private Item item;
    @ManyToOne
    private Ability ability;
    @ManyToOne
    private Nature nature;

    @ManyToOne
    private Attack attack1;
    @ManyToOne
    private Attack attack2;
    @ManyToOne
    private Attack attack3;
    @ManyToOne
    private Attack attack4;

    private Long hpEv;
    private Long attackEv;
    private Long defenseEv;
    private Long spAttackEv;
    private Long spDefenseEv;
    private Long speedEv;

    private Long hpIv;
    private Long attackIv;
    private Long defenseIv;
    private Long spAttackIv;
    private Long spDefenseIv;
    private Long speedIv;

    public TeamMember() {

    }

    public TeamMember(Long teamId, Long pokemonId, Long itemId, String abilityName, String natureName, Long attackId1,Long attackId2, Long attackId3, Long attackId4, Long hpEv, Long attackEv, Long defenseEv, Long spAttackEv, Long spDefenseEv, Long speedEv, Long hpIv, Long attackIv, Long defenseIv, Long spAttackIv, Long spDefenseIv, Long speedIv) {
        this.team = new Team(teamId);
        this.pokemon = new Pokemon(pokemonId);
        this.item = new Item(itemId);
        this.ability = new Ability(abilityName);
        this.nature = new Nature(natureName);
        this.attack1 = new Attack(attackId1);
        this.attack2 = new Attack(attackId2);
        this.attack3 = new Attack(attackId3);
        this.attack4 = new Attack(attackId4);
        this.hpEv = hpEv;
        this.attackEv = attackEv;
        this.defenseEv = defenseEv;
        this.spAttackEv = spAttackEv;
        this.spDefenseEv = spDefenseEv;
        this.speedEv = speedEv;
        this.hpIv = hpIv;
        this.attackIv = attackIv;
        this.defenseIv = defenseIv;
        this.spAttackIv = spAttackIv;
        this.spDefenseIv = spDefenseIv;
        this.speedIv = speedIv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Long teamId) {
        this.team = new Team(teamId);
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Long itemId) {
        this.item = new Item(itemId);
    }

    public Ability getAbilityId() {
        return ability;
    }

    public void setAbilityId(String abilityId) {
        this.ability = new Ability(abilityId);
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(String natureName) {
        this.nature = new Nature(natureName);
    }

    public Long getHpEv() {
        return hpEv;
    }

    public void setHpEv(Long hpEv) {
        this.hpEv = hpEv;
    }

    public Long getAttackEv() {
        return attackEv;
    }

    public void setAttackEv(Long attackEv) {
        this.attackEv = attackEv;
    }

    public Long getDefenseEv() {
        return defenseEv;
    }

    public void setDefenseEv(Long defenseEv) {
        this.defenseEv = defenseEv;
    }

    public Long getSpAttackEv() {
        return spAttackEv;
    }

    public void setSpAttackEv(Long spAttackEv) {
        this.spAttackEv = spAttackEv;
    }

    public Long getSpDefenseEv() {
        return spDefenseEv;
    }

    public void setSpDefenseEv(Long spDefenseEv) {
        this.spDefenseEv = spDefenseEv;
    }

    public Long getSpeedEv() {
        return speedEv;
    }

    public void setSpeedEv(Long speedEv) {
        this.speedEv = speedEv;
    }

    public Long getHpIv() {
        return hpIv;
    }

    public void setHpIv(Long hpIv) {
        this.hpIv = hpIv;
    }

    public Long getAttackIv() {
        return attackIv;
    }

    public void setAttackIv(Long attackIv) {
        this.attackIv = attackIv;
    }

    public Long getDefenseIv() {
        return defenseIv;
    }

    public void setDefenseIv(Long defenseIv) {
        this.defenseIv = defenseIv;
    }

    public Long getSpAttackIv() {
        return spAttackIv;
    }

    public void setSpAttackIv(Long spAttackIv) {
        this.spAttackIv = spAttackIv;
    }

    public Long getSpDefenseIv() {
        return spDefenseIv;
    }

    public void setSpDefenseIv(Long spDefenseIv) {
        this.spDefenseIv = spDefenseIv;
    }

    public Long getSpeedIv() {
        return speedIv;
    }

    public void setSpeedIv(Long speedIv) {
        this.speedIv = speedIv;
    }

    public Attack getAttack1() {
        return attack1;
    }

    public void setAttack1(Attack attack1) {
        this.attack1 = attack1;
    }

    public Attack getAttack2() {
        return attack2;
    }

    public void setAttack2(Attack attack2) {
        this.attack2 = attack2;
    }

    public Attack getAttack3() {
        return attack3;
    }

    public void setAttack3(Attack attack3) {
        this.attack3 = attack3;
    }

    public Attack getAttack4() {
        return attack4;
    }

    public void setAttack4(Attack attack4) {
        this.attack4 = attack4;
    }
}