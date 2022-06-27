package com.cameronbailey.pokemonbattlesim.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.cameronbailey.pokemonbattlesim.models.Item;
import com.cameronbailey.pokemonbattlesim.models.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class ItemServiceTest {

    @Autowired
    private ItemService service;

    @Test /* Tests getting all items */
    public void testGetItems() {
        List<Item> item = service.getItem();
        assertThat(item).isNotNull();
    }
}
