import java.util.ArrayList;
import java.util.HashMap;

public class wrappers {
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

    public static void newFunction() {
        int n = 10;
        int[] arr = {5, 17, 3, 25, 0, 5, 2};
        ArrayList<Integer>[] matrix = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = new ArrayList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i] % n;
            matrix[key].add(arr[i]);
        }
        int count=0;
        for (int i = 0; i <= matrix.length/2; i++) {
            if (i == 0 ||n==i*2){

                count+=matrix[i].size()*(matrix[i].size()-1)/2;
            }
            else{
                count+=matrix[n-i].size();
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        newFunction();
        //getMinimumDifference(null, null);
    }
}
