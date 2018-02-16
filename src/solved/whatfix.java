package solved;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class whatfix {
    class Word {
        public Word(Character character, int freq) {
            this.character = character;
            this.freq = freq;
        }

        Character character;
        int freq;
    }

    public void print(String words) {
        HashMap<Character, Word> map = new HashMap();
        for (int i = 0; i < words.length(); i++) {
            if (map.containsKey(words.charAt(i))) {
                map.put(words.charAt(i), new Word(words.charAt(i), map.get(words.charAt(i)).freq + 1));
            } else {
                map.put(words.charAt(i), new Word(words.charAt(i), 1));
            }
        }
        Word[] sol = map.values().toArray(new Word[0]);
        Arrays.sort(sol, new Comparator<Word>() {

            @Override
            public int compare(Word o1, Word o2) {
                if (o1.freq > o2.freq) return -1;
                else if (o1.freq == o2.freq) return (o1.character < o2.character) ? -1 : 1;
                else return 1;
            }
        });
        for (Word w : sol) {
            System.out.println(w.character + "+" + w.freq);
        }
    }

    public void wtfix(int pos) {
        int inc = 1;
        int prev = 0;
        int curr = 0;
        while (curr < pos) {
            prev = curr;
            curr = curr + inc;
            inc++;
        }
        if (curr == pos) System.out.println(inc - 1);
        else {
            System.out.println(pos - prev);
        }
    }

    public static void main(String[] args) {
        String val = "bcdda";
        //1 3 6 10 15 21 28 36 45 55
        // new whatfix().wtfix(54);ne
        Boolean b = new Boolean(false);
        new t1("t1", b).start();
        new t2("t2", b).start();
    }


}

class t1 extends Thread {
    public t1(String name, Boolean b) {
        super(name);
        this.b = b;
    }

    int value = 100;
    Boolean b;

    public void run() {
        int num = 0;

        while (num <= value) {

            while (b) {
                try {
                        synchronized (b) {
                            wait();
                        }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(num);
            num += 2;
            b = !b.booleanValue();
            b.notify();
        }
    }


}


class t2 extends Thread {
    public t2(String name, Boolean b) {
        super(name);
        this.b = b;
    }

    int value = 100;
    Boolean b;

    public void run() {
        int num = 1;
        while (num <= value) {

            while (!b) {
                try {
                    synchronized (b) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(num);
            num += 2;
            b = !b.booleanValue();
            b.notify();
        }
    }
}




