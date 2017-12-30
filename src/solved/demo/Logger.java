package solved.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ayush on 16/02/17.
 */
public class Logger {
    public static String propFileName = "logger.properties";
    Properties prop = new Properties();
    ArrayList<Appender> list = new ArrayList<>();

    public Logger() throws LoggerException {
        this(propFileName);
    }

    public enum LEVEL {
        TRACE("TRACE"), SEVERE("SEVERE"), DEBUG("DEBUG");


        private final String value;

        LEVEL(String trace) {
            this.value = trace;
        }

        public String getValue() {
            return value;
        }
    }

    public Logger(String fileName) throws LoggerException {


        InputStream inputStream = null;
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
                String loggers = prop.getProperty("logger");
                if (loggers.contains("console")) {
                    list.add(initConsole());
                }
                if (loggers.contains("file")) {
                    list.add(initFile());
                }

            } else {
                throw new Exception("property file '" + fileName + "' not found in the classpath");
            }
        } catch (Exception e) {
            throw new LoggerException(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new LoggerException(e);
            }
        }
    }

    private Appender initFile() throws IOException, LoggerException {
        String s = prop.getProperty("logger.file.severe");
        String n = prop.getProperty("logger.file.name");
        String l = prop.getProperty("logger.file.location");
        return new FileAppender(getComputerName(), (s == null) ? "DEBUG" : (s), (n == null) ? "logs.txt" : n, (l == null) ? "." : l);
    }

    private Appender initConsole() {
        String s = prop.getProperty("logger.console.severe");
        return new ConsoleAppender(getComputerName(), (s == null) ? "DEBUG" : s);
    }


    public void log(String text, LEVEL l) {
        for (Appender a : list) {
            a.log(text, l, System.currentTimeMillis());
        }

    }

    private String getComputerName() {
        Map<String, String> env = System.getenv();
        if (env.containsKey("COMPUTERNAME"))
            return env.get("COMPUTERNAME");
        else if (env.containsKey("HOSTNAME"))
            return env.get("HOSTNAME");
        else
            return "Unknown Computer";
    }
}


