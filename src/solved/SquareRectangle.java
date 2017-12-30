package solved;

import java.util.Scanner;

public class SquareRectangle {
    public static void SquareOrRectangle() throws Exception {
        Scanner scan = new Scanner(System.in);
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

}
