package com.practice;// you can also use imports, for example:

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public static int solution2(String S) {
        // write your code in Java SE 8
        // basic idea get ll the substring and check if they are vaild ie have one upper case and no numbers
        // suppose we have a string s . it can be as possible provieded it is not contains numbers.
        // among those any string having no caps is not allowed
        // since they are max lets use them
        // split with regex of number as delimiter
        String passes[] = S.split("\\d+");
        int length = 0;
        for (String p : passes) {
            if (p.matches(".*[A-Z]+.*")) {
                if (length < p.length()) length = p.length();
            }

        }
        // return (length==0)?-1:length;
        //s=length+"";


        return 0;
    }


    public static void main(String[] args) {
        int [] a={200,199,176,125,120};
        int b[]={1,2,3,4,5};
        int m=3;
        int x=5; int y=200;
        System.out.println(solution(a,b,m,x,y));
    }

    public static int solution3(int A, int B) {
        //  here convert them into string and use sring merge algorithm
        //bth are 0 so return 0
        if (A == 0 & B == 0) return 0;

        String a = A + "";
        String b = B + "";
        String mergeS = merge(a, b);
// check if the number is lessm that 100000000
        int sol = 0;
        try {
            sol = Integer.parseInt(mergeS);
        } catch (Exception e) {
            return -1;
        }
        return (sol > 100000000) ? -1 : sol;

    }

    public static String merge(String a, String b) {
        String s = "";
        int i = 0;

        while (i < a.length() && i < b.length()) {
            if (i == 0 && a.charAt(0) == '0') s += "" + b.charAt(i);// case when 1st number is 0;
            else s += a.charAt(i) + "" + b.charAt(i);
            i++;
        }
        while (i < a.length()) {
            s += a.charAt(i);
            i++;
        }
        while (i < b.length()) {
            s += b.charAt(i);
            i++;
        }
        return s;
    }

    public static int solution(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8
        // follo the lift  fill the people til u can and contunie
        // since the queue order cannot be changed no need to do any sort;
        int stops = 0;
        int pointer = 0;
        int sizeLimit = X, weightLimit = Y;
        HashSet<Integer> set = new HashSet<Integer>();

        while (pointer < A.length) {
            sizeLimit = X;
            weightLimit = Y;
            set.clear();
            // add more peopler
            while (sizeLimit > 0 && pointer < A.length && weightLimit >= A[pointer]) {
                sizeLimit--;
                weightLimit -= A[pointer];
                set.add(B[pointer]);
                pointer++;
            }
            // all eople who could board have boarded
            int NoOfFloors=set.size();
            stops+=NoOfFloors+1;
        }
        return stops;
    }
}