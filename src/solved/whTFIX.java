package solved;

import java.util.*;

public class whTFIX {
    // 1 2 2  3 4 4  6 7 7
    //1 4
    // 0 5
    public static int function(int[] arr, int a, boolean left, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (arr[mid] == a) {
            if (left) {
                if (mid == 0 || arr[mid - 1] != a) {
                    return mid;
                } else {
                    return function(arr, a, left, start, mid - 1);
                }
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != a) {
                    return mid;
                } else {
                    return function(arr, a, left, mid + 1, end);
                }
            }
        } else if (arr[mid] < a) {
            return function(arr, a, left, mid + 1, end);
        } else {
            return function(arr, a, left, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 6, 7, 7};
       // System.out.println(function(arr, 1, true, 0, arr.length - 1));
       // System.out.println(function(arr, 7, false, 0, arr.length - 1));
        function();
    }

    public static void function() {
        String[] arr = {"a","a","a","a","a","b","b","b","c"};
        HashMap<String, Q> map = new HashMap();
        for (String s : arr) {
            if (map.containsKey(s)) map.get(s).freq++;
            else map.put(s, new Q(s, 1));
        }
        Q[] a = map.values().toArray(new Q[0]);
        Arrays.sort(a, new Comparator<Q>() {
            @Override
            public int compare(Q o1, Q o2) {
                return ((Integer) (o2.freq)).compareTo(o1.freq);
            }
        });
        if (arr.length < 2 * (a[0].freq) - 1) System.out.println("NP");
        else System.out.println(function2(a, 0));


    }



    public static String[] function2(Q[] arr, int index) {
        if (index == arr.length - 1) {
            String[] ret = new String[arr[index].freq];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = arr[index].word;
            }
            return ret;
        }

        List<String> solList = new ArrayList<String>();


        String mat[] = new String[2 * arr[index].freq - 1];
        mat[0] = arr[index].word;
        for (int i = 1; i < mat.length; i++) {
            mat[i] = "_";
            mat[++i] = arr[index].word;
        }

        String[] values = function2(arr, index + 1);

        int pointer = values.length - 1;

        for (int i = 0; i < mat.length; i++) {
            if (!mat[i].equals("_")) solList.add(mat[i]);

            else {
                if (pointer == -1) solList.add(mat[i]);
                else {
                    while (values[pointer].equals("_")) {
                        pointer--;
                    }
                    solList.add(values[pointer]);
                    pointer--;
                }
            }


        }

        if (pointer != -1) {
            solList.add(values[pointer]);
            pointer--;
        }


        return solList.toArray(new String[0]);
    }
}

/*
AAAA
B_B_B_B
CC


* */
class Q {
    String word;

    public Q(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }

    int freq;
}