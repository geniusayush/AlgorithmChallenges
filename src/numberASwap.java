// you can also use imports, for example:
// import java.util.*;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
/*
* */
public class numberASwap {
    public static  int solution(int A) {
        char[] array=(A+"").toCharArray();
        int num=0;
        int power=0;

        for(int i=0;i<array.length/2;i++){
            num=(num*10)+array[i]-48;
            num= (num*10)+array[array.length-1-i]-48;
        }
        if(array.length%2!=0){
            num+=(num*10)+array[array.length/2]-48;
        }
        return num;}

    public static void main(String[] args) {
        //solution(130);
        int arr[][]={{7, -2, 0, 4, 2}, {-1, 0, 1, 3, 1}, {1, 2, 1, -1, 2}, {4, 0, 0, -3, 0}};
        solution2(arr);
    }
    // you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

        public static int solution2(int[][] A) {
            // write your code in Java SE 8
            // the problemn is on the tougher side.
            // i can see that itsa a dynamic problem .
            //ex lowest is a[3][3] =-3 but we cannoot take it as  the next elements have to be greater than that
            //f(i,j)= Max(f(i.. j...));
            //if we have taken f(i ,j) then we can only take i2 and j2 where i<=i2 && j<= j2 and vlue of f <= value i2,j2.
            int [][] matrix= new int[A.length][A[0].length];
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[i].length;j++){
                    matrix[i][j]=-1;}}
            return solution2(A,0,0,matrix,Integer.MIN_VALUE);
        }
        public static int solution2(int[][] arr, int i,int j,int matrix[][],int value)
        {
            if(matrix[i][j]!=-1)return matrix[i][j];// memoization
            int solution =0;
            if(i==arr.length-1 && j== arr[0].length-1){
                solution=1;
            }else
            {
                for(int k=i;k<arr.length;k++){
                    for(int l=j;l<arr[0].length;l++){
                        if(k==i && l==j)continue;

                        if(arr[k][l]>=arr[i][j])
                        {int ans=solution2(arr,k,l,matrix,arr[i][j])+1;
                        if(ans>solution)solution= ans;}

                    }
                }
                for(int k=i;k<arr.length;k++){
                    for(int l=j;l<arr[0].length;l++){
                        if(k==i && l==j)continue;

                        if(arr[k][l]>=value)
                        {int ans=solution2(arr,k,l,matrix,value);
                            if(ans>solution)solution= ans;}

                    }
                }


            }
            return solution;
        }


    }
