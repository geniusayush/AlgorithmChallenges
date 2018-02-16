package GLOWROAD;

import java.util.ArrayList;
import java.util.List;

abstract class peice {
    abstract public List<Coordinates> getOutcomes();

    public peice(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    Coordinates coordinates;
}

class knight extends peice {
    public knight(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public List<Coordinates> getOutcomes() {
        ArrayList<Coordinates> arr = new ArrayList<>();
//        arr.add(new Coordinates(coordinates.x - 1, coordinates.y - 2));
        //    arr.add(new Coordinates(coordinates.x + 1, coordinates.y - 2));
        arr.add(new Coordinates(coordinates.x - 1, coordinates.y + 2));
        arr.add(new Coordinates(coordinates.x + 1, coordinates.y + 2));
        //      arr.add(new Coordinates(coordinates.x - 2, coordinates.y - 1));
        arr.add(new Coordinates(coordinates.x + 2, coordinates.y - 1));
        // arr.add(new Coordinates(coordinates.x - 2, coordinates.y + 1));
        arr.add(new Coordinates(coordinates.x + 2, coordinates.y + 1));
        return arr;
    }
}
