package com.cameronbailey.pokemonbattlesim.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.cameronbailey.pokemonbattlesim.models.User;
import com.cameronbailey.pokemonbattlesim.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();/*  */
        user.setEmail("TestTestTestTestTest@Test.com");
        user.setPassword("12345");
        user.setUsername("Flavor Blasted");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }

    @Test
    public void testFindUserByEmail() {
        User user = new User();
        user.setEmail("TestTestTestTestTest@Test.com");
        user.setPassword("12345");
        user.setUsername("Flavor Blasted");

        User savedUser = repo.save(user);
        String email = "TestTestTestTestTest@Test.com";

        User user1 = repo.findUByEmail(email);
        assertThat(user1).isNotNull();
    }
}
