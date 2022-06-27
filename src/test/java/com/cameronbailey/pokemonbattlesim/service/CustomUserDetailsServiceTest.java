package com.cameronbailey.pokemonbattlesim.service;

import com.cameronbailey.pokemonbattlesim.models.Team;
import com.cameronbailey.pokemonbattlesim.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomUserDetailsServiceTest {

    @Autowired
    private CustomUserDetailsService service;

    @ParameterizedTest
    @ValueSource(strings = {"CameronBradBailey@gmail.com", "CameronBradBailey1@gmail.com"})
    public void testLoadByUsername(String email) {
        UserDetails user = service.loadUserByUsername(email);
        assertThat(email).isEqualTo(user.getUsername());
    }
}
