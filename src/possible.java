import java.util.HashSet;

/**
 * Created by ayush on 10-08-2017.
 */
public class possible {
    /*
 * Complete the function below.
 */

    static String isPossible(int a, int b, int c, int d) {
        if(isPossiblei(a,b,c,d,new int[c][d])){
           return("Yes");
        }
        else
            return("No");


    }
    static boolean isPossiblei(int a, int b, int c, int d,int arr[][]) {
        if(arr[a][b]==-1)return false;
        if(a==c && b==d)return true;
        if(a>c ||b>d)return false;

        else if (isPossiblei(a+b,b,c,d,arr))return true;
        else if(isPossiblei(a,a+b,c,d,arr))return true;
         arr[a][b]=-1;
         return false;


    }
    static int numberOfPairs(int n[], long sum)
    {
        HashSet< Integer> hm = new HashSet<>();
        HashSet< Integer> hm2 = new HashSet<>();

        for (int i=0; i<n.length; i++){

            // initializing value to 0, if key not found
           hm.add(n[i]);
            hm2.add(n[i]);
        }
        int twice_count = 0;


        for (Integer i:hm) {
            if(hm.contains(sum-i))twice_count++;
            hm2.remove(i);
        }


        // return the half of twice_count
        return twice_count;
    }

    public static void main(String[] args) {
         int arr[]={6,1,3,46,1,3,9,46};
        numberOfPairs(arr,47);
    }
}
