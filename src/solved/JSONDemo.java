package solved;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class JSONDemo {
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
    }}

    /*static String[] getMovieTitles(String substr) {
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
            resp res=g.fromJson(sendGet(url), resp.class);
            for (int j = 0; j <res.data.length ; j++) {
                response[pointer]=res.data[j].Title;pointer++;
            }
        }

        Arrays.sort(response);
        return response;
    }*/


