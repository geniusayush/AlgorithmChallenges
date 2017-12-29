import java.util.LinkedList;
import java.util.Queue;

public class NodeNew extends Node {
    String hash;

    NodeNew left;
    NodeNew right;

    public NodeNew(String hash, int blockNo) {
        super(blockNo);
        this.hash = hash;

    }
   // private Queue<Integer> queue = new LinkedList<Integer>();
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }


    public NodeNew getLeft() {
        return left;
    }

    public void setLeft(NodeNew left) {
        this.left = left;
    }

    public NodeNew getRight() {
        return right;
    }

    public void setRight(NodeNew right) {
        this.right = right;
    }


/*
    public Queue<Integer> getQueue() {
        return this.queue;
    }

    public void setQueue(Queue<Integer> queue) {
        this.queue = queue;
    }*/
}
