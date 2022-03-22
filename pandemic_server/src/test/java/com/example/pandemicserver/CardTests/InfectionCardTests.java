package com.example.pandemicserver.CardTests;

import models.cards.InfectionCard;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;


@SpringBootTest
public class InfectionCardTests {

    InfectionCard city1;

    @Before
    public void before() {
        city1 = new InfectionCard("Bogota");
    }

    @Test
    public void cardHasName() {
        assertEquals("Bogota", city1.getName());
    }
}
