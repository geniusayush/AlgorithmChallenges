import java.util.HashMap;
import java.util.Scanner;

public class h {
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
         scan.nextLine();
        for (int i = 0; i < testcases; i++) {
            String s = scan.nextLine();
            if (s.length() % 2 == 1) {
                System.out.println(-1);
            } else {
                int count=0;
                System.out.println(s.substring(0,s.length()/2));
                System.out.println(s.substring(s.length()/2,s.length()));
                for (int j = 0; j < s.length()/2; j++) {
                    if(s.charAt(j)!=s.charAt(s.length()-j-1))count++;
                }
                System.out.println(count);
            }
        }
    }
    public static void main2(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        for(String a:args){}
        long square=0l;
        long rect=0l;
        long o=0l;
        try{
            while(true){   int a=scan.nextInt();
                int b=scan.nextInt();
                int c=scan.nextInt();
                int d=scan.nextInt();
                if(a<1 ||b<1 ||c<1 ||d<1)o++;
                else if(a==b &&b==c&& c==d) square++;
                else if(a==c &&b==d)rect++;
                else o++;}

        }catch(Exception e){
            System.out.print(square+" "+rect+" "+o);
        }

    }
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