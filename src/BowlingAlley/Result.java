package BowlingAlley;

public class Result {
     int pinsTobeSet;
    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPswitch() {
        return pswitch;
    }

    public void setPswitch(int pswitch) {
        this.pswitch = pswitch;
    }

    public int getPinsTobeSet() {
        return pinsTobeSet;
    }

    public void setPinsTobeSet(int pinsTobeSet) {
        this.pinsTobeSet = pinsTobeSet;
    }

    public Result(int score, int pswitch, int pins) {

        this.score = score;
        this.pswitch = pswitch;
        this.pinsTobeSet=pins;

    }

    int pswitch;
}
