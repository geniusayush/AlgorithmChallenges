package solved;

import solved.CustomGenericMap;


public class MultiplesofGivenNumber {
    public static void newFunction() {
        int n = 10;
        CustomGenericMap<Integer> map = new CustomGenericMap<Integer>(new Integer(5), 10);
        int[] arr = {5, 17, 3, 25, 0, 5, 2};


        for (int i = 0; i < arr.length; i++) {
            int key = arr[i] % n;
           map.add(key,arr[i]);
        }
        // mtrix contains the numbers under appropriate remainders
        // get all the variables that add to  10 here
        int count = 0;
        for (int i = 0; i <= map.getLength() / 2; i++) {
            if (i == 0 || n == i * 2) {

                count += map.getList(i).size() * ( map.getList(i).size() - 1) / 2;
            } else {
                count +=  map.getList(n - i).size();
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        newFunction();
    }
}
