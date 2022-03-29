package solved;


public class MergeSort3Way {

    public static void mergeSort3Way(int[] input) {
        if (input == null)
            return;
        int[] tempArray = new int[input.length];
        for (int i = 0; i < tempArray.length; i++)
            tempArray[i] = input[i];
        mergeSortSplit(input, 0, input.length, tempArray);

    }


    public static void mergeSortSplit(int[] input,
                                      int start, int end, int[] tempArray) {
        // If array size is 1 then do nothing
        if (end - start < 2)
            return;

        int point1 = start + ((end - start) / 3);
        int point2 = start + 2 * ((end - start) / 3) + 1;

        mergeSortSplit(tempArray, start, point1, input);
        mergeSortSplit(tempArray, point1, point2, input);
        mergeSortSplit(tempArray, point2, end, input);

        InPlacemerge(tempArray, start, point1, point2, end, input);
    }


    public static void InPlacemerge(int[] inputArray, int start,
                                    int point1, int point2, int end,
                                    int[] destArray) {
        int i = start, j = point1, k = point2, l = start;


        while ((i < point1) && (j < point2) && (k < end)) {
            if (inputArray[i] < (inputArray[j])) {
                if (inputArray[i] < (inputArray[k])) destArray[l++] = inputArray[i++];
                else destArray[l++] = inputArray[k++];
            } else {
                if (inputArray[j] < (inputArray[k])) destArray[l++] = inputArray[j++];
                else destArray[l++] = inputArray[k++];
            }
        }

        while ((i < point1) && (j < point2)) {
            if (inputArray[i] < (inputArray[j])) destArray[l++] = inputArray[i++];
            else destArray[l++] = inputArray[j++];
        }

        while ((j < point2) && (k < end)) {
            if (inputArray[j] < (inputArray[k]))
                destArray[l++] = inputArray[j++];
            else
                destArray[l++] = inputArray[k++];
        }

        while ((i < point1) && (k < end)) {
            if (inputArray[i] < (inputArray[k]))
                destArray[l++] = inputArray[i++];
            else
                destArray[l++] = inputArray[k++];
        }

        while (i < point1)
            destArray[l++] = inputArray[i++];

        while (j < point2)
            destArray[l++] = inputArray[j++];

        while (k < end)
            destArray[l++] = inputArray[k++];
    }


    public static void main(String args[]) {

        int[] data = new int[]{1, 5, 3};
        mergeSort3Way(data);

        for (int i : data)
            System.out.print(i + " ");
    }
}