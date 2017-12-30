import java.util.HashMap;

public class Codewale {


    /*
     * Complete the function below.
     */
    static int findLongestChain(int min, int max) {

        int matrix[] = new int[max];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();


        for (int i = min; i <= max; i++) {
            matrix[i] = bilgi(i, map);
        }
        int high = 0;
        int num=0;
        for (int i = min; i < max; i++) {
            if(matrix[i] > high)
            { high = matrix[i];
                num=i;
            }

        }
        return num;

    }

    static int bilgi(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) return map.get(n);

        int result = n;
        int sol = 0;
        if (result <= 1) sol = 1;
        else if (result % 2 == 0) sol = 1 + bilgi(result / 2, map);
        else sol = 1 + bilgi(3 * result + 1, map);
        map.put(n, sol);
        return sol;
    }
}
