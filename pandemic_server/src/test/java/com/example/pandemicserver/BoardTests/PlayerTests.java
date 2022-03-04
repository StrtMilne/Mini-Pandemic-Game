package com.example.pandemicserver.BoardTests;

import models.board.City;
import models.board.players.Player;
import models.board.trackers.CureMarkers;
import models.cards.CityCard;
import models.cards.PlayerCard;
import models.rules.BaseRules;
import models.rules.playerActions.PlayerActions;
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
    PlayerCard card6;
    CureMarkers cureMarkers;
    PlayerActions playerActions;
    BaseRules baseRules;

    @Before
    public void before() {
        playerActions = new PlayerActions();
        baseRules = new BaseRules();
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
        card6 = new CityCard("Atlanta", 9, "blue");
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
        playerActions.driveFerry(player, city2);
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
        playerActions.directFlight(player, city3);
        assertEquals("Seoul", player.getCity().getName());
        assertEquals(0, player.getCards().size());
    }

    @Test
    public void playerCantDirectFlightToNewCityWithoutCorrectCard() {
        player.setCity(city1);
        player.addCardToHand(card1);
        playerActions.directFlight(player, city3);
        assertEquals("London", player.getCity().getName());
        assertEquals(1, player.getCards().size());
    }

    @Test
    public void canCharterFlightToNewCity() {
        player.setCity(city1);
        player.addCardToHand(card1);
        playerActions.charterFlight(player, city3);
        assertEquals("Seoul", player.getCity().getName());
        assertEquals(0, player.getCards().size());
    }

    @Test
    public void cantCharterFlightToNewCityWithoutCorrectCard() {
        player.setCity(city1);
        player.addCardToHand(card2);
        playerActions.charterFlight(player, city3);
        assertEquals("London", player.getCity().getName());
        assertEquals(1, player.getCards().size());
    }

    @Test
    public void canShuttleFlightToNewCity() {
        player.setCity(city1);
        city1.setHasResearchCentre(true);
        city3.setHasResearchCentre(true);
        playerActions.shuttleFlight(player, player.getCity(), city3);
        assertEquals("Seoul", player.getCity().getName());
    }

    @Test
    public void cantShuttleFlightToNewCityIfStartHasNoResearchCentre() {
        player.setCity(city1);
        city3.setHasResearchCentre(true);
        playerActions.shuttleFlight(player, player.getCity(), city3);
        assertEquals("London", player.getCity().getName());
    }

    @Test
    public void cantShuttleFlightToNewCityIfEndHasNoResearchCentre() {
        player.setCity(city1);
        city1.setHasResearchCentre(true);
        playerActions.shuttleFlight(player, player.getCity(), city3);
        assertEquals("London", player.getCity().getName());
    }

    @Test
    public void cantShuttleFlightToNewCityINeitherHasResearchCentre() {
        player.setCity(city1);
        playerActions.shuttleFlight(player, player.getCity(), city3);
        assertEquals("London", player.getCity().getName());
    }

    @Test
    public void canTreatCity() {
        player.setCity(city1);
        baseRules.placeCube(city1, "blue");
        playerActions.treat(player,"blue");
        int result = city1.getCubes().get("blue");
        assertEquals(0, result);
    }

    @Test
    public void canCureColour() {
        player.addCardToHand(card1);
        player.addCardToHand(card3);
        player.addCardToHand(card4);
        player.addCardToHand(card5);
        player.addCardToHand(card6);
        playerActions.cure(player,"blue", cureMarkers);
        assertEquals(true, cureMarkers.isBlueCured());
    }

    @Test
    public void cantCureColourWithInsufficientCard() {
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        player.addCardToHand(card4);
        player.addCardToHand(card5);
        playerActions.cure(player,"blue", cureMarkers);
        assertEquals(false, cureMarkers.isBlueCured());
    }

    @Test
    public void cantCureColourWithNoCards() {
        playerActions.cure(player,"blue", cureMarkers);
        assertEquals(false, cureMarkers.isBlueCured());
    }

    @Test
    public void canShareKnowledge() {
        player.setCity(city1);
        player.addCardToHand(card1);
        player2.setCity(city1);
        playerActions.shareKnowledge(player, player2, (CityCard) card1);
        assertEquals(0, player.getCards().size());
        assertEquals(1, player2.getCards().size());
    }

    @Test
    public void cantShareKnowledgeIfPLayerINWrongCity() {
        player.setCity(city2);
        player.addCardToHand(card1);
        player2.setCity(city1);
        playerActions.shareKnowledge(player, player2, (CityCard) card1);
        assertEquals(1, player.getCards().size());
        assertEquals(0, player2.getCards().size());
    }

    @Test
    public void cantShareKnowledgeIfOtherPLayerINWrongCity() {
        player.setCity(city1);
        player.addCardToHand(card1);
        player2.setCity(city2);
        playerActions.shareKnowledge(player, player2, (CityCard) card1);
        assertEquals(1, player.getCards().size());
        assertEquals(0, player2.getCards().size());
    }

    @Test
    public void cantShareKnowledgeIfWrongCard() {
        player.setCity(city1);
        player.addCardToHand(card2);
        player2.setCity(city1);
        playerActions.shareKnowledge(player, player2, (CityCard) card2);
        assertEquals(1, player.getCards().size());
        assertEquals(0, player2.getCards().size());
    }

}
