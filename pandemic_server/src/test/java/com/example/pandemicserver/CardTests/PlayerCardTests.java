package com.example.pandemicserver.CardTests;

import models.cards.CityCard;
import models.cards.EventCard;
import models.cards.PlayerCard;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class PlayerCardTests {

    CityCard card1;
    EventCard eventCard1;

    @Before
    public void before() {
        card1 = new CityCard("Bogota", 7.1);
        eventCard1 = new EventCard("Airlift");
    }

    @Test
    public void playerCardHasName() {
        assertEquals("Bogota", card1.getName());
        assertEquals("Airlift", eventCard1.getName());
    }
}
