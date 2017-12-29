package com.practice;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

import java.util.Arrays;
import java.util.Scanner;

class TestClass {
    public static void main2(String args[]) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        int M = s.nextInt();
        int[][] arr = new int[N][M];
        int[][] path = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        path[0][0] = 0;
        path[0][1] = Math.abs(arr[0][0] - arr[0][1]);
        path[1][0] = Math.abs(arr[0][0] - arr[1][0]);
        System.out.println(function(arr, N - 1, M - 1,path));


        System.out.println("Hello World!");
    }

    private static int function(int[][] arr, int i, int j, int[][] path) {
        int min=Integer.MAX_VALUE;
        if (i > 0 &&i<arr.length) {
            min=validate(min,get(i-1,j,path,arr)+Math.abs(arr[i-1][j] - arr[i][j]));
        }//left
        if (j > 0 &&j<arr[0].length) {
            min=validate(min,get(i,j-1,path,arr)+Math.abs(arr[i][j-1] - arr[i][j]));

        }//top
        if (i > 0 && j > 1 && j!=0)min=validate(min,get(i+1,j,path,arr)+Math.abs(arr[i+1][j] - arr[i][j]));
//right
            if (j>0 && i>1)//down
         min=validate(min,get(i,j+1,path,arr)+Math.abs(arr[i][j+1] - arr[i][j]));


        return min;
    }

    private static int validate(int min, int i) {
        return(min<1)?min:i;
    }

    private static int get(int i, int j, int[][] path, int[][] arr) {
        if(path[i][j]==0)
            path[i][j]=function(arr,i,j,path);
        return path[i][j];
    }


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
