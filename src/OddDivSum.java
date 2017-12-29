import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ayush on 24/06/17.
 */
public class OddDivSum {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        long res;

        int _numbers_size = 0;
        _numbers_size = Integer.parseInt(in.nextLine().trim());
        int[] _numbers = new int[_numbers_size];
        int _numbers_item;
        for (int _numbers_i = 0; _numbers_i < _numbers_size; _numbers_i++) {
            _numbers_item = Integer.parseInt(in.nextLine().trim());
            _numbers[_numbers_i] = _numbers_item;
        }

        res = countSum(_numbers);
        System.out.println(res);
    }


    static long countSum(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            while (num % 2 == 0) num = num / 2;
            numbers[i] = num;
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += 1;
            if(numbers[i]!=1)sum+=numbers[i];
            for (int j = 2; j <= Math.sqrt(numbers[i]); j++) {
                if (numbers[i] % j == 0) {
                    sum += j;
                    if(j!=Math.sqrt(numbers[i]))
                    sum += numbers[i] / j;
                }
            }
        }
        return sum;
    }

}
