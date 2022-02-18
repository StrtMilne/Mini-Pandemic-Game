package com.example.pandemicserver.CardTests;

import models.cards.InfectionCard;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;


@SpringBootTest
public class InfectionCardTests {

    InfectionCard city1;
    InfectionCard epidemic1;

    @Before
    public void before() {
        city1 = new InfectionCard("Bogota", false);
        epidemic1 = new InfectionCard("Epidemic", true);
    }

    @Test
    public void cardHasName() {
        assertEquals("Bogota", city1.getName());
        assertEquals("Epidemic", epidemic1.getName());
    }

    @Test
    public void cardHadBooleanEpidemicValue() {
        assertEquals(false, city1.isEpidemic());
        assertEquals(true, epidemic1.isEpidemic());
    }
}
