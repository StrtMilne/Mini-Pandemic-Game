package models.rules.playerActions;

import models.board.players.Player;
import models.board.trackers.CureMarkers;
import models.cards.CityCard;

public class ScientistActions extends PlayerActions{

    public void cure(Player player, String colour, CureMarkers cureMarkers) {
        super.cure(player, colour, cureMarkers);

        long colourCount = player.getCards().stream()
                .filter(card -> card instanceof CityCard && ((CityCard) card).getColour() == colour)
                .count();

        if(colourCount >= 4) {
            cureMarkers.setCured(colour);
        } else {
            // Action for insuffficient cards
        }
    }
}
