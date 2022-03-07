package models.rules.playerActions;

import models.board.City;
import models.board.players.Player;

public class DispatcherActions extends PlayerActions{

    private Player dispatcher;

    public DispatcherActions(Player dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void pawnToPawn(Player playerToMove, Player targetPlayer) {
        City destination = targetPlayer.getCity();
        playerToMove.getCity().getPlayers().remove(playerToMove);
        playerToMove.setCity(destination);
    }

    @Override
    public void directFlight(Player player, City arrivalCity) {
        super.directFlight(player, arrivalCity);

        if (this.dispatcher.getCards().stream()
                .anyMatch(card -> card.getName()
                        .equals(arrivalCity.getName()))) {
            player.setCity(arrivalCity);
            this.dispatcher.getCards().removeIf(card -> card.getName().equals(arrivalCity.getName()));
        } else {
            // Action for not having card
        }
    }

    public void charterFlight(Player player, City arrivalCity){
        if (this.dispatcher.getCards().stream()
                .anyMatch(card -> card.getName()
                        .equals(player.getCity().getName()))) {
            this.dispatcher.getCards().removeIf(card -> card.getName().equals(player.getCity().getName()));
            player.setCity(arrivalCity);
        } else {
            // Action if not possible
        }
    }
}
