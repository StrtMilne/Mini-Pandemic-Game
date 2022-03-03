package com.example.pandemicserver.BoardTests;

import models.board.City;
import models.board.Cube;
import models.board.players.Player;
import models.cards.PlayerCard;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class CityTests {

    City city;
    Cube cube1;
    Cube cube2;
    Cube cube3;
    Cube cube4;
    Player player;

    @Before
    public void before() {
        city = new City("London", "blue");
        cube2 = new Cube("blue");
        cube3 = new Cube("blue");
        cube4 = new Cube("blue");
        cube1 = new Cube("blue");
        player = new Player("medic");
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
        assertEquals(0, city.getCubes().size());
    }

    @Test
    public void startsWithNoPlayers() {
        assertEquals(0, city.getPlayers().size());
    }

    @Test
    public void canAddCubeToCity() {
        city.addCube(cube1);
        assertEquals(1, city.getCubes().size());
    }

    @Test
    public void canRemoveCubeFromCity() {
        city.addCube(cube1);
        city.removeCube();
        assertEquals(0, city.getCubes().size());
    }

    @Test
    public void cantAssCubeIfCubesOfColourAreThree() {
        city.addCube(cube1);
        city.addCube(cube2);
        city.addCube(cube3);
        city.addCube(cube4);
        assertEquals(3, city.getCubes().size());
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
