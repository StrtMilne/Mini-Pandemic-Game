package models.board;

import models.board.players.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class City {

    private final String name;
    private final String colour;
    private boolean ResearchCentre;
    private HashMap<String, Integer> cubes;
    private List<Player> players;

    public City(String name, String colour) {
        this.name = name;
        this.colour = colour;
        this.ResearchCentre = false;
        this.cubes = new HashMap<>();
        cubes.put("blue", 0);
        cubes.put("yellow", 0);
        cubes.put("black", 0);
        cubes.put("red", 0);
        this.players = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public boolean getResearchCentre() {
        return ResearchCentre;
    }

    public HashMap<String, Integer> getCubes() {
        return cubes;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setHasResearchCentre(boolean hasResearchCentre) {
        this.ResearchCentre = hasResearchCentre;
    }

    public void setCubes(HashMap<String, Integer> cubes) {
        this.cubes = cubes;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addCube(String colour) {
        if (cubes.get(colour) < 3) {
            cubes.put(colour, cubes.get(colour) + 1);
        } else {
            // For outbreaks
        }
    }

    public void removeCube(String colour) {
        this.cubes.put(colour, cubes.get(colour) - 1);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}
