package solved;

public class ConsicutiveFactors {
    static int countConsecutive(int N) {
        // constraint on values of L gives us the
        // time Complexity as O(N^0.5)
        int count = 0;
        for (int L = 1; L * (L + 1) < 2 * N; L++) {
            float a = (float) ((1.0 * N - (L * (L + 1)) / 2) / (L + 1));
            if (a - (int) a == 0.0)
                count++;
        }
        return count;
    }

}
