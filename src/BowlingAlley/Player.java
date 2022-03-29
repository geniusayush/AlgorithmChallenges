package BowlingAlley;

import java.util.ArrayList;

public class Player {
    public int getScores() {
        return totalScore;
    }

    public void setScores(int scores) {
        this.scores.add(scores);
        totalScore += scores;
    }
    public String getAll(){
        StringBuilder builder= new StringBuilder();
        for (int scr:scores){builder.append(scr+" ");}
        return builder.toString();
    }

    public Player() {
        this.scores= new ArrayList<Integer>();

    }

    ArrayList<Integer> scores;
    int totalScore;
}

