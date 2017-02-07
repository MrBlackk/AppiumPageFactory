package utils;

import org.apache.log4j.Logger;
import org.testng.Reporter;

/**
 * Created by chv on 07.02.2017.
 *
 * Log4Test configuration class
 */
public class Log4Test {
    private static final Logger LOGGER = Logger.getLogger(Log4Test.class);

    // ****************** Default message content ********************
    private static final String INFO_LOG = "INFO: \"%s\"";
    private static final String ERROR_LOG = "ERROR: \"%s\" !";
    private static final String TEST_LOG = "TEST: \"%s\"";

    private Log4Test() {
    }

    public static String error(String message) {
        LOGGER.error(String.format(ERROR_LOG, message));
        Reporter.log(String.format(ERROR_LOG, message));
        return String.format(ERROR_LOG, message);
    }

    public static String info(String message) {
        LOGGER.info(String.format(INFO_LOG, message));
        Reporter.log(String.format(INFO_LOG, message));
        return String.format(INFO_LOG, message);
    }

    public static String test(String message) {
        LOGGER.info(String.format(TEST_LOG, message));
        Reporter.log(String.format(TEST_LOG, message));
        return String.format(TEST_LOG, message);
    }
}
