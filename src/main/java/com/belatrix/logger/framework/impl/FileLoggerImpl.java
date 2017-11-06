package com.belatrix.logger.framework.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belatrix.logger.config.GlobalProperties;
import com.belatrix.logger.framework.FileLogger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FileLoggerImpl implements FileLogger {

	private Logger logger;
    
    @Autowired
    private GlobalProperties globalProperties;
    
    public void setGlobalProperties(GlobalProperties globalProperties) {
		this.globalProperties = globalProperties;
	}
    

    public FileLoggerImpl() {
        logger = Logger.getLogger("fileLog");
        try {
            String fileName = "/home/rasec/Documents/Otros/log.log";//globalProperties.getFileFolder() + File.separator + globalProperties.getFileName();
            File logFile = new File(fileName);
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            logger.addHandler(new FileHandler(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cannot create log file, please verified", e);
        }
    }

    @Override
    public void log(String message) {
        logger.log(Level.INFO, message);
    }

	public GlobalProperties getGlobalProperties() {
		return globalProperties;
	}

	
    
}
