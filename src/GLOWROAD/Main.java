package GLOWROAD;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        board b = new board(8);

        knight k1 = new knight(new Coordinates(1, 4));
        knight k2 = new knight(new Coordinates(3, 1));
        b.place(k1);
        b.place(k2);
        Coordinates c1 = null;
        int[][] lol=new int[b.squareSize+1][b.squareSize+1];
        while (!b.atEnd(k1) || !b.atEnd(k2)) {
            for (int[] row: lol)
                Arrays.fill(row, Integer.MIN_VALUE);
            getNextSteps(k1, b, c1,lol);
            b.remove(k1);
            k1.coordinates = c1;
            System.out.println(c1);
            b.place(k1);
            for (int[] row: lol)
                Arrays.fill(row, Integer.MIN_VALUE);
            getNextSteps(k2, b, c1,lol);
            b.remove(k2);
            k2.coordinates = c1;
            b.place(k2);
        }

    }

    private static int getNextSteps(knight k1, board b, Coordinates c1, int[][] ints) {
        if(ints[k1.coordinates.x][k1.coordinates.y]!=Integer.MIN_VALUE)return ints[k1.coordinates.x][k1.coordinates.y];
        int sol;
        if (b.atEnd(k1)) {ints[k1.coordinates.x][k1.coordinates.y]=0;return 0;}
        List<Coordinates> out = k1.getOutcomes();
        if (out.size() == 0) {ints[k1.coordinates.x][k1.coordinates.y]= -1; return-1;}
        List<Coordinates> outcomes= b.filterOutComes(out);
        int min = Integer.MAX_VALUE;
        Coordinates minC = null;
        for (Coordinates c : outcomes) {
            k1.coordinates=c;
            int val = getNextSteps(k1, b, c1,ints);
            if (val != -1 && val < min) {
                min = val;
                minC = c;
            }
        }
        c1 = minC;
        sol= (min==Integer.MAX_VALUE)?-1:min+1;
        ints[k1.coordinates.x][k1.coordinates.y]=sol;
        return sol;

    }
}
