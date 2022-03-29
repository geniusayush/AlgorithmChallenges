package loggerDemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

/**
 * Created by ayush on 16/02/17.
 */
class FileRunner extends Thread {
    private final Queue<String> queue;
    private final String n;
    private final String l;
    private final FileWriter writer;

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
            if (data.endsWith("END")) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {

                    return;
                }
            }
            try {
                writer.write(data+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public FileRunner(Queue<String> queue, String n, String l) throws LoggerException {
        this.queue = queue;
        this.n = n;
        this.l = l;
        try {
            File f = new File(l + "/" + n);
            if (!f.exists()) f.createNewFile();
            this.writer = new FileWriter(f);
        } catch (Exception e) {
            throw new LoggerException(e);
        }
    }
}
