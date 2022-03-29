package solved;

import java.util.Scanner;

public class Anagram {
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < testcases; i++) {
            String s = scan.nextLine();

            //   int count=0;
            for (int j = 0; j < s.length() / 2; j++) {
                if (s.charAt(j) != s.charAt(s.length() - j - 1)) System.out.println(-1);

            }
            System.out.println(0);
        }
    }
}
