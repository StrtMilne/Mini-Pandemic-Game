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
             this.setCity(arrivalCity);
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
            this.setCity(arrivalCity);
        } else {
            // Action if not possible
        }
    };

    public void shuttleFlight(City startCity, City endCity) {
        if(startCity.getResearchCentre() && endCity.getResearchCentre()){
            this.setCity(endCity);
        } else {
            // Action if not possible
        }
    }

    public void treat(String colour) {

        this.getCity().removeCube(colour);
    }

    public void cure(String colour, CureMarkers cureMarkers) {
        long colourCount = this.cards.stream()
                .filter(card -> card instanceof CityCard && ((CityCard) card).getColour() == colour)
                .count();

        if(colourCount >= 4) {
            cureMarkers.setCured(colour);
        } else {
            // Action for insuffficient cards
        }
    }

    public void shareKnowledge(Player otherPlayer, CityCard card) {
        if(this.city == otherPlayer.getCity() && card.getName() == this.city.getName()){
            this.cards.remove(card);
            otherPlayer.addCardToHand(card);
        } else {
            // Action for wrong city/player
        }
    }

//    void pass();

}
