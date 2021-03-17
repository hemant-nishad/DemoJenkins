package com.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Logger.AppLogger;
import com.springboot.XMLService.SMSService;

@RestController
public class SMS {
	
	@Autowired
	SMSService SMSS;
	@Autowired
	AppLogger applogger;
	
	
	@GetMapping("/SendSMS")
	public String SendSMS(@RequestParam String MobileNumber, String msg)
	
	{
		return SMSS.SendSMS(MobileNumber, msg);	
		
	}
	
}
