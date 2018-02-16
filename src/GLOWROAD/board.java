package GLOWROAD;

import java.util.ArrayList;
import java.util.List;

public class board {
    int squareSize;
    ArrayList<Coordinates> blocked = new ArrayList<>();

    public board(int i) {
        this.squareSize = i;
    }

    public void setSize(int size) {
        this.squareSize = size;
    }


    public void remove(knight k1) {

        blocked.remove(k1.coordinates);

    }
    public void place(knight k1) {

        blocked.add(k1.coordinates);

    }

    public boolean atEnd(knight k2) {
        if (k2.coordinates.x == squareSize && k2.coordinates.y == squareSize) return true;
        return false;
    }

    public List<Coordinates> filterOutComes(List<Coordinates> outcomes) {
        List<Coordinates> out = new ArrayList<>();
        for (Coordinates c : outcomes) {
            if (c.y <= squareSize && c.x <= squareSize  && c.y>0  && c.x>0) {
                out.add(c);

            }
        }
       return out;
    }
}
