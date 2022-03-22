package org.nrnb.gsoc.enrichment.utils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class EtLogger {

    private static final Logger LOGGER = Logger.getLogger(EtLogger.class.getName());

    private static Level minimumLogLevel = Level.OFF;

    static {
        SimpleFormatter formatter = new SimpleFormatter() {
            private static final String format = "[%1$tF %1$tT] %2$s %n";

            @Override
            public String formatMessage(LogRecord record) {
                return String.format(format,
                        new Date(record.getMillis()),
                        record.getMessage()
                );
            }
        };

        try {
            Path p = Path.of("/home/akash/GitHub/ETLog/Ent_%g.log");
            System.out.println("Location of log file is: " + p);
            final FileHandler fileHandler = new FileHandler(p.toString(), 200, 5);
            fileHandler.setFormatter(formatter);
            LOGGER.addHandler(fileHandler);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        final ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(formatter);
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

