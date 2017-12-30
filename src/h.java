import java.util.HashMap;
import java.util.Scanner;

public class h {




    public static void main3(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);

        String[] words  = scan.nextLine().split(" ");
        int testcases = scan.nextInt();
        HashMap<Integer,HashMap<String,Integer>> map=new HashMap<>();
        for (int i = 0; i < testcases; i++) {
            int id = scan.nextInt();
            HashMap<String, Integer> m = map.get(id);
            if(m==null){m=new HashMap<>();map.put(id,m);}
            scan.nextLine();
            String[] reviews  = scan.nextLine().split(" ");
            for(String w:reviews ){
            if(m.containsKey(w)){m.put(w,m.get(w)+1);}
            else m.put(w,1);
            }
            map.put(id,m);
        }
        for (int g:map.keySet()){
            HashMap<String, Integer> m = map.get(g);
            
        }
        }
}