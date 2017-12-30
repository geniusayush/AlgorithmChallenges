package solved;

import java.util.ArrayList;
import java.util.HashMap;

public class WrappersGiveFreeCandies {
    static void maximumCupcakes(String[] trips) {
        String[] s1 = {"10 2 5", "12 4 4", "6 2 2"};
        trips = s1;
        for (String s : trips) {
            String[] line = s.split(" ");
            int n = Integer.parseInt(line[0]), c = Integer.parseInt(line[1]), m = Integer.parseInt(line[2]);
            int wrappers = n / c;
            int total = wrappers;
            while (wrappers >= m) {
                int candies = wrappers / m;
                wrappers = wrappers % m;
                total += candies;
                wrappers += candies;
            }
            System.out.println(total);
        }
    }

}
