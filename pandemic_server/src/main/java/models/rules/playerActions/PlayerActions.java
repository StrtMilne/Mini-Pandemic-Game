package models.rules.playerActions;

import models.board.City;
import models.board.players.Player;
import models.board.trackers.CureMarkers;
import models.cards.CityCard;

public class PlayerActions {

    public void driveFerry(Player player, City nextCity) {
        player.getCity().getPlayers().remove(player);
        player.setCity(nextCity);
        nextCity.addPlayer(player);
    };

    public void directFlight(Player player, City arrivalCity){
        if (player.getCards().stream()
                .anyMatch(card -> card.getName()
                        .equals(arrivalCity.getName()))) {
            player.setCity(arrivalCity);
            player.getCards().removeIf(card -> card.getName().equals(arrivalCity.getName()));
        } else {
            // Action if not possible
        }
    };

    public void charterFlight(Player player, City arrivalCity){
        if (player.getCards().stream()
                .anyMatch(card -> card.getName()
                        .equals(player.getCity().getName()))) {
            player.getCards().removeIf(card -> card.getName().equals(player.getCity().getName()));
            player.setCity(arrivalCity);
        } else {
            // Action if not possible
        }
    };

    public void shuttleFlight(Player player,City startCity, City endCity) {
        if(startCity.getResearchCentre() && endCity.getResearchCentre()){
            player.setCity(endCity);
        } else {
            // Action if not possible
        }
    };

    public void treat(Player player, String colour) {
        player.getCity().removeCube(colour);
    };

    public void cure(Player player, String colour, CureMarkers cureMarkers) {
        long colourCount = player.getCards().stream()
                .filter(card -> card instanceof CityCard && ((CityCard) card).getColour().equals(colour))
                .count();

        if(colourCount >= 5) {
            cureMarkers.setCured(colour);
        } else {
            // Action for insuffficient cards
        }
    };

    public void shareKnowledge(Player player, Player otherPlayer, CityCard card) {
        if(player.getCity() == otherPlayer.getCity() && card.getName() == player.getCity().getName() && player.getCards().contains(card)){
            player.getCards().remove(card);
            otherPlayer.addCardToHand(card);
        } else {
            // Action for wrong city/player
        }
    }

    public void buildResearchCentre(Player player) {
        City city = player.getCity();
        if(player.getCards().stream().anyMatch(card -> card.getName() == city.getName())) {
            city.setHasResearchCentre(true);
        }
    }

//    void pass() ---- depends on their being an action class to implement;
}
