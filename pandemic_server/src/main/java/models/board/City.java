package models.board;

import models.board.players.Player;

import java.util.ArrayList;
import java.util.List;

public class City {

    private final String name;
    private final String colour;
    private boolean ResearchCentre;
    private List<Cube> cubes;
    private List<Player> players;

    public City(String name, String colour) {
        this.name = name;
        this.colour = colour;
        this.ResearchCentre = false;
        this.cubes = new ArrayList();
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

    public List<Cube> getCubes() {
        return cubes;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setHasResearchCentre(boolean hasResearchCentre) {
        this.ResearchCentre = hasResearchCentre;
    }

    public void setCubes(List<Cube> cubes) {
        this.cubes = cubes;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addCube(Cube cube) {
        if (cubes.size() < 3) {
            this.cubes.add(cube);
        } else {

        }

    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}
