import solved.Node;

public class BST {
    /*
    public NodeNew getNode() {
        return root;
    }

    public void setNode(NodeNew node) {
        this.root = node;
    }

    NodeNew root;

    public int searchMain(int l, int r, String hash) {
        return search(root, hash, l, r);
    }

    private int search(NodeNew node, String hash, int l, int r) {
        int count = 0;
        if (node == null) return 0;
        if (node.hash.equals(hash)) {
            for (solved.Node pos : node.getQueue()) {
                if (pos >= l && pos <= r) count++;
            }
            return count;
        }
        // val is greater than root's key
        if (node.hash.compareTo(hash) > 0) {
            return search(node.left, hash, l, r);

        } else {
            return search(node.right, hash, l, r);

        }

    }

    public boolean insert(NodeNew NewNode) {
        return insertLop(root, NewNode);
    }

    private boolean insertLop(NodeNew root, NodeNew newNode) {
        return Boolean.parseBoolean(null);
    }

    private boolean insertLop(NodeNew node, NodeNew newNode) {
        // Base Cases: root is null or key is present at root
        if (node.hash.equals(newNode.hash)) {
            final boolean add;
            if (node.getQueue().add(newNode.getBlockNo())) add = true;
            else add = false;
            return true;
        }
        // val is greater than root's key
        newNode.getQueue().add(newNode.getBlockNo())
        if (node.hash.compareTo(newNode.hash) > 0) {
            if (node.left != null) return insertLop(node.left, newNode);
            else {
                node.left = newNode;
                return false;
            }
        } else {
            if (node.right != null) return insertLop(node.right, newNode);
            else {
                newNode.getQueue().add(newNode.getBlockNo());
                node.right = newNode;
                return false;
            }
        }
    }*/
}


 class NodeNew<E> extends Node<E> {
    public NodeNew(int blockNo, Class<E> cl) {
        super(blockNo, cl);
    }
    /*
    String hash;



    public NodeNew(String hash, int blockNo) {
        super(blockNo,);
        this.hash = hash;

    }
   // private Queue<Integer> queue = new LinkedList<Integer>();
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;

    */
}






