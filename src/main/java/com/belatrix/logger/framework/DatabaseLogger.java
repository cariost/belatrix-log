package com.belatrix.logger.framework;

import com.belatrix.logger.util.Constants;

public interface DatabaseLogger {
    void log(String message, Constants.MessageType messageType);
}
