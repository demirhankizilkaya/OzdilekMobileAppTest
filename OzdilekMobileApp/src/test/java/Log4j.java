import org.apache.log4j.BasicConfigurator;

import java.util.logging.Logger;

public class Log4j {
    public static Logger log = Logger.getLogger(String.valueOf(Log4j.class));

    public static void main(String[] args) {
        BasicConfigurator.configure();
        log.info("This is Logger Info");
    }
}