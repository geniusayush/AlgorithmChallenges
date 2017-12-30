package solved.demo;

/**
 * Created by ayush on 16/02/17.
 */
public class Main {
    public static void main(String[] args) throws LoggerException {
        Logger logger= new Logger();
        logger.log("hi", Logger.LEVEL.SEVERE);
        logger.log("hi 2", Logger.LEVEL.DEBUG);
        logger.log("hi 3", Logger.LEVEL.TRACE);
        //hack to end it
        logger.log("END",Logger.LEVEL.SEVERE);
    }
}
