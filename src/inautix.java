import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class inautix {

    /*
     * Complete the function below.
     */
    public static void main(String[] args) {
        long[] arr = {4, 89, 18, 56};
        //System.out.println(getMinOperations(arr));
        int a[] = {1234, 4321};
        int m[] = {2345, 3214};
        //System.out.println(minimumMoves(a, m));
        getMovieTitles("spiderman");
    }

    static int[] getMinOperations(long[] kValues) {

        int solution[] = new int[kValues.length];
        for (int i = 0; i < kValues.length; i++) {
            HashMap map = new HashMap<Long, Long>();
            long num = kValues[i];
            solution[i] = (int) calc(num, map);
            System.out.println(solution[i]);
        }
        return solution;
    }

    private static long calc(long num, HashMap<Long, Long> map) {
        if (num == 1) return 1;

        if (map.containsKey(num)) return map.get(num);
        long result = 0;

        if (num > 1 && num % 2 == -0) {
            result = calc(num / 2, map) + 1;

        } else result = calc(num - 1, map) + 1;
        map.put(num, result);
        return result;


    }

    static String[] findNumberOfCowsAndBulls(Map<String, String> userInput) {
        String[] ans = new String[userInput.size()];
        int v = 0;
        for (String s : userInput.keySet()) {
            char[] number = userInput.get(s).toCharArray();
            char ss[] = s.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < 4; i++) {
                map.put(ss[i], i);
            }
            int bulls = 0, cow = 0;
            for (int i = 0; i < 4; i++) {
                if (map.containsKey(number[i])) {
                    if (map.get(number[i]) == i) bulls++;
                    else cow++;
                }
            }
            ans[v] = bulls + "-Bulls," + cow + "-Cows";
            v++;

        }
        return ans;
    }

    public static LinkedHashMap<String, String> codeTheSolution(LinkedHashMap<String, String> inputLinkHashMap) {
        Character[] arr = inputLinkHashMap.keySet().toArray(new Character[4]);
        int countSmaller[] = new int[arr.length];
        int i, j;

        // initialize all the counts in countSmaller array as 0
        for (i = 0; i < arr.length; i++)
            countSmaller[i] = 0;

        for (i = 0; i < arr.length; i++) {
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i])
                    countSmaller[i]++;
            }
        }
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        for (int k = 0; k < arr.length; k++) {
            map.put(countSmaller[i] + "", "f");
        }
        return map;
    }

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

    static String sendGet(String url) {

        try{
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");


            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            return response.toString();
        }catch(Exception e){
            System.out.println(e.getMessage());return "";
        }

    }

    static class Movie {
        String Poster;
        String Title;
        String Type;
        String Year;
        String imdbID;
    }

    static class resp {
        int page;
        int per_page;
        int total;
        int total_pages;
        Movie[] data;
    }

    static String[] getMovieTitles(String substr) {
        Gson g = new Gson();


        String basic = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman";
        String lol = sendGet(basic);
        resp p = g.fromJson(lol, resp.class);
        int total_movies = p.total;
        String response[] = new String[total_movies];
        if(total_movies==0)return response;
        int pointer=0;
        int page=p.total_pages;
        for (int i = 1; i <=page ; i++) {
            String url =basic+"&page="+i;
            resp res=g.fromJson(sendGet(url),resp.class);
            for (int j = 0; j <res.data.length ; j++) {
                response[pointer]=res.data[j].Title;pointer++;
            }
        }

        Arrays.sort(response);
        return response;
    }
}
