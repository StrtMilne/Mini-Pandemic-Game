package models.cards;

import models.cities.Cities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class InfectionDeck {

    private ArrayList<InfectionCard> infectionCards;
    private ArrayList<InfectionCard> discardPile;
    private ArrayList<HashMap<String, String>> cities;

    public InfectionDeck(Cities cities) {
        this.infectionCards = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        this.cities = cities.passCities();
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
        for(int i = 0; i < cities.size(); i++){
            HashMap<String, String> newCity = cities.get(i);
            InfectionCard newCard = new InfectionCard(newCity.get("name"));
            this.infectionCards.add(newCard);
        }
    }

    public void shuffle() {
        Collections.shuffle(this.infectionCards);
    }

}
