package com.example.pandemicserver.CardTests;

import models.cards.InfectionDeck;
import models.cards.PlayerDeck;
import models.cities.BaseGameCities;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class PlayerDeckTests {

    PlayerDeck playerDeck;
    BaseGameCities cities;

    @Before
    public void before() {
        cities = new BaseGameCities();
        playerDeck = new PlayerDeck(cities, 4);
    }

    @Test
    public void startsWithEmptyArrayForCards() {
        assertEquals(0, playerDeck.getPlayerCards().size());
    }

    @Test
    public void startsWithEmptyArrayForDiscardPile() {
        assertEquals(0, playerDeck.getDiscardPile().size());
    }

    // Test will need to be updated as more cities are added to list;
    @Test
    public void canPopulateDeck() {
        playerDeck.populate();
        assertEquals(16, playerDeck.getPlayerCards().size());
    }

    @Test
    public void canIntersperseEpidemicCardsInPack() {

    }

}
