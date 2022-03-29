package LoggerSystem;

public class Main {
    public static void main(String[] args) throws Exception {
       LoggerSystem system= new LoggerSystem("D://media_net.log");
        LoggerProducer logger = system.getLogger(Main.class);
        logger.print(LEVEL.DEBUG,"message1");
    }

}
