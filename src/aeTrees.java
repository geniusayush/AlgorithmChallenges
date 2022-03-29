public class aeTrees {
    public static void main(String[] args) {
        System.out.println(new aeTrees().solution(new int[]{5, 4, 3, 2, 6}));
    }

    //  Utility method to flip a character
    public static boolean flip(boolean ch) {
        return !ch;
    }

    //  Utility method to get minimum flips when
    //  alternate string starts with expected char
    public static int getFlipWithStartingCharcter(int[] str,
                                                  boolean expected) {
        int flipCount = 0;
        for (int i = 0; i < str.length; i++) {
            //  if current character is not expected,
            // increase flip count

            if (((i != str.length - 1) && str[i] < str[i + 1]) != expected)
                flipCount++;

            //  flip expected character each time
            expected = flip(expected);
        }
        return flipCount;
    }

    public int solution(int[] A) {
        return Math.min(getFlipWithStartingCharcter(A, true),
                getFlipWithStartingCharcter(A, false));
    }

}
