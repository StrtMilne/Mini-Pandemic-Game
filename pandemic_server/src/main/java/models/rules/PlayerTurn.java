package models.rules;

public class PlayerTurn {

    private int actionsRemaining;
    private int playerCardsDrawn;
    private int cityCardsDrawn;

    public PlayerTurn() {
        this.actionsRemaining = 4;
        this.playerCardsDrawn = 0;
        this.cityCardsDrawn = 0;
    }

    public void setActionsRemaining(int actionsRemaining) {
        this.actionsRemaining = actionsRemaining;
    }

    public void setPlayerCardsDrawn(int playerCardsDrawn) {
        this.playerCardsDrawn = playerCardsDrawn;
    }

    public void setCityCardsDrawn(int cityCardsDrawn) {
        this.cityCardsDrawn = cityCardsDrawn;
    }

    public int getCityCardsDrawn() {
        return this.cityCardsDrawn;
    }

    public int getPlayerCardsDrawn() {
        return this.playerCardsDrawn;
    }

    public int getActionsRemaining() {
        return this.actionsRemaining;
    }
}
