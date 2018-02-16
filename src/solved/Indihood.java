package solved;

import java.util.Scanner;

public class Indihood {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int day[] = new int[n];
        int currDay = 1;
        while (!allNotFin(day)) {
            lis(arr, n, k, day, currDay);
            currDay++;
        }
        System.out.println(currDay - 1);
        for (int i = 1; i <= currDay - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (day[j] == currDay)
                    System.out.println(j+1);
            }
        }

    }

    private static boolean allNotFin(int[] arr) {
        for (int i : arr) if (i == 0) return false;
        return true;
    }

    static int lis(int[] arr, int n, int k, int[] day, int currDay) {
        int lis[] = new int[n];
        int prev[] = new int[n];
        int i, j, max = 0;

          /* Initialize LIS values for all indexes */
        for (i = 0; i < n; i++) {
            lis[i] = 1;
            prev[i] = -1;
        }

           /* Compute optimized LIS values in bottom up manner */
        for (i = 1; i < n && day[i] == 0; i++)
            for (j = 0; j < i && day[j] == 0; j++)
                if (Math.abs(arr[i] - arr[j]) > k && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    prev[i] = j;
                }

           /* Pick maximum of all LIS values */
        int index = -1;
        for (i = 0; i < n; i++)
            if (max < lis[i] && day[i]==0) {
                max = lis[i];
                index = i;
            }

        while (index != -1) {
            day[index] = currDay;
            index = prev[index];
        }
        return max;
    }
}