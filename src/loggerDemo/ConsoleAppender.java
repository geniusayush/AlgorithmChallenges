package loggerDemo;

/**
 * Created by ayush on 16/02/17.
 */
class ConsoleAppender extends Appender {

    public ConsoleAppender(String computerName, String s) {
        super(computerName, s);
        new ConsoleRunner(queue).start();
    }

}
