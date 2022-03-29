package solved;

public class NumbersWhereSumIsPositive {
    public int maxSubArray(final int[] list) {
        int max = Integer.MIN_VALUE;
        int mstart=0;
        int mend=0;

        int count = 0;
        int start =0; int end=0;

        for (int i = 0; i < list.length; i++) {
            // Increment the counter with the current value
            count = count + list[i];
            end =i;
            if (count > max) {
                max = count;
                mstart=start;
                mend=end;
            }

            // If count is negative, we simply get rid of the past
            if (count < 0) {
                count = 0;
                start=i+1;
            }
        }
        return max;
    }
}
