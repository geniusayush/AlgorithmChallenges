
import java.util.HashMap;
import java.util.Scanner;

class KVMap {
    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, Integer> countmap = new HashMap<>();


    public static void getFunc() {

    }

    public Integer get(int k) {
        if (!map.containsKey(k)) return null;
        return map.get(k);
    }

    public int set(int k, int v) {
        int oldv = 0;
        if (map.containsKey(k)) oldv = map.get(k);
        map.put(k, v);

        updateCount(v, oldv);
        return v;
    }

    public void del(int k) throws Exception {
        if (!map.containsKey(k)) throw new Exception("value not present in the database");

        reduceOldFrequency(map.get(k));
        map.remove(k);

    }

    public int inc(int k) throws Exception {
        if (!map.containsKey(k)) throw new Exception("value not present in the database");
        return set(k, map.get(k) + 1);
    }

    public int count(int v) {
        if (!countmap.containsKey(v)) return 0;
        return countmap.get(v);
    }

    private void updateCount(int v, int oldv) {

        reduceOldFrequency(oldv);

        increaseNew(v);
    }

    private void increaseNew(int v) {
        if (countmap.containsKey(v)) {
            countmap.put(v, 1);
        } else
            countmap.put(v, countmap.get(v) + 1);
    }

    private void reduceOldFrequency(int oldv) {
        int oldf = countmap.get(oldv);
        if (oldf == 1) countmap.remove(oldv);
        else countmap.put(oldv, countmap.get(oldv) - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        KVMap map = new KVMap();
        System.out.println(map.set('b', 6));
        map.set('d', 3);
        map.set('a', 3);
        map.count(3);
        map.count(6);
        do {
            System.out.println("1 get 2 set 3 del 4 inc 5 count else exit");
            input = scan.nextInt();
            switch (input) {
                case 1:
                    getFunc();
                    break;
                case 2:
                    setFunc();
                    break;
                case 3:
                    delFunc();
                    break;
                case 4:
                    incFunc();
                    break;
                case 5:
                    countFunc();
                    break;
                default:
                    return;

            }

        } while (true);


    }

    private static void countFunc() {
    }

    private static void incFunc() {

    }

    private static void delFunc() {

    }

    private static void setFunc() {

    }
}

