package models.cards;

public class EventCard implements PlayerCard{

    private final String name;

    public EventCard(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
