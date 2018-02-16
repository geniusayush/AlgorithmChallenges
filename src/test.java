public  class test {
    public static void main(String[] args) {
//1 5 7 9
//1-5 5-7 7-9  1-5-7  5 7 9  1579
// one loop constant spsce
        // wporsr case e- 2N *N
        //1579 is valid only if 157 & 579 are valid
        int arr[] = {2, 6, 7, 5, 1, 3, 4, 5};
        System.out.println(getCount(arr));
    }

    public static int getCount(int arr[]) {
        int count = 0;
        int curr = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                curr++;
                count += curr;
            }
            else{
                curr=0;
            }
        }
        return count;
    }
}
