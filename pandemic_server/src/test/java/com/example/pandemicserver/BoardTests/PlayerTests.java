package com.example.pandemicserver.BoardTests;

import models.board.City;
import models.board.players.Player;
import models.cards.CityCard;
import models.cards.PlayerCard;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class PlayerTests {

    Player player;
    City city1;
    City city2;
    City city3;
    PlayerCard card1;
    PlayerCard card2;

    @Before
    public void before() {
        player = new Player("medic");
        city1 = new City("London", "blue");
        city2 = new City("Paris", "blue");
        city3 = new City("Seoul", "red");
        card1 = new CityCard("London", 9, "blue");
        card2 = new CityCard("Seoul", 12, "red");
    }

    @Test
    public void playerHasName() {
        assertEquals("medic", player.getName());
    }

    @Test
    public void playerStartsInNoCity() {
        assertEquals(null, player.getCity());
    }

    @Test
    public void playerCanSetCity() {
        player.setCity(city1);
        assertEquals("London", player.getCity().getName());
    }

    @Test
    public void playerCanDriveToNewCity() {
        player.setCity(city1);
        player.driveFerry(city2);
        assertEquals("Paris", player.getCity().getName());
    }

    @Test
    public void playerStartsWithNoCards() {
        assertEquals(0, player.getCards().size());
    }

    @Test
    public void playerCanAddCardToHand() {
        player.addCardToHand(card1);
        assertEquals(1, player.getCards().size());
    }

    @Test
    public void playerCanDirectFlightToNewCity() {
        player.setCity(city1);
        player.addCardToHand(card2);
        player.directFlight(city3);
        assertEquals("Seoul", player.getCity().getName());
        assertEquals(0, player.getCards().size());
    }

    @Test
    public void playerCantDirectFlightToNewCityWithoutCorrectCard() {
        player.setCity(city1);
        player.addCardToHand(card1);
        player.directFlight(city3);
        assertEquals("London", player.getCity().getName());
        assertEquals(1, player.getCards().size());
    }

    @Test
    public void canCharterFlightToNewCity() {
        player.setCity(city1);
        player.addCardToHand(card1);
        player.charterFlight(city3);
        assertEquals("Seoul", player.getCity().getName());
        assertEquals(0, player.getCards().size());
    }

    @Test
    public void cantCharterFlightToNewCityWithoutCorrectCard() {
        player.setCity(city1);
        player.addCardToHand(card2);
        player.charterFlight(city3);
        assertEquals("London", player.getCity().getName());
        assertEquals(1, player.getCards().size());
    }

    @Test
    public void canShuttleFlightToNewCity() {
        player.setCity(city1);
        city1.setHasResearchCentre(true);
        city3.setHasResearchCentre(true);
        player.shuttleFlight(player.getCity(), city3);
        assertEquals("Seoul", player.getCity().getName());
    }

    @Test
    public void cantShuttleFlightToNewCityIfStartHasNoResearchCentre() {
        player.setCity(city1);
        city3.setHasResearchCentre(true);
        player.shuttleFlight(player.getCity(), city3);
        assertEquals("London", player.getCity().getName());
    }

    @Test
    public void cantShuttleFlightToNewCityIfEndHasNoResearchCentre() {
        player.setCity(city1);
        city1.setHasResearchCentre(true);
        player.shuttleFlight(player.getCity(), city3);
        assertEquals("London", player.getCity().getName());
    }

    @Test
    public void cantShuttleFlightToNewCityINeitherHasResearchCentre() {
        player.setCity(city1);
        player.shuttleFlight(player.getCity(), city3);
        assertEquals("London", player.getCity().getName());
    }

}
