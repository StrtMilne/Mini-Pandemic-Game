package com.example.pandemicserver.BoardTests;

import models.rules.PlayerTurn;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class PlayerTurnTests {

    PlayerTurn playerTurn;

    @Before
    public void before() {
        playerTurn = new PlayerTurn();
    }

    @Test
    public void turnStartsWithZeroCityCardsDrawn() {
        assertEquals(0, playerTurn.getCityCardsDrawn());
    }

    @Test
    public void turnStartsWithZeroPlayerCardsDrawn() {
        assertEquals(0, playerTurn.getPlayerCardsDrawn());
    }

    @Test
    public void turnStartsWithFourActionsRemaing() {
        assertEquals(0, playerTurn.getActionsRemaining());
    }
}
