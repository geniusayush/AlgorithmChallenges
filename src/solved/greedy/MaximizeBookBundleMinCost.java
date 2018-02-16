package solved.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by ayush on 24/06/17.
 *
 *
 *
 */
public class MaximizeBookBundleMinCost {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int res;
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());


        int _bundleQuantities_size = 0;
        _bundleQuantities_size = Integer.parseInt(in.nextLine().trim());
        int[] _bundleQuantities = new int[_bundleQuantities_size];
        int _bundleQuantities_item;
        for (int _bundleQuantities_i = 0; _bundleQuantities_i < _bundleQuantities_size; _bundleQuantities_i++) {
            _bundleQuantities_item = Integer.parseInt(in.nextLine().trim());
            _bundleQuantities[_bundleQuantities_i] = _bundleQuantities_item;
        }


        int _bundleCosts_size = 0;
        _bundleCosts_size = Integer.parseInt(in.nextLine().trim());
        int[] _bundleCosts = new int[_bundleCosts_size];
        int _bundleCosts_item;
        for (int _bundleCosts_i = 0; _bundleCosts_i < _bundleCosts_size; _bundleCosts_i++) {
            _bundleCosts_item = Integer.parseInt(in.nextLine().trim());
            _bundleCosts[_bundleCosts_i] = _bundleCosts_item;
        }

        res = budgetShopping(_n, _bundleQuantities, _bundleCosts);
        System.out.println(res);
    }

    static class Store {
        public float quantity;
        public float cost;

        public Store(float quantity, float cost) {
            this.quantity = quantity;
            this.cost = cost;
        }
    }

    static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {
        Store[] storeArr = new Store[bundleQuantities.length];
        for (int i = 0; i < bundleQuantities.length; i++) {
            storeArr[i] = new Store(bundleQuantities[i], bundleCosts[i]);
        }
        Arrays.sort(storeArr, new Comparator<Store>() {
            @Override
            public int compare(Store o1, Store o2) {
                return ((Float) (o2.cost / o2.quantity)).compareTo((Float) (o1.cost / o1.quantity));
            }
        });
        int sum = 0;
        for (int i = 0; i < storeArr.length && n>0; i++) {
            float cost = storeArr[i].cost;
            float quantity = storeArr[i].quantity;
            if (cost > n) continue;
            int packets = n / (int) cost;
            sum += packets * quantity;
            n = n % (int) cost;
        }


        return sum;
    }
}
