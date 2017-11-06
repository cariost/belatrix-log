package com.belatrix.logger.framework.impl;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.belatrix.logger.framework.ConsoleLogger;
//import com.belatrix.logger.util.LoggerHandlerCustom;



@Service
public class ConsoleLoggerImpl implements ConsoleLogger {

    private Logger logger;

    public ConsoleLoggerImpl() {
        logger = Logger.getLogger("Console");
        logger.addHandler(new ConsoleHandler());
    }

    @Override
    public void log(String message) {
        logger.log(Level.INFO, message);
    }
}
