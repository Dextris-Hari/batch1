package org.example.utils;

import java.io.IOException;
import java.util.logging.*;

public class LoggerObject {
private static final Logger LOGGER;//C:\Users\Dell\Desktop\logger4j

    public static Logger getLOGGER() {
        return LOGGER;
    }
    static {
        LOGGER = Logger.getLogger(LoggerObject.class.getName());

        try {
            // Creating Console Handler and FileHandler
            Handler fileHandler = new FileHandler("c:\\Users\\Dell\\Desktop\\logger4j\\file.log");//    E:\\LoggerInfo.log"
            Handler consoleHandler = new ConsoleHandler();

            // Assigning Handlers to logging object
            LOGGER.addHandler(consoleHandler);
            LOGGER.addHandler(fileHandler);

            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);

            // Setting levels To Handlers and Loggers
            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);

            LOGGER.config("Configuration Done");

            // Console handler removed
            LOGGER.removeHandler(consoleHandler);
            LOGGER.log(Level.FINE, "Finer Logged");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception in File Handler" + e);
        }
        LOGGER.finer("Finer Example on Logger Handler Completed");
    }
}
