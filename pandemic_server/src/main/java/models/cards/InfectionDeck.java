package models.cards;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class InfectionDeck {

    private ArrayList<InfectionCard> infectionCards;
    private ArrayList<InfectionCard> discardPile;

    public InfectionDeck() {
        this.infectionCards = new ArrayList<>();
        this.discardPile = new ArrayList<>();
    }

    public ArrayList<InfectionCard> getInfectionCards() {
        return infectionCards;
    }

    public void setInfectionCards(ArrayList<InfectionCard> infectionCards) {
        this.infectionCards = infectionCards;
    }

    public ArrayList<InfectionCard> getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(ArrayList<InfectionCard> discardPile) {
        this.discardPile = discardPile;
    }

    public void populate() {
    }
}
