import java.util.HashMap;

interface Cache<K, V> {
    V get(K key);

    void put(K key, V value);
}

class LRUCache<K, V> implements Cache<K,V> {


    HashMap<K, Node<K, V>> map = null;
    int cap;
    Node<K, V> head = null;
    Node<K, V> tail = null;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity;
    }

    @Override
    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }

        Node<K, V> t = map.get(key);

        remove(t);
        setHead(t);

        return t.getValue();
    }

    @Override
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> t = map.get(key);
            t.setValue(value);

            remove(t);
            setHead(t);
        } else {
            if (map.size() >= cap) {
                map.remove(tail.getKey());
                remove(tail);
            }

            Node<K, V> t = new Node<K, V>(key, value);
            setHead(t);
            map.put(key, t);
        }
    }

    //remove a node
    private void remove(Node<K, V> t) {
        if (t.getPrev() != null) {
            t.getPrev().setNext(t.getNext());
        } else {
            head = t.getNext();
        }

        if (t.getNext() != null) {
            t.getNext().setPrev(t.getPrev());
        } else {
            tail = t.getPrev();
        }
    }

    //set a node to be head
    private void setHead(Node<K, V> t) {
        if (head != null) {
            head.setPrev(t);
        }

        t.setNext(head);
        t.setPrev(null);
        head = t;

        if (tail == null) {
            tail = head;
        }
    }
    private class Node<T, U> {
        private T key;
        private U value;
        private Node<T, U> prev;
        private Node<T, U> next;

        public Node(T key, U value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public U getValue() {
            return value;
        }

        public void setValue(U value) {
            this.value = value;
        }

        public Node<T, U> getPrev() {
            return prev;
        }

        public void setPrev(Node<T, U> prev) {
            this.prev = prev;
        }

        public Node<T, U> getNext() {
            return next;
        }

        public void setNext(Node<T, U> next) {
            this.next = next;
        }
    }
}