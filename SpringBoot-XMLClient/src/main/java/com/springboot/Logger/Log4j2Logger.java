package com.springboot.Logger;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class Log4j2Logger {
	
	Logger logger = java.util.logging.Logger.getLogger(Log4j2Logger.class.getName());
	
	public void ErrorLog(String msg)
	
	{
		
		logger.info(msg);
		
		
	}
	
	public void DebugLog(String msg)
	
	{
		logger.info(msg);
		
	}
	
	public void InfoLog(String msg)
	
	{
		logger.info(msg);
		
	}
	

}
