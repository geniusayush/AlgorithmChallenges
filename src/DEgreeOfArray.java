import java.util.HashMap;

public class DEgreeOfArray {
    static int degreeOfArray(int[] arr) {
        HashMap<Integer, data> map = new HashMap<Integer, data>();
        for (int i = 0; i < arr.length; i++) {


            if (map.containsKey(arr[i])) {
                data d = map.get(arr[i]);
                d.setCount(d.getCount() + 1);
                d.setMax(i);
                map.put(arr[i], d);
            } else {
                map.put(arr[i], new data(1, i, i));
            }
        }
        int maxNum = 0;
        int minNum = Integer.MAX_VALUE;
        for (int num : map.keySet()) {
            data d = map.get(num);
            if (d.getCount() >= maxNum && (d.getMax() - d.getMin() + 1) < minNum) {
                minNum = d.getMax() - d.getMin() + 1;
                maxNum = d.getCount();
            }
        }
        return minNum;
    }

    public static class data {
        int count;
        int min;
        int max;

        public data(int count, int min, int max) {
            this.count = count;
            this.min = min;
            this.max = max;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 2, 3, 1};
        //  degreeOfArray(arr);
        System.out.println(findLongestChain(3, 8));
    }

    static int countConsecutive(int N) {
        // constraint on values of L gives us the
        // time Complexity as O(N^0.5)
        int count = 0;
        for (int L = 1; L * (L + 1) < 2 * N; L++) {
            float a = (float) ((1.0 * N - (L * (L + 1)) / 2) / (L + 1));
            if (a - (int) a == 0.0)
                count++;
        }
        return count;
    }

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
