package models.board.players;

import models.board.City;
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

    public void driveFerry(City nextCity) {
        this.city.getPlayers().remove(this);
        this.city = nextCity;
        nextCity.addPlayer(this);
    };

    public ArrayList<PlayerCard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<PlayerCard> cards) {
        this.cards = cards;
    }

    public void addCardToHand(PlayerCard card) {
        this.cards.add(card);
    }

    public void directFlight(City arrivalCity){
         if (this.cards.stream()
                 .filter(card -> card.getName()
                 .equals(arrivalCity.getName()))
                 .findFirst()
                 .isPresent()) {
             this.driveFerry(arrivalCity);
             this.cards.removeIf(card -> card.getName().equals(arrivalCity.getName()));
         } else {
             // Action if not possible
         }
    }


    public void charterFlight(City arrivalCity){
        if (this.cards.stream()
                .filter(card -> card.getName()
                .equals(this.city.getName()))
                .findFirst()
                .isPresent()) {
            this.cards.removeIf(card -> card.getName().equals(this.city.getName()));
            this.driveFerry(arrivalCity);
        } else {
            // Acyion if not possible
        }
    };
//    void shuttleFlight(City city);
//    void treat();
//    void cure();
//    void shareKnowledge();
//    void pass();

}
