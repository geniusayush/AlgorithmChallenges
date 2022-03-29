public class plNUntanix {


    static int interval(int[] start, int[] end) {


        int[] state = new int[start.length]; // how may are left for each
        int max = 0;
        for (int a : end) {
            if (a > max) max = a;
        }
        int min = Integer.MAX_VALUE;
        for (int a : start) {
            if (a < min) min = a;
        }
        int sol[] = new int[max - min + 1];
        for (int i = 0; i < sol.length; i++) {
            sol[i] = -1;
        }

        int size = function(start, end, min, max, state, sol);
        return size;
    }

    public static int function(int[] start, int[] end, int min, int curr, int[] state, int sol[]) {
        if (curr < min) {
            for (int a : state)
                if (a < 2) return Integer.MAX_VALUE;
                else return 0;
        }
        if(sol[curr-min]>-1)return sol[curr-min];

        int valueun = function(start, end, min, curr - 1, state,sol);


        //  base condition
        for (int i = 0; i < start.length; i++) {
            if (curr >= start[i] && curr <= end[i]) state[i]++;
        }

        int valUsed = 1 + function(start, end, min, curr - 1, state,sol);
        sol[curr - min]=Math.min(valueun,valUsed);
        return sol[curr-min];

    }

    public static void main(String[] args) {

        int[] a = {3, 2, 0, 4};
        int[] b = {6, 4, 2, 7};
        System.out.println(interval(a, b));
    }
}
