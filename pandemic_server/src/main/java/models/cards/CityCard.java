package models.cards;

public class CityCard implements PlayerCard {

    private String name;
    private double population;

    public CityCard(String name, double population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public double getPopulation() {
        return population;
    }
}
