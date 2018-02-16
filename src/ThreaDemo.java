class Q {
    int n;
    boolean mutex = false;

     int get() {
        System.out.println("Got: " + n);
        return n;
    }

     void put(int n) {
        this.n = n;
        System.out.println("Put: " + n);
    }
}

class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (true) {
            synchronized (q) {
                while (q.mutex) {
                    try {
                        q.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                q.put(i++);
                q.mutex=!q.mutex;
                q.notify();
            }

        }
    }
}

class Consumer implements Runnable {
    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            synchronized (q) {
                while (!q.mutex) {
                    try {
                        q.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                q.get();
                q.mutex=!q.mutex;
                q.notify();
            }

        }
    }
}

class PC {
    public static void main(String args[]) {

        Q q = new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("Press Control-C to stop.");
    }
}