import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class Demo {
    private static class Node {
        Node parent;

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ArrayList<Node> getChildren() {
            return children;
        }

        public void setChildren(Node children) {
            this.children.add(children);
        }

        public Node(int value) {

            this.value = value;
            this.children = new ArrayList<Node>();
        }

        int value;
        ArrayList<Node> children;

    }

    public static void main(String[] args) {

    }
    static int[] getPreOrder(int[] arr) {
        ArrayList<Integer> list= new ArrayList<Integer>();
        int a=0;int b=arr.length;
        int pos=getMinValue(arr,0,arr.length);
        list.add(arr[pos]);
        return convertIntegers(list);


    }
    public static int[] convertIntegers(ArrayList<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }

    public static ArrayList<Integer>  fuck(int[] arr, ArrayList<Integer> list,int a,int b)
    {   if(a<b ||a<0 ||a>=arr.length||a<0 ||a>=arr.length)return list;
        int pos=getMinValue(arr,a,b);
        list.add(arr[pos]);
        fuck(arr,list,a,pos);
        fuck(arr,list,pos+1,b);
        return list;
    }
    public static int getMinValue(int[] array,int a,int b) {
        int minValue = array[0];
        int pos=0;
        for (int i = a; i < array.length && i<=b; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                pos=i;
            }
        }
        return minValue;
    }

    public static void fuckoff(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int x = 0; x < cases; x++) {
            int n = scan.nextInt();
            int q = scan.nextInt();
            Node[] arr = new Node[n + 1];
            for (int j = 0; j < n; j++) {
                arr[j + 1] = new Node(scan.nextInt());
            }
            for (int j = 0; j < n - 1; j++) {
                int a = scan.nextInt();
                int b = scan.nextInt();
                arr[b].setParent(arr[a]);
                arr[a].setChildren(arr[b]);
            }
            for (int j = 0; j < q; j++) {
                int u = scan.nextInt();
                int i = scan.nextInt();
                HashSet<Node> set = new HashSet<>();
                HashSet<Node> set2 = new HashSet<>();
                set2.add(arr[u]);
                printKDistant(arr[1], i - 1, set).retainAll(decendents(arr[u], set2));

                int sum = 0;
                for (Node Nodes : set) {
                    sum += Nodes.getValue();
                }
                System.out.println(sum);
            }

        }
    }

    static HashSet<Node> printKDistant(Node Nodes, int k, HashSet<Node> set) {
        if(Nodes==null ||k<0)
        return set;
        if (k == 0) {
            set.add(Nodes);
            return set;
        } else {
            for (Node n : Nodes.getChildren()) {
                printKDistant(n, k - 1, set);

            }
            return set;
        }
    }

    static HashSet<Node> decendents(Node Nodes, HashSet<Node> set) {
        if(Nodes==null )
            return set;
        for (Node n : Nodes.getChildren()) {
            set.add(n);
            decendents(n, set);
        }
        return set;
    }
}