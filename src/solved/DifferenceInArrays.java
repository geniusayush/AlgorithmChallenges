package solved;

import java.util.HashMap;

public class DifferenceInArrays {
    static int[] getMinimumDifference(String[] a, String[] b) {
        String a1[] = {"hhpddlnnsjfoyxpci"}, b1[] = {"ioigvjqzfbpllssuj"};
        a = a1;
        b = b1;
        int sol[] = new int[a.length];
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < a.length; i++) {
            map = new HashMap<Character, Integer>();
            if (a[i].length() != b[i].length()) {
                sol[i] = -1;
                continue;
            } else {
                for (char c : a[i].toCharArray()) {
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                    } else {
                        map.put(c, 1);
                    }
                }
                for (char c : b[i].toCharArray()) {
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) - 1);
                        if (map.get(c) == 0) map.remove(c);
                    }

                }
                int sum = 0;
                for (int val : map.values()) {
                    sum += val;
                }
                sol[i] = sum;
            }
        }
        return sol;
    }



    public static void main(String[] args) {

        getMinimumDifference(null, null);
    }
}
