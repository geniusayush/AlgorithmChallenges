import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solutionq {
    public static int solution2(String S) {

        // basic idea get ll the substring and check if they are vaild ie have one upper case and no numbers
        // suppose we have a string s . it can be as possible provieded it is not contains numbers.
        // among those any string having no caps is not allowed
        // since they are max lets use them
        // split with regex of number as delimiter
        String passes[] = S.split("\\d+");
        int length = 0;
        for (String p : passes) {
            if (p.matches(".*[A-Z]+.*")) {
                if (length < p.length()) length = p.length();
            }

        }
        // return (length==0)?-1:length;
        //s=length+"";


        return 0;
    }







}