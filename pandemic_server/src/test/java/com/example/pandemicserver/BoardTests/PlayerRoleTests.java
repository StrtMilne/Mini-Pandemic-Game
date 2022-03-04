package com.example.pandemicserver.BoardTests;

import models.board.City;
import models.board.players.Player;
import models.board.trackers.CureMarkers;
import models.cards.CityCard;
import models.rules.playerActions.MedicActions;
import models.rules.playerActions.ScientistActions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class PlayerRoleTests {

    Player player;
    City city1;
    City city2;
    CityCard card1;
    CityCard card2;
    CityCard card3;
    CityCard card4;
    CureMarkers cureMarkers;
    MedicActions medicActions;
    ScientistActions scientistActions;

    @Before
    public void before() {
        player = new Player("medic");
        city1 = new City("London", "blue");
        city2 = new City("Paris", "blue");
        card1 = new CityCard("Paris", 8, "blue");
        card2 = new CityCard("London", 9, "blue");
        card3 = new CityCard("Essen", 6, "blue");
        card4 = new CityCard("Madrid", 5, "blue");
        cureMarkers = new CureMarkers();
        medicActions = new MedicActions(cureMarkers);
        scientistActions = new ScientistActions();
    }

    @Test
    public void medicCanClearAllCubesOfOneColour() {
        city1.getCubes().put("blue", 3);
        player.setCity(city1);
        medicActions.treat(player, "blue");
        int result = city1.getCubes().get("blue");
        assertEquals(0, result);
    }

    @Test
    public void medicCanAutoClearCityIfCured() {
        player.setCity(city1);
        city2.setCubesOfColour("blue", 2);
        cureMarkers.setCured("blue");
        medicActions.driveFerry(player, city2);
        int result = city2.getCubes().get("blue");
        assertEquals(player.getCity(), city2);
        assertEquals(0, result);
    }

    @Test
    public void medicOnlyAutoClearsCityIfCured() {
        player.setCity(city1);
        city2.setCubesOfColour("blue", 2);
        medicActions.driveFerry(player, city2);
        int result = city2.getCubes().get("blue");
        assertEquals(player.getCity(), city2);
        assertEquals(2, result);
    }

    @Test
    public void medicOnlyAutoClearsCubesOfCuredColour() {
        player.setCity(city1);
        city2.setCubesOfColour("blue", 2);
        city2.setCubesOfColour("yellow", 2);
        cureMarkers.setCured("yellow");
        medicActions.driveFerry(player, city2);
        int result1 = city2.getCubes().get("blue");
        int result2 = city2.getCubes().get("yellow");
        assertEquals(player.getCity(), city2);
        assertEquals(2, result1);
        assertEquals(0, result2);
    }

    @Test
    public void medicCanAutoClearCityIfCuredOnDirectFlight() {
        player.setCity(city1);
        player.addCardToHand(card1);
        city2.setCubesOfColour("blue", 2);
        cureMarkers.setCured("blue");
        medicActions.directFlight(player, city2);
        int result = city2.getCubes().get("blue");
        assertEquals(player.getCity(), city2);
        assertEquals(0, result);
    }

    @Test
    public void medicOnlyAutoClearsCityIfCuredOnDirectFLight() {
        player.setCity(city1);
        player.addCardToHand(card1);
        city2.setCubesOfColour("blue", 2);
        medicActions.directFlight(player, city2);
        int result = city2.getCubes().get("blue");
        assertEquals(player.getCity(), city2);
        assertEquals(2, result);
    }

    @Test
    public void medicOnlyAutoClearsCubesOfCuredColourOnDirectFlight() {
        player.setCity(city1);
        player.addCardToHand(card1);
        city2.setCubesOfColour("blue", 2);
        city2.setCubesOfColour("yellow", 2);
        cureMarkers.setCured("yellow");
        medicActions.directFlight(player, city2);
        int result1 = city2.getCubes().get("blue");
        int result2 = city2.getCubes().get("yellow");
        assertEquals(player.getCity(), city2);
        assertEquals(2, result1);
        assertEquals(0, result2);
    }

    @Test
    public void medicCanAutoClearCityIfCuredOnCharterFlight() {
        player.setCity(city2);
        player.addCardToHand(card1);
        city1.setCubesOfColour("blue", 2);
        cureMarkers.setCured("blue");
        medicActions.charterFlight(player, city1);
        int result = city1.getCubes().get("blue");
        assertEquals(player.getCity(), city1);
        assertEquals(0, result);
    }

    @Test
    public void medicOnlyAutoClearsCityIfCuredOnCharterFLight() {
        player.setCity(city2);
        player.addCardToHand(card1);
        city1.setCubesOfColour("blue", 2);
        medicActions.charterFlight(player, city1);
        int result = city1.getCubes().get("blue");
        assertEquals(player.getCity(), city1);
        assertEquals(2, result);
    }

    @Test
    public void medicOnlyAutoClearsCubesOfCuredColourOnCharterFlight() {
        player.setCity(city2);
        player.addCardToHand(card1);
        city1.setCubesOfColour("blue", 2);
        city1.setCubesOfColour("yellow", 2);
        cureMarkers.setCured("yellow");
        medicActions.charterFlight(player, city1);
        int result1 = city1.getCubes().get("blue");
        int result2 = city1.getCubes().get("yellow");
        assertEquals(player.getCity(), city1);
        assertEquals(2, result1);
        assertEquals(0, result2);
    }

    @Test
    public void scientistCanCureWithFourCards() {
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        player.addCardToHand(card3);
        player.addCardToHand(card4);
        scientistActions.cure(player, "blue", cureMarkers);
        assertEquals(true, cureMarkers.isBlueCured());
    }

    @Test
    public void scientistCantCureWithThreeCards() {
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        player.addCardToHand(card3);
        scientistActions.cure(player, "blue", cureMarkers);
        assertEquals(false, cureMarkers.isBlueCured());
    }

}
