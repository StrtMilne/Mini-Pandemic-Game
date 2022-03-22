package com.example.pandemicserver.BoardTests;

import models.cities.BaseGameCities;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class CitiesTests {

    BaseGameCities cities;

    @Before
    public void before() {
        cities = new BaseGameCities();
    };

    @Test
    public void BaseGameCitiesHasEmptyArrayListToStart() {
        assertEquals(0, cities.getCities().size());
    }

    //Following test will need updated as BaseGameCities class is filled out
    @Test
    public void BaseGameCitiesCanPassListOfHashMaps() {
        assertEquals(4, cities.passCities().size());
    }

    @Test
    public void BaseGameCitiesHaveThreeKeyValuePairs() {
        HashMap<String, String> city = (HashMap<String, String>) cities.passCities().get(0);
        assertEquals(3, city.size());
    }

    @Test
    public void BaseGameCitiesHaveKeysOfColourNameAndPopulation() {
        HashMap<String, String> city = (HashMap<String, String>) cities.passCities().get(0);
        assertEquals(true, city.containsKey("name"));
        assertEquals(true, city.containsKey("colour"));
        assertEquals(true, city.containsKey("population"));
    }


}
