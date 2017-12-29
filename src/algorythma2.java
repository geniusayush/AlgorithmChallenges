import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class algorythma2 {



    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        int[] arr = new int[n];

        for (int t = 0; t < n; t++) {
            Node node = new Node(sc.nextInt());
            // set node value to
            map.put(t + 1, node);
        }
        for (int t = 0; t < d; t++) {
            Node a = map.get(sc.nextInt());
            Node b = map.get(sc.nextInt());
            a.getQueue().add(b);

        }
        for (int t = 1; t <= n; t++) {
            Node node = map.get(t);
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(node);
            boolean yes = true;
            while (!queue.isEmpty()) {
            Node curr= queue.poll();
            if(curr.getBlockNo()==0) {yes=false;continue;}
            else{
                for(Node next:curr.getQueue()){
                    queue.add(next);
                }
            }
            }
           if(yes) System.out.println("YES");
            else System.out.println("NO");
        }

    }
}