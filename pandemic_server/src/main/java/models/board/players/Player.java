package models.board.players;

import models.board.City;
import models.board.trackers.CureMarkers;
import models.cards.CityCard;
import models.cards.PlayerCard;
import java.util.ArrayList;

public class Player {

    private final String name;
    private City city;
    private ArrayList<PlayerCard> cards;

    public Player(String name) {
        this.name = name;
        this.city = null;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ArrayList<PlayerCard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<PlayerCard> cards) {
        this.cards = cards;
    }

    public void addCardToHand(PlayerCard card) {
        this.cards.add(card);
    }

}
