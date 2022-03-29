package LoggerSystem;

import java.util.ArrayList;
import java.util.LinkedList;

public class LoggerSystem {
    LinkedList<LoggerMessage> queue;
    LoggerConsumer cons;
    ArrayList<LoggerProducer> prod;

    public LoggerSystem(String s) throws Exception {

        queue = new LinkedList<>();
        cons = new LoggerConsumer(s, queue);
        cons.start();
        prod = new ArrayList<LoggerProducer>();
    }

    public  LoggerProducer getLogger(Class mainClass) {
return new LoggerProducer(mainClass,queue);
    }
}
