package solved;

import java.util.LinkedList;
import java.util.Queue;

public class Node<E> {

    public int getBlockNo() {
        return index;
    }

    public void setBlockNo(int blockNo) {
        this.index = blockNo;
    }

    public Node(int blockNo,Class<E> cl) {

        this.index = blockNo;

        queue= new LinkedList<E>();
    }

    private int index;
    private Node left;
    private Node right;
    private Queue<E> queue = new LinkedList<>();

    public Queue<E> getQueue() {
        return queue;
    }

    public void setQueue(Queue<E> queue) {
        this.queue = queue;
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
}
