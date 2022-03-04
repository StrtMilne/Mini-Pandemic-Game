package models.rules;

import models.board.City;

import java.util.HashMap;

public class BaseRules {

    public void placeCube(City city, String colour) {
        HashMap<String, Integer> cubes = city.getCubes();
        if (cubes.get(colour) < 3) {
            cubes.put(colour, cubes.get(colour) + 1);
        } else {
            // For outbreaks
        }
    }
}
