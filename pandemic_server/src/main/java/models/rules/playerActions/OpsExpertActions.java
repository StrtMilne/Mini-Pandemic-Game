package models.rules.playerActions;

import models.board.City;
import models.board.players.Player;
import models.cards.CityCard;

public class OpsExpertActions extends PlayerActions {

    @Override
    public void buildResearchCentre(Player player) {
        super.buildResearchCentre(player);
        player.getCity().setHasResearchCentre(true);
    }

    public void opsFLight(Player player, City city, CityCard card) {
        if(player.getCards().stream().anyMatch(currentCard -> currentCard == card)) {
            player.getCards().remove(card);
            player.setCity(city);
        } else {
            // Action/error that card selected not in hand
        }
    }
}
