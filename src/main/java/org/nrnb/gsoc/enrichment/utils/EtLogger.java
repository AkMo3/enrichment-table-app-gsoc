package org.nrnb.gsoc.enrichment.utils;

import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class EtLogger {

    private static final Logger LOGGER = Logger.getLogger(EtLogger.class.getName());
    private static final ConsoleHandler handler = new ConsoleHandler();

    private static Level minimumLogLevel = Level.OFF;

    static {
        handler.setFormatter(new SimpleFormatter() {
            private static final String format = "[%1$tF %1$tT] %2$s %n";

            @Override
            public String formatMessage(LogRecord record) {
                return String.format(format,
                        new Date(record.getMillis()),
                        record.getMessage()
                );
            }
        });
        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(handler);
    }

    public static void setMinimumLogLevel(Level logLevel) {
        EtLogger.minimumLogLevel = logLevel;
    }

    public static void log(Level logLevel, String message) {
        if (logLevel.intValue() >= minimumLogLevel.intValue()) {
            LOGGER.log(logLevel, message);
        }
    }
}
