package models.board.trackers;

public class CureMarkers {

    private boolean blueCured;
    private boolean yellowCured;
    private boolean blackCured;
    private boolean redCured;

    public CureMarkers() {
        this.blueCured = false;
        this.yellowCured = false;
        this.blackCured = false;
        this.redCured = false;
    }

    public boolean isBlueCured() {
        return blueCured;
    }

    public void setBlueCured(boolean blueCured) {
        this.blueCured = blueCured;
    }

    public boolean isYellowCured() {
        return yellowCured;
    }

    public void setYellowCured(boolean yellowCured) {
        this.yellowCured = yellowCured;
    }

    public boolean isBlackCured() {
        return blackCured;
    }

    public void setBlackCured(boolean blackCured) {
        this.blackCured = blackCured;
    }

    public boolean isRedCured() {
        return redCured;
    }

    public void setRedCured(boolean redCured) {
        this.redCured = redCured;
    }

    public void setCured(String colour) {
        if (colour == "blue") {
            this.blueCured = true;
        } else if (colour == "black") {
            this.blackCured = true;
        } else if (colour == "red") {
            this.redCured = true;
        } else {
            this.yellowCured = true;
        }
    }
}
