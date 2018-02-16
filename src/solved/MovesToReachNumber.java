package solved;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MovesToReachNumber {




    /*
     * Complete the function below.
     */
    static int minimumMoves(int[] a, int[] m) {
        int solution = 0;
        int limit = 0;
        if (a.length > m.length) limit = m.length;
        else limit = a.length;
        for (int i = 0; i < limit; i++) {
            while (a[i] > 0) {
                int rem1 = a[i] % 10;
                int rem2 = m[i] % 10;
                solution += Math.abs(rem2 - rem1);
                a[i] = a[i] / 10;
                m[i] = m[i] / 10;
            }

        }
        return solution;
    }



    public static void main(String[] args) {
        int a[] = {1234, 4321};
        int m[] = {2345, 3214};
        System.out.println(minimumMoves(a, m));

    }
}
