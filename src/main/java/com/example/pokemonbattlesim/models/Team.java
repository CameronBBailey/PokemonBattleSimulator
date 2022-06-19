package com.example.pokemonbattlesim.models;

import javax.persistence.*;

@Entity
@Table
public class Team {

    @Id
    @SequenceGenerator(
            name = "team_sequence",
            sequenceName = "team_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "team_sequence"
    )
    private Long id;
    private String name;
    @ManyToOne
    private User user;

    public Team() {

    }
    public Team(Long id) {
        this.id = id;
    }

    public Team( Long userId, String name) {
        this.name = name;
        this.user = new User(userId);
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

    public User getUser() {
        return user;
    }

    public void setUser(Long userId) {
        this.user = new User(userId);
    }
}
