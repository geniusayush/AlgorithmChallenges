package solved.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class PlatformsNeededToScheduleTrains {
    static int findPlatform(int arr[], int dep[], int n)
    {
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // plat_needed indicates number of platforms needed at a time
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        // Similar to merge in merge sort to process all events in sorted order
        while (i < n && j < n)
        {
            // If next event in sorted order is arrival, increment count of
            // platforms needed
            if (arr[i] < dep[j])
            {
                plat_needed++;
                i++;
                if (plat_needed > result)  // Update result if needed
                    result = plat_needed;
            }
            else // Else decrement count of platforms needed
            {
                plat_needed--;
                j++;
            }
        }

        return result;
    }
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int user = scan.nextInt();
        int testcases = scan.nextInt();
        int start[]= new int[testcases];
        int end[]= new int[testcases];
        for (int i = 0; i < testcases; i++) {
            int id = scan.nextInt();
            start[i]=id;
            id = scan.nextInt();
            end[i]=id;
        }
        int a=findPlatform(start,end,testcases);
        if(a<=user) System.out.println(0);
        else System.out.println(a-user);
    }
}
