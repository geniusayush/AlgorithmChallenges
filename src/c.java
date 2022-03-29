import java.util.HashMap;

class Longest {

    static int[][] longestPalindromicSubsequence(String seq) {
        int n = seq.length();
        int i, j, cl;
        int L[][] = new int[n][n];


        for (i = 0; i < n; i++)
            L[i][i] = 1;

        for (cl = 2; cl <= n; cl++) {
            for (i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                    L[i][j] = L[i + 1][j - 1] + 2;
                else
                    L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
            }
        }
        //System.out.println(L[0][n-1]);
        return L;
    }

    static int getScore(String s) {
        int prodMax = -1;
        int resArr[][] = longestPalindromicSubsequence(s);
        for (int i = 0; i < s.length() - 1; i++) {
            int tempProd = resArr[0][i] * resArr[i + 1][s.length() - 1];
            if (prodMax <= tempProd)
                prodMax = tempProd;
        }
        return prodMax;
    }

    public static void main(String[] args) {
        Longest l = new Longest();
        //System.out.println(l.getScore("abcdapmpomp"));
        System.out.println(easyStrings("aab", "baa"));
    }

    static int easyStrings(String a, String b) {

        return easyStrings(a.toCharArray(), b.toCharArray(), new HashMap<String, Integer>());
    }

    private static int easyStrings(char[] a, char[] b, HashMap<String, Integer> stringIntegerHashMap) {
        if (stringIntegerHashMap.containsKey(a.toString()) && stringIntegerHashMap.get(a.toString())!=-1) return stringIntegerHashMap.get(a.toString());
        int g = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) continue;
            char[] a1 = a.clone();
            char[] b1 = b.clone();

            char temp = a1[i - 1];
            a1[i - 1] = a1[i];
            a1[i] = temp;

            int val;
            if (a1.toString().equals(b.toString())) val = 1;
            else{
                if(stringIntegerHashMap.containsKey(a1.toString()) && stringIntegerHashMap.get(a1.toString())==-1)continue;
                stringIntegerHashMap.put(a1.toString(),-1);
                val = easyStrings(a1, b, stringIntegerHashMap);}

            g = (g < val) ? val : g;

        }

        char[] a1 = a.clone();
        char temp = a1[a1.length - 1];
        a1[a1.length - 1] = a1[0];
        a1[0] = temp;
        int val;
        if (a1.toString().equals(b.toString())) val = 1;
        else val = easyStrings(a1, b, stringIntegerHashMap);

        g = (g < val) ? val : g;
        stringIntegerHashMap.put(a.toString(), g + 1);
        return g;
    }


}