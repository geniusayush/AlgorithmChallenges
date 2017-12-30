package solved;

import java.util.HashSet;

public class FillLift {
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
    public static void main(String[] args) {
        int [] a={200,199,176,125,120};
        int b[]={1,2,3,4,5};
        int m=3;
        int x=5; int y=200;
        System.out.println(solution(a,b,m,x,y));
    }
}
