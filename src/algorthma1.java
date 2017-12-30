import java.util.Scanner;

public class algorthma1 {


    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        BST bst = new BST();
        for (int t = 0; t < n; t++) {
            arr[t] = sc.nextInt();
            NodeNew node = new NodeNew(arr[t] + "", t);

            if (t == 0) {
                final boolean add = node.getQueue().add(t);
                bst.root = node;
            } else bst.insert(node);
        }
        int q = sc.nextInt();
        for (int t = 0; t < q; t++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int x = sc.nextInt();
            int count = bst.searchMain(l - 1, r - 1, x + "");
            System.out.println(count);
        }
    }
}