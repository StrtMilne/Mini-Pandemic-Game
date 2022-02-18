package models.cards;

public class CityCard implements PlayerCard {

    private final String name;
    private final double population;
    private final String colour;

    public CityCard(String name, double population, String colour) {
        this.name = name;
        this.population = population;
        this.colour = colour;
    }

    public String getName() {
        return this.name;
    }

    public double getPopulation() {
        return this.population;
    }

    public String getColour() {
        return this.colour;
    }
}
