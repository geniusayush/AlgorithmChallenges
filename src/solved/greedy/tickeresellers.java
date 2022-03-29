package solved.greedy;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by ayush on 24/06/17.
 * case of reedy approach where as the number f ticket sold are lesser the prce goes dowmn
 * we need tp sell max tickets
 * here there are n sellers where each has some tickets
 */
public class tickeresellers {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        long res;

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }

        long _k;
        _k = Long.parseLong(in.nextLine().trim());

        res = maximumAmount(_a, _k);
        System.out.println(res);
    }


    static long maximumAmount(int[] a, long numElements) {

        PriorityQueue<Long> prq = new PriorityQueue<Long>((Comparator) (o1, o2) -> ((Long) o2).compareTo((Long) o1));

        for (int i = 0; i < a.length; i++) {
            prq.add((long) a[i]);

        }
        int sum = 0;
        while (numElements > 0) {
            long biggestNum = prq.poll();
            long secondBiggest = prq.peek();
            if (biggestNum - secondBiggest + 1 > numElements)
                secondBiggest = biggestNum - numElements + 1;
            float newsum = (((float) biggestNum + (float) secondBiggest) / 2) * (biggestNum - secondBiggest + 1);
            sum += newsum;
            numElements -= biggestNum - secondBiggest + 1;
            biggestNum = secondBiggest - 1;
            prq.add(biggestNum);

        }
        return sum;
    }

}
