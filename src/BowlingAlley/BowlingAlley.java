package BowlingAlley;

import java.util.Scanner;

public class BowlingAlley {

    int lanes;
    Player[] players;
    int sets;
    Game game;

    public BowlingAlley(int lanes, int sets) {
        this.lanes = lanes;
        this.sets = sets;
    }

    public int getLanes() {
        return lanes;
    }

    public void setPlayers(int players) {
        this.players = new Player[players];
        for (int i = 0; i < this.players.length; i++) {
            this.players[i] = new Player();
        }
    }

    public int getSets() {
        return sets;
    }

    public Rule getRule() {
        return new StandardRule();
    }

    public static void main(String[] args) {
        BowlingAlley alley = new BowlingAlley(1, 10);
        Scanner scan = new Scanner(System.in);
        alley.setPlayers(scan.nextInt());
        alley.start(scan);

    }

    private void start(Scanner scan) {
        game = new Game(10, 0, 0);
        Result result;
        while (sets > 0) {
            char c = scan.next().charAt(0);
            try {
                result = submit(c);
            } catch (Exception e) {
                System.out.println("wrong input given");
                continue;
            }
            updatePlayer(game.getPlayerIndex(), result.getScore());
            updateGameandset(c, result);

        }

        scan.close();
    }

    private void updateGameandset(int hitValue, Result result) {
        if (result.getPswitch() == 0) {

            game.setThrowNumber(game.getThrowNumber() + 1);
            game.setPinsLeft(result.getPinsTobeSet());
        } else {
            if (game.getPlayerIndex() == players.length - 1) {
                game.reset(0);
                finishSet();
            } else {
                game.reset(game.getPlayerIndex() + 1);
            }

        }

    }

    private void finishSet() {
        sets--;
        printScores();
    }

    private void printScores() {
        System.out.println("Scoreboard");
        for (int i = 0; i < players.length; i++) {
            System.out.println("P" + i + ":" + players[i].getAll() + " -> " + players[i].totalScore);
        }
        System.out.println();
    }

    private void updatePlayer(int playerIndex, int score) {
        players[playerIndex].setScores(score);
    }

    private Result submit(char hitValue) throws Exception {
        Rule rule = getRule();
        return rule.getScore(hitValue, game);

    }
}
