package solved.demo;

import java.util.Queue;

/**
 * Created by ayush on 16/02/17.
 */
public class ConsoleRunner extends Thread {
    private final Queue<String> queue;

    @Override
    public void run() {
        while (true) {
            while (queue.size() <= 0) {
                try {
                    synchronized (queue) {
                        queue.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            String data = queue.remove();
            if(data.endsWith("END"))return;
            System.out.println(data);

        }

    }

    public ConsoleRunner(Queue<String> queue) {
        this.queue = queue;
    }
}
