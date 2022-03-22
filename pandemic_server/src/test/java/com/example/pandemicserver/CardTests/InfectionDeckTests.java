package com.example.pandemicserver.CardTests;

import models.cards.InfectionDeck;
import models.cities.BaseGameCities;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class InfectionDeckTests {

    InfectionDeck infectionDeck;
    BaseGameCities cities;

    @Before
    public void before() {
        cities = new BaseGameCities();
        infectionDeck = new InfectionDeck(cities);
    }

    @Test
    public void startsWithEmptyArrayForCards() {
        assertEquals(0, infectionDeck.getInfectionCards().size());
    }

    @Test
    public void startsWithEmptyArrayForDiscardPile() {
        assertEquals(0, infectionDeck.getDiscardPile().size());
    }

    @Test
    public void canPopulateDeck() {
        infectionDeck.populate();
        assertEquals(5, infectionDeck.getInfectionCards().size());
    }

}
