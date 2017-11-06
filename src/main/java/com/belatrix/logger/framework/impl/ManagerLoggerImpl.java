package com.belatrix.logger.framework.impl;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belatrix.logger.framework.ConsoleLogger;
import com.belatrix.logger.framework.DatabaseLogger;
import com.belatrix.logger.framework.FileLogger;
import com.belatrix.logger.util.Constants;

@Service
public class ManagerLoggerImpl {

	@Autowired
    private ConsoleLogger consoleLog;
	
	@Autowired
    private FileLogger fileLogger;
	
	/*@Autowired
    private DatabaseLogger databaseLogger;*/



    public void logMessage(String inputMessage, Constants.MessageType messageType, Constants.LogType logType) throws Exception {
        if (inputMessage == null || inputMessage.trim().isEmpty()) {
            throw new Exception("Please send a valid message");
        }

        if (messageType == null || logType == null) {
            throw new Exception("Message type/Log Type must be specified");
        }

        StringBuilder messageToLog = new StringBuilder();

        switch (messageType) {
            case Error: messageToLog.append("error "); break;
            case Warning: messageToLog.append("warning "); break;
            case Info: messageToLog.append("info "); break;
        }

        messageToLog.append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + inputMessage);

        switch (logType) {
            case File: fileLogger.log(messageToLog.toString()); break;
            case Console: consoleLog.log(messageToLog.toString()); break;
            //case DB: databaseLogger.log(messageToLog.toString(), messageType); break;
		default:
			break;
        }
    }


	public ConsoleLogger getConsoleLog() {
		return consoleLog;
	}


	public void setConsoleLog(ConsoleLogger consoleLog) {
		this.consoleLog = consoleLog;
	}


	public FileLogger getFileLogger() {
		return fileLogger;
	}


	public void setFileLogger(FileLogger fileLogger) {
		this.fileLogger = fileLogger;
	}


	/*	public DatabaseLogger getDatabaseLogger() {
		return databaseLogger;
	}


	public void setDatabaseLogger(DatabaseLogger databaseLogger) {
		this.databaseLogger = databaseLogger;
	}*/
	
	
    
    
}
