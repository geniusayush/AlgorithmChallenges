import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'priceCheck' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY products
     *  2. FLOAT_ARRAY productPrices
     *  3. STRING_ARRAY productSold
     *  4. FLOAT_ARRAY soldPrice
     */

    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        HashMap<String, Float> map = new HashMap<String, Float>();
        Iterator<String> p1 = products.iterator();
        Iterator<Float> p2 = productPrices.iterator();
        while (p1.hasNext()) {
            map.put(p1.next(), p2.next());
        }
        int count = 0;
        p1 = productSold.iterator();
        p2 = soldPrice.iterator();
        while (p1.hasNext()) {
            if (!map.get(p1.next()).equals(p2.next())) count++;
        }
        return count;
    }



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

 class Solutionsd {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int productsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> products = IntStream.range(0, productsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int productPricesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Float> productPrices = IntStream.range(0, productPricesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Float::parseFloat)
                .collect(toList());

        int productSoldCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> productSold = IntStream.range(0, productSoldCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int soldPriceCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Float> soldPrice = IntStream.range(0, soldPriceCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Float::parseFloat)
                .collect(toList());

        int result = Result.priceCheck(products, productPrices, productSold, soldPrice);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
