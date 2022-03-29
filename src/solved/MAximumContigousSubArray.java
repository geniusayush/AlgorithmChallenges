package solved;

import java.util.Scanner;

 class MAximumContigousSubArray {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int list[] = new int[n];
        for (int t = 0; t < n; t++) {
            list[t] = sc.nextInt();
        }

        findBoundaries(list);
    }

    public static void findBoundaries(int[] list) {
        int max = Integer.MIN_VALUE;
        int mstart = 0;
        int mend = 0;

        int count = 0;
        int start = 0;


        for (int i = 0; i < list.length; i++) {
            // Increment the counter with the current value
            count = count + list[i];
            // if value is greate save it
            if (count > max) {
                max = count;
                mstart = start;
                mend = i;
            }

            // If count is negative, we simply get rid of the past as there is no need to carry it forward
            if (count < 0) {
                count = 0;
                start = i + 1;
            }
        }
        System.out.println(mstart);
        System.out.println(mend);
        System.out.println(max);
    }
}

