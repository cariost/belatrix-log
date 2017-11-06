package com.belatrix.logger.service;

import com.belatrix.logger.util.Constants;

public interface LoggerServiceInterface {
	
	void log(String message, Constants.MessageType messageType);

}
