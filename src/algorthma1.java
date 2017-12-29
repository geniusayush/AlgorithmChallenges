import java.util.*;

public class algorthma1 {
    static class Node {
        String hash;

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public int getBlockNo() {
            return blockNo;
        }

        public void setBlockNo(int blockNo) {
            this.blockNo = blockNo;
        }


        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node(String hash, int blockNo) {
            this.hash = hash;
            this.blockNo = blockNo;
        }

        int blockNo;
        Queue<Integer> queue=new LinkedList<Integer>();
        Node left;
        Node right;
    }
    static public class BST {
        public Node getNode() {
            return root;
        }

        public void setNode(Node node) {
            this.root = node;
        }

        Node root;

        public int searchMain(int l, int r, String hash) {
            return search(root, hash, l, r);
        }

        private int search(Node node, String hash, int l, int r) {
            int count=0;
            if(node==null)return 0;
            if (node.hash.equals(hash)) {
               for(int pos:node.queue){
                   if(pos>=l && pos<=r  )count++;
               }return count;
            }
            // val is greater than root's key
            if (node.hash.compareTo(hash) > 0) {
                return search(node.left, hash,l,r);

            } else {
                 return search(node.right,hash,l,r);

            }

        }
        public boolean insert( Node NewNode) {
            return insertLop(root, NewNode);
        }

        private boolean insertLop(Node node, Node newNode) {
            // Base Cases: root is null or key is present at root
            if (node.hash.equals(newNode.hash)) {
                node.queue.add(newNode.blockNo);
                return true;
            }
            // val is greater than root's key
            if (node.hash.compareTo(newNode.hash) > 0) {
                if (node.left != null) return insertLop(node.left, newNode);
                else {
                    newNode.queue.add(newNode.blockNo);
                    node.left = newNode;
                    return false;
                }
            } else {
                if (node.right != null) return insertLop(node.right,newNode);
                else {
                    newNode.queue.add(newNode.blockNo);
                    node.right = newNode;
                    return false;
                }
            }
        }
    }

        public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
            BST bst = new BST();
        for(int t = 0; t < n; t++) {
            arr[t]=sc.nextInt();
            Node node=new Node(arr[t]+"",t);

            if(t==0){node.queue.add(t);bst.root=node;}
            else bst.insert(node);
        }
        int q= sc.nextInt();
        for(int t = 0; t < q; t++) {
            int l=sc.nextInt();
            int r=sc.nextInt();
            int x=sc.nextInt();
            int count=bst.searchMain(l-1,r-1,x+"");
            System.out.println(count);
        }
    }
}