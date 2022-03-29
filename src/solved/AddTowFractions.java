package solved;

import java.io.IOException;
import java.util.Scanner;

/***
 this class is aboutt computing  a  addition of two fractions
 */
public class AddTowFractions {
    public static String[] fractionSum(String arr[]) {
        String res[] = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            String a = s.split("\\+")[0];
            String b = s.split("\\+")[1];
            long a1 = Long.parseLong(a.split("\\/")[0]);
            long a2 = Long.parseLong(a.split("\\/")[1]);
            long b1 = Long.parseLong(b.split("\\/")[0]);
            long b2 = Long.parseLong(b.split("\\/")[1]);
            long an1 = (a1 * b2 + a2 * b1);
            long an2 = (a2 * b2);
            long gcm = gcf(an1, an2);
            res[i] = ((an1 / gcm) + "/" + (an2 / gcm));
        }
        return res;
    }

    public static long gcf(long a, long b) {
        return b == 0 ? a : gcf(b, a % b); // Not bad for one line of code :)
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        String[] res;

        int _str_size = 0;
        _str_size = Integer.parseInt(in.nextLine().trim());
        String[] _str = new String[_str_size];
        String _str_item;
        for (int _str_i = 0; _str_i < _str_size; _str_i++) {
            try {
                _str_item = in.nextLine();
            } catch (Exception e) {
                _str_item = null;
            }
            _str[_str_i] = _str_item;
        }

        res = fractionSum(_str);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));

        }


    }

}