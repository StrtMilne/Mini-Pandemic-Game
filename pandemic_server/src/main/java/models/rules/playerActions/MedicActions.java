package models.rules.playerActions;

import models.board.City;
import models.board.players.Player;
import models.board.trackers.CureMarkers;

public class MedicActions extends PlayerActions {

    CureMarkers cureMarkers;

    public MedicActions(CureMarkers cureMarkers) {
        this.cureMarkers = cureMarkers;
    }

    public void treat(Player player, String colour) {
        super.treat(player, colour);
        player.getCity().setCubesOfColour(colour, 0);
    }

    public void autoTreat(City city) {

        if(this.cureMarkers.isBlueCured()) {
            city.setCubesOfColour("blue", 0);
        }
        if(this.cureMarkers.isBlackCured()) {
            city.setCubesOfColour("black", 0);
        }
        if(this.cureMarkers.isYellowCured()) {
            city.setCubesOfColour("yellow", 0);
        }
        if(this.cureMarkers.isRedCured()) {
            city.setCubesOfColour("red", 0);
        }
    }

    public void driveFerry(Player player, City nextCity) {
        super.driveFerry(player, nextCity);

        this.autoTreat(nextCity);
    }

    public void directFlight(Player player, City nextCity){
        super.directFlight(player, nextCity);

        this.autoTreat(nextCity);
    }

    public void charterFlight(Player player, City nextCity){
        super.charterFlight(player, nextCity);

        this.autoTreat(nextCity);
    }
}
