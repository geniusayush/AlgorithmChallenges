import java.util.LinkedList;
import java.util.Queue;

public  class Node {

    public int getBlockNo() {
        return blockNo;
    }

    public void setBlockNo(int blockNo) {
        this.blockNo = blockNo;
    }

    public Node(int blockNo) {

        this.blockNo = blockNo;
    }

   private int blockNo;
   private Queue<Node> queue = new LinkedList<Node>();

    public Queue<Node> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Node> queue) {
        this.queue = queue;
    }
}
