package solved;

import java.util.HashMap;

public class MovesToGetNumberFromLowerNumbers {

    /*
     * Complete the function below.
     */
    public static void main(String[] args) {
        long[] arr = {4, 89, 18, 56};
        System.out.println(getMinOperations(arr));

    }

    static int[] getMinOperations(long[] kValues) {

        int solution[] = new int[kValues.length];
        for (int i = 0; i < kValues.length; i++) {
            HashMap map = new HashMap<Long, Long>();
            long num = kValues[i];
            solution[i] = (int) calc(num, map);
            System.out.println(solution[i]);
        }
        return solution;
    }

    private static long calc(long num, HashMap<Long, Long> map) {
        if (num == 1) return 1;

        if (map.containsKey(num)) return map.get(num);
        long result = 0;

        if (num > 1 && num % 2 == -0) {
            result = calc(num / 2, map) + 1;

        } else result = calc(num - 1, map) + 1;
        map.put(num, result);
        return result;


    }


}
