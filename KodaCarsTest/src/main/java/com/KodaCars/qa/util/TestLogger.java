package com.KodaCars.qa.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {
	
	    private static final Logger logger = LogManager.getLogger(TestLogger.class);

	    static {
	        // Static initializer block
	    }

	    public TestLogger() {
	        
	    }

	    public void info(String message) {
	        logger.info(message);
	    }

	    public void warn(String message) {
	        logger.warn(message);
	    }

	    public void error(String message) {
	        logger.error(message);
	    }

	    public void fatal(String message) {
	        logger.fatal(message);
	    }

	    public void debug(String message) {
	        logger.debug(message);
	    }
	}


