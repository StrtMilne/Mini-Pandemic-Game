package com.example.pandemicserver.BoardTests;

import models.board.City;
import models.board.Cube;
import models.board.players.Player;
import models.board.trackers.CureMarkers;
import models.cards.CityCard;
import models.cards.PlayerCard;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class PlayerTests {

    Player player;
    Player player2;
    City city1;
    City city2;
    City city3;
    PlayerCard card1;
    PlayerCard card2;
    PlayerCard card3;
    PlayerCard card4;
    PlayerCard card5;
    Cube cube1;
    Cube cube2;
    CureMarkers cureMarkers;

    @Before
    public void before() {
        player = new Player("medic");
        player2 = new Player("ops expert");
        city1 = new City("London", "blue");
        city2 = new City("Paris", "blue");
        city3 = new City("Seoul", "red");
        card1 = new CityCard("London", 9, "blue");
        card2 = new CityCard("Seoul", 12, "red");
        card3 = new CityCard("Paris", 9, "blue");
        card4 = new CityCard("Madrid", 9, "blue");
        card5 = new CityCard("Essen", 9, "blue");
        cube1 = new Cube("blue");
        cube2 = new Cube("blue");
        cureMarkers = new CureMarkers();
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

    @Test
    public void canTreatCity() {
        player.setCity(city1);
        city1.addCube("blue");
        player.treat("blue");
        int result = city1.getCubes().get("blue");
        assertEquals(0, result);
    }

    @Test
    public void canCureColour() {
        player.addCardToHand(card1);
        player.addCardToHand(card3);
        player.addCardToHand(card4);
        player.addCardToHand(card5);
        player.cure("blue", cureMarkers);
        assertEquals(true, cureMarkers.isBlueCured());
    }

    @Test
    public void cantCureColourWithInsufficientCard() {
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        player.addCardToHand(card4);
        player.addCardToHand(card5);
        player.cure("blue", cureMarkers);
        assertEquals(false, cureMarkers.isBlueCured());
    }

    @Test
    public void cantCureColourWithNoCards() {
        player.cure("blue", cureMarkers);
        assertEquals(false, cureMarkers.isBlueCured());
    }

    @Test
    public void canShareKnowledge() {
        player.setCity(city1);
        player.addCardToHand(card1);
        player2.setCity(city1);
        player.shareKnowledge(player2, (CityCard) card1);
        assertEquals(0, player.getCards().size());
        assertEquals(1, player2.getCards().size());
    }

    @Test
    public void cantShareKnowledgeIfPLayerINWrongCity() {
        player.setCity(city2);
        player.addCardToHand(card1);
        player2.setCity(city1);
        player.shareKnowledge(player2, (CityCard) card1);
        assertEquals(1, player.getCards().size());
        assertEquals(0, player2.getCards().size());
    }

    @Test
    public void cantShareKnowledgeIfOtherPLayerINWrongCity() {
        player.setCity(city1);
        player.addCardToHand(card1);
        player2.setCity(city2);
        player.shareKnowledge(player2, (CityCard) card1);
        assertEquals(1, player.getCards().size());
        assertEquals(0, player2.getCards().size());
    }

    @Test
    public void cantShareKnowledgeIfWrongCard() {
        player.setCity(city1);
        player.addCardToHand(card2);
        player2.setCity(city1);
        player.shareKnowledge(player2, (CityCard) card2);
        assertEquals(1, player.getCards().size());
        assertEquals(0, player2.getCards().size());
    }

}
