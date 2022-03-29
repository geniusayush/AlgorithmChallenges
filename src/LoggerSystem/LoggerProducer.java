package LoggerSystem;

import java.util.LinkedList;

public class LoggerProducer {
    private final LinkedList<LoggerMessage> queue;
    String id;

    public LoggerProducer(Class mainClass, LinkedList<LoggerMessage> queue) {
        this.id = mainClass.getCanonicalName();
        this.queue = queue;
    }

    public void print(LEVEL debug, String message1) {

        synchronized (queue) {
            queue.add(new LoggerMessage(System.currentTimeMillis(), id, debug, message1));
            queue.notify();
        }
    }

}
