package solved;/*
5, 17, 3, 25, 0, 5, 2

0, 2, 3, 5, 5, 17, 25
0  2  3  5  5  7   5
//find if in the aet there exist 2  number s that make up 10.
// lets create array of size 10
// 0,0,2,3,0,{5,5,25},0,{17}
//
// 10

5 25
5 5
25 5
17 3
// 5 10 20 30
//25
*/

import java.util.ArrayList;

// 5 17
public class findWaterInHistorgrams {


    /*
    Q2) {3, 0, 0, 2, 0, 4}

         |
    |    |
    |  | |
    |__|_|
    2,3,1,//0,2,5,//1,3,2  =8
    90
    public static void function(int [] arr)
    { // find local minimum
        for (int )
    }

    */

    static int findWater()
    {
         int arr[] = {3, 0, 0, 2, 0, 4};
        int n=arr.length;
        int left[] = new int[n];

        int right[] = new int[n];

        int water = 0;

        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i-1], arr[i]);

        right[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--)
            right[i] = Math.max(right[i+1], arr[i]);

        for (int i = 0; i < n; i++)
            water += Math.min(left[i],right[i]) - arr[i];

        return water;
    }
    public static void main(String args[]){
        System.out.println(findWater());
    }
}
