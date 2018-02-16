import java.util.ArrayList;

public   class HeapNode {
   private  HeapNode parent;

    public HeapNode getParent() {
        return parent;
    }

    public void setParent(HeapNode parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<HeapNode> getChildren() {
        return children;
    }

    public void setChildren(HeapNode children) {
        this.children.add(children);
    }

    public HeapNode(int value) {

        this.value = value;
        this.children = new ArrayList<HeapNode>();
    }

    int value;
    ArrayList<HeapNode> children;

}
