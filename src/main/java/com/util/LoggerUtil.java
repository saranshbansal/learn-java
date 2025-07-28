package com.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoggerUtil {

    private LoggerUtil() {
        // Private constructor to prevent instantiation
    }

    /**
     * Returns a logger for the specified class
     * @param clazz the class for which the logger is created
     * @return the logger instance
     */
    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    /**
     * Returns a logger with the specified name
     * @param name the name of the logger
     * @return the logger instance
     */
    public static Logger getLogger(String name) {
        return LoggerFactory.getLogger(name);
    }
}
