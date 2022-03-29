package LoggerSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class LoggerConsumer extends Thread {

    private final BufferedWriter bw;
    private final LinkedList<LoggerMessage> queue;

    public LoggerConsumer(String s, LinkedList<LoggerMessage> queue) throws Exception {
          File f = new File(s);
          if(!(f.exists() && f.canWrite()))throw new Exception("cannot open the log file");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        this.bw=bw;
        this.queue=queue;
    }

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
            LoggerMessage data = queue.remove();

            try {
                bw.write(data+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
