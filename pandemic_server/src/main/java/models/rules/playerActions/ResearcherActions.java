package models.rules.playerActions;

import models.board.players.Player;
import models.cards.CityCard;

public class ResearcherActions extends PlayerActions {

    public void shareKnowledge(Player givingPlayer, Player receivingPlayer, CityCard card) {
        super.shareKnowledge(givingPlayer, receivingPlayer, card);

        if(givingPlayer.getCity() == receivingPlayer.getCity() && givingPlayer.getCards().contains(card)){
            givingPlayer.getCards().remove(card);
            receivingPlayer.addCardToHand(card);
        } else {
            // Action for wrong city/player
        }
    }

}
