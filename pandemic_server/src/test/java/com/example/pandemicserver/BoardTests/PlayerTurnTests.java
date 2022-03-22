package com.example.pandemicserver.BoardTests;

import models.board.players.Player;
import models.rules.PlayerTurn;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class PlayerTurnTests {

    PlayerTurn playerTurn;
    Player player;


    @Before
    public void before() {
        player = new Player("medic");
        playerTurn = new PlayerTurn(player);
    }

    @Test
    public void turnHasPLayer() {
        assertEquals(player, playerTurn.getPlayer());
    }

    @Test
    public void turnStartsWithZeroCityCardsDrawn() {
        assertEquals(0, playerTurn.getCityCardsDrawn());
    }

    @Test
    public void turnStartsWithTwoPlayerCardsToDraw() {
        assertEquals(2, playerTurn.getPlayerCardsToDraw());
    }

    @Test
    public void turnStartsWithFourActionsRemaining() {
        assertEquals(4, playerTurn.getActionsRemaining());
    }

    @Test
    public void canRemoveAction() {
        playerTurn.removeAction();
        assertEquals(3, playerTurn.getActionsRemaining());
    }

    @Test
    public void canIncreasePlayerCardsDrawn() {
        playerTurn.drawCards();
        assertEquals(0, playerTurn.getPlayerCardsToDraw());
    }

}
