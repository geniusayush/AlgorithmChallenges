package BowlingAlley;

public class Game {
    int pinsLeft;
    int throwNumber;

    public Game(int pinsLeft, int throwNumber, int playerIndex) {
        this.pinsLeft = pinsLeft;
        this.throwNumber = throwNumber;
        this.playerIndex = playerIndex;
    }
    public void reset(int playerIndex){
        this.playerIndex=playerIndex;
        pinsLeft=10;
        throwNumber=0;
    }

    public int getPinsLeft() {
        return pinsLeft;
    }

    public void setPinsLeft(int pinsLeft) {
        this.pinsLeft = pinsLeft;
    }

    public int getThrowNumber() {
        return throwNumber;
    }

    public void setThrowNumber(int throwNumber) {
        this.throwNumber = throwNumber;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    int playerIndex;
}
