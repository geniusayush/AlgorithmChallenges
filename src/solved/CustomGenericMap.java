package solved;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomGenericMap<E> {
    public CustomGenericMap(E c, int n) {

        this.matrix = (Entry[]) Array.newInstance(Entry.class, n);
        for (int i = 0; i < n; i++) {
            matrix[i] = new Entry<E>();
        }
    }

    public void add(int key, E value) {
        matrix[key].insert(value);

    }

    private Entry[] matrix;

    public int getLength() {
        return matrix.length;
    }

    public ArrayList<E> getList(int i) {
        return matrix[i].list;
    }

    private class Entry<E> {
        int size;

        public Entry() {
            this.list = new ArrayList<E>();
        }

       private ArrayList<E> list;

        public void insert(E value) {
            list.add(value);
            size++;
        }
    }
}


