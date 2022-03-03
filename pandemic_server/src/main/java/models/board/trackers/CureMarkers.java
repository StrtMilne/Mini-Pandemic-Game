package models.board.trackers;

public class CureMarkers {

    private boolean blue;
    private boolean yellow;
    private boolean black;
    private boolean red;

    public CureMarkers() {
        this.blue = false;
        this.yellow = false;
        this.black = false;
        this.red = false;
    }

    public boolean isBlue() {
        return blue;
    }

    public void setBlue(boolean blue) {
        this.blue = blue;
    }

    public boolean isYellow() {
        return yellow;
    }

    public void setYellow(boolean yellow) {
        this.yellow = yellow;
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }
}
