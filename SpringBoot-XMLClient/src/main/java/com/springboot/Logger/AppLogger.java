package com.springboot.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AppLogger {
	
	Logger aplog = LoggerFactory.getLogger(AppLogger.class);;
	
	
	public void ErrorLog(String msg)
	
	{
		
		aplog.error(msg);
		
		
	}
	
	public void DebugLog(String msg)
	
	{
		aplog.debug(msg);
		
	}
	
	public void InfoLog(String msg)
	
	{
		aplog.info(msg);
		
	}
	

}
