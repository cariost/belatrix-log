package com.belatrix.logger.config;

	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.belatrix.logger.util.Constants;

import com.belatrix.logger.framework.impl.ManagerLoggerImpl;

	@SpringBootApplication(scanBasePackages = {"com.belatrix.logger"})
	public class LoggerAppInit implements CommandLineRunner {

	    @Autowired
	    ManagerLoggerImpl managerLoggerImpl;

	    public void setManagerLoggerImpl(ManagerLoggerImpl managerLoggerImpl) {
			this.managerLoggerImpl = managerLoggerImpl;
		}
	    
	    public static void main(String[] args) {
	        SpringApplication.run(LoggerAppInit.class, args);
	    }

	    //Testing after the context has been loaded
	    @Override
	    public void run(String... args) throws Exception {
	    	managerLoggerImpl.logMessage("Consola Prueba", Constants.MessageType.Info, Constants.LogType.Console);
	    	managerLoggerImpl.logMessage("Consola Prueba 2", Constants.MessageType.Error, Constants.LogType.Console);
	    	managerLoggerImpl.logMessage("Prueba en Archivo", Constants.MessageType.Info, Constants.LogType.File);

	       
	    }

		

		
	    
	    
	    
	}	

