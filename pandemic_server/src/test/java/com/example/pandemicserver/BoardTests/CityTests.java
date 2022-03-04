package com.example.pandemicserver.BoardTests;

import models.board.City;
import models.board.players.Player;
import models.rules.BaseRules;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class CityTests {

    City city;
    Player player;
    BaseRules baseRules;

    @Before
    public void before() {
        city = new City("London", "blue");
        player = new Player("medic");
        baseRules = new BaseRules();
    }

    @Test
    public void cityHasName() {
        assertEquals("London", city.getName());
    }

    @Test
    public void cityHasColour() {
        assertEquals("blue", city.getColour());
    }

    @Test
    public void cityStartsWithNoResearchCentre() {
        assertEquals(false, city.getResearchCentre());
    }

    @Test
    public void startsWithNoCubes() {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("blue", 0);
        result.put("black", 0);
        result.put("red", 0);
        result.put("yellow", 0);
        assertEquals(result, city.getCubes());
    }

    @Test
    public void startsWithNoPlayers() {
        assertEquals(0, city.getPlayers().size());
    }

    @Test
    public void canAddCubeToCity() {
        baseRules.placeCube(city, "blue");
        int result = city.getCubes().get("blue");
        assertEquals(1, result);
    }

    @Test
    public void canRemoveCubeFromCity() {
        baseRules.placeCube(city, "blue");
        city.removeCube("blue");
        int result = city.getCubes().get("blue");
        assertEquals(0, result);
    }

    @Test
    public void cantAddCubeIfCubesOfColourAreThree() {
        baseRules.placeCube(city, "blue");
        baseRules.placeCube(city, "blue");
        baseRules.placeCube(city, "blue");
        baseRules.placeCube(city, "blue");
        int result = city.getCubes().get("blue");
        assertEquals(3, result);
    }

    @Test
    public void canBuildResearchStationInCity() {
        city.setHasResearchCentre(true);
        assertEquals(true, city.getResearchCentre());
    }

    @Test
    public void canAddPlayerToCity() {
        city.addPlayer(player);
        assertEquals(1, city.getPlayers().size());
    }

}
