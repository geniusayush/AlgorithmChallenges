package solved;

import java.util.HashMap;
import java.util.HashSet;

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
            if (d.getCount() >= maxNum ) {
                maxNum = d.getCount();
            }
        }

        for (int num : map.keySet()) {
            data d = map.get(num);
            if (d.getCount() == maxNum && (d.getMax() - d.getMin() + 1) < minNum) {
                minNum = d.getMax() - d.getMin() + 1;
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
        int[] arr = {5, 1, 2, 3,6,5,4,98,7,63,455,2,63,156,565};
        System.out.println(degreeOfArray(arr));

    }




}
