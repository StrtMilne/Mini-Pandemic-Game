package models.cards;

public class EpidemicCard implements PlayerCard{

    final String name;

    public EpidemicCard() {
        this.name = "Epidemic";
    }

    public String getName() {
        return name;
    }
}
