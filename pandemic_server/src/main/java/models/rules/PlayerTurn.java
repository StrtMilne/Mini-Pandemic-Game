package models.rules;

import models.board.players.Player;

public class PlayerTurn {

    private int actionsRemaining;
    private int playerCardsToDraw;
    private int cityCardsDrawn;
    private Player player;

    public PlayerTurn(Player player) {
        this.actionsRemaining = 4;
        this.playerCardsToDraw = 2;
        this.cityCardsDrawn = 0;
        this.player = player;
    }

    public void setActionsRemaining(int actionsRemaining) {
        this.actionsRemaining = actionsRemaining;
    }

    public void setPlayerCardsDrawn(int playerCardsDrawn) {
        this.playerCardsToDraw = playerCardsDrawn;
    }

    public void setCityCardsDrawn(int cityCardsDrawn) {
        this.cityCardsDrawn = cityCardsDrawn;
    }

    public Player getPlayer() {
        return player;
    }

    public int getCityCardsDrawn() {
        return this.cityCardsDrawn;
    }

    public int getPlayerCardsToDraw() {
        return this.playerCardsToDraw;
    }

    public int getActionsRemaining() {
        return this.actionsRemaining;
    }

    public void removeAction() {
        this.actionsRemaining -= 1;
    }

    public void drawCards() {
        this.playerCardsToDraw = 0;
    }
}
