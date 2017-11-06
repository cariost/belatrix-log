package com.belatrix.logger.framework.impl;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.belatrix.logger.framework.DatabaseLogger;
import com.belatrix.logger.util.Constants;


@Repository
public class DatabaseLoggerImpl implements DatabaseLogger {

    public Environment env;
    public JdbcTemplate jdbcTemplate;

    public DatabaseLoggerImpl(Environment env, JdbcTemplate jdbcTemplate) {
        this.env = env;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void log(String message, Constants.MessageType messageType) {
        int type = 0;
        switch (messageType){
            case Info:  type = 1; break;
            case Error: type = 2; break;
            case Warning: type = 3; break;
        }

        jdbcTemplate.update("Insert into log (message, type) values (?,?)",
                message, type);
    }


}
