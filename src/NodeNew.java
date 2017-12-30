import solved.Node;

public class NodeNew<E> extends Node<E> {
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
    }





}
