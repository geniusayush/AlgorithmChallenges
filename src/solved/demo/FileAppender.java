package solved.demo;

/**
 * Created by ayush on 16/02/17.
 */
class FileAppender extends Appender {

    private final String n;
    private final String l;

    public FileAppender(String computerName, String s, String n, String l) throws LoggerException {
        super(computerName, s);
        this.n = n;
        this.l = l;
        new FileRunner(queue, n, l).start();
    }


}
