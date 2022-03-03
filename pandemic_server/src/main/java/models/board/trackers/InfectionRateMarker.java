package models.board.trackers;

public class InfectionRateMarker {

    private int position;

    public InfectionRateMarker() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getCardsToDraw(){
        int index = this.position;
        int[] track = {2, 2, 2, 3, 3, 4, 4};
        return track[index];
    }
}
