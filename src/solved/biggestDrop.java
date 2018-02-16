package solved;

public class biggestDrop {
    public static void main(String[] args) {
        float[] a={-1,3};
        System.out.println(temperatureDrop(a));
        //1 8 8 8 10 10 10
        //1 2 2 2 2  2  2
    }

    static int temperatureDrop(float[] readings) {
        float[] bigger = new float[readings.length];
        float[] smaller = new float[readings.length];

        float b = Float.MIN_VALUE;
        for (int i = 0; i < bigger.length; i++) {
            b = (readings[i] > b) ? readings[i] : b;
            bigger[i] = b;
        }
        b = Float.MAX_VALUE;
        for (int i = smaller.length - 1; i >= 0; i--) {
            b = (readings[i] < b) ? readings[i] : b;
            smaller[i] = b;
        }
        int maxdiff = 0;
        for (int i = 0; i < bigger.length; i++) {
            int diff = Math.round(bigger[i] - smaller[i]);
            maxdiff = (diff > maxdiff) ? diff : maxdiff;
        }

        return (maxdiff==0)?-1:maxdiff;
    }

}
