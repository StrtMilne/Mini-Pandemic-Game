package models.cards;

import models.cities.Cities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PlayerDeck {

    private ArrayList<PlayerCard> playerCards;
    private ArrayList<PlayerCard> discardPile;
    private ArrayList<HashMap<String, String>> cities;
    private int epidemicCards;

    public PlayerDeck(Cities cities, int epidemicCards) {
        this.playerCards = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        this.cities = cities.passCities();
        this.epidemicCards = epidemicCards;
    }

    public ArrayList<PlayerCard> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(ArrayList<PlayerCard> playerCards) {
        this.playerCards = playerCards;
    }

    public ArrayList<PlayerCard> getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(ArrayList<PlayerCard> discardPile) {
        this.discardPile = discardPile;
    }

    public ArrayList<HashMap<String, String>> getCities() {
        return cities;
    }

    public void setCities(ArrayList<HashMap<String, String>> cities) {
        this.cities = cities;
    }

    public void populate() {
        for(int i = 0; i < cities.size(); i++){
            HashMap<String, String> newCity = cities.get(i);
            String name = newCity.get("name");
            String colour = newCity.get("colour");
            double population = Double.parseDouble(newCity.get("population"));
            CityCard newCard = new CityCard(name, population, colour);
            this.playerCards.add(newCard);
        }
    }

    public void shuffle() {
        Collections.shuffle(this.playerCards);
    }

}
