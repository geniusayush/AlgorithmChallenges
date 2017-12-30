package solved;

import java.util.Scanner;

public class Anagram {
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
}