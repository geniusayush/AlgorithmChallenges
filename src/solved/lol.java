package solved;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class lol {

    static int mergeIntervals(Intervals arr[]) {

        // Create an empty stack of intervals
        Stack<Intervals> s = new Stack<Intervals>();

        // sort the intervals in increasing order of start time
        Arrays.sort(arr, new Comparator<Intervals>() {
            @Override
            public int compare(Intervals i1, Intervals i2) {
                return ((Integer) i1.start).compareTo(i2.start);
            }
        });

        // push the first interval to stack
        s.push(arr[0]);


        // Start from the next interval and merge if necessary
        for (int i = 1; i < arr.length; i++) {
            // get interval from stack top
            Intervals top = s.pop();

            // if current interval is not overlapping with stack top,
            // push it to the stack
            if (top.end < arr[i].start) {
                s.push(top);
                s.push(arr[i]);
            }
            // Otherwise update the ending time of top if ending of current
            // interval is more
            else if (top.end < arr[i].end) {
                top.end = arr[i].end;
                s.push(top);
            } else {
                s.push(top);
            }
        }

        // Print contents of stack
        int num = 0;
        while (!s.empty()) {
            Intervals t = s.pop();
            num += t.end - t.start + 1;
        }
        return num;
    }

    public static void main2(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        Intervals[] arr = new Intervals[cases];
        for (int i = 0; i < cases; i++) {
            arr[i] = new Intervals();
            arr[i].start = scan.nextInt();
            arr[i].end = scan.nextInt();
        }
        System.out.println(mergeIntervals(arr));
    }


    public static void fe(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        double sum = 0d;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int val = scan.nextInt();
            min = (val < min) ? val : min;
            sum += 1 / (double) val;
        }
        double r = n * (1 / sum);
        double d = (r % min == 0) ? r : min * (((int) r) / min + 1);


        System.out.println((int) d);


    }

    public static void main(String[] args) {
        ReverseStringWithWordsIntact("Can    you see this?");
    }

    static void ReverseStringWithWordsIntact(String s) {
        System.out.print("{");
        int end = -1;
        int start = -1;
        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == ' ' || i == 0) {
                if (end == -1) System.out.print(' ');
                else {
                    if (i == 0) start = 0;
                    for (int j = start; j <= end; j++) {
                        System.out.print(s.charAt(j));
                    }
                    end = -1;
                    start = -1;
                    if(i!=0)System.out.print(' ');
                }
            } else {
                if (end == -1) {
                    start = i;
                    end = i;
                } else {
                    start--;
                }
            }
        }
        System.out.print("}");

    }

}

class Intervals {
    int start, end;
};
