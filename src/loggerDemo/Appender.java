package loggerDemo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ayush on 16/02/17.
 */
public class Appender {

    final String cN;
    final String s;
    Queue<String> queue;
    HashSet<String> set = new HashSet();

    public Appender(String computerName, String s) {
        this.cN = computerName;
        this.s = s;
        if(s.equals("SEVERE"))set.add(s);
        if(s.equals("DEBUG")){set.add("SEVERE");set.add(s);}
        if(s.equals("TRACE")){set.add("SEVERE");set.add("DEBUG");set.add(s);}


        queue = new LinkedBlockingQueue<>();
    }

    public void log(String text, Logger.LEVEL l, long currentTimeMillis) {

        boolean active = false;

           if(set.contains(l.getValue())) {
               queue.add(cN + ":" + new Timestamp(currentTimeMillis) + ":" + l.getValue() + text);
               synchronized (queue) {
                   queue.notifyAll();
               }
           }

    }
}
