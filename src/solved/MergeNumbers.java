package solved;

public class MergeNumbers {
    public static int solution3(int A, int B) {
        //  here convert them into string and use sring merge algorithm
        //bth are 0 so return 0
        if (A == 0 & B == 0) return 0;

        String a = A + "";
        String b = B + "";
        String mergeS = merge(a, b);
// check if the number is lessm that 100000000
        int sol = 0;
        try {
            sol = Integer.parseInt(mergeS);
        } catch (Exception e) {
            return -1;
        }
        return (sol > 100000000) ? -1 : sol;

    }

    public static String merge(String a, String b) {
        String s = "";
        int i = 0;

        while (i < a.length() && i < b.length()) {
            if (i == 0 && a.charAt(0) == '0') s += "" + b.charAt(i);// case when 1st number is 0;
            else s += a.charAt(i) + "" + b.charAt(i);
            i++;
        }
        while (i < a.length()) {
            s += a.charAt(i);
            i++;
        }
        while (i < b.length()) {
            s += b.charAt(i);
            i++;
        }
        return s;
    }
}
