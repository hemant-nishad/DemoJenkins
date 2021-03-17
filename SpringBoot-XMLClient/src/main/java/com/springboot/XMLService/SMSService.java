package com.springboot.XMLService;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import com.springboot.Logger.AppLogger;
import com.springboot.Logger.Log4j2Logger;

@Component
public class SMSService {
	
	@Autowired
	AppLogger logger;
	
	@Value("${SMS_Service_IP}")
	String SMS_Service_IP;
	
	@Value("${SMS_Service_Port}")
	String SMS_Service_Port;
	
	@Value("${SMS_User}")
	String SMS_User;
	@Value("${SMS_Password}")
	String SMS_Password;
	@Value("${SMS_Authorization}")
	String SMS_Authorization;
	@Value("${SMS_Content_Type}")
	String SMS_Content_Type;
	@Value("${SMS_Connection}")
	String SMS_Connection;
	@Value("${SMS_X_Forwarded_For}")
	String SMS_X_Forwarded_For;
	@Value("${SMS_Cache_Control}")
	String SMS_Cache_Control;
	@Value("${SMS_Pragma}")
	String SMS_Pragma;
	@Value("${SMS_User_Agent}")
	String SMS_User_Agent;
	@Value("${SMS_Accept}")
	String SMS_Accept;
	@Value("${SMS_XML}")
	String SMS_XML;
	
	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
	    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
	    loggingFilter.setIncludeClientInfo(true);
	    loggingFilter.setIncludeQueryString(true);
	    loggingFilter.setIncludePayload(true);
	    loggingFilter.setIncludeHeaders(false);
	    return loggingFilter;
	}
	
	
		
	public String SendSMS(String MobileNumber,String msg)
	{
		
		try {
			SMS_XML=SMS_XML.replaceAll("MessageToBeReplaced", msg);
			SMS_XML=SMS_XML.replaceAll("MobileToBeReplaced", MobileNumber);
			
			
			
			
			URL url = new URL("http://"+SMS_Service_IP+":" +SMS_Service_Port);
			logger.InfoLog(url.toString());
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			
			// Set timeout as per needs
			conn.setConnectTimeout(1000);
			conn.setReadTimeout(1000);
		    
			// Set Headers
			String Auth = SMS_User+":"+SMS_Password;
			Auth = Auth.trim();
			
			String AuthCode = "Basic "+ Base64.getEncoder().encodeToString(Auth.getBytes());
			
			conn.setRequestProperty("Authorization", AuthCode);
			conn.setRequestProperty("Content-Type", SMS_Content_Type);
			conn.setRequestProperty("Connection",SMS_Connection);
			conn.setRequestProperty("X-Forwarded-For",SMS_X_Forwarded_For);
			conn.setRequestProperty("Cache-Control",SMS_Cache_Control);
			conn.setRequestProperty("Pragma",SMS_Pragma);
			conn.setRequestProperty("User-Agent",SMS_User_Agent);
			conn.setRequestProperty("Accept",SMS_Accept);
			
			logger.InfoLog(SMS_XML);
			logger.InfoLog(url.toString());
			logger.InfoLog(conn.getRequestProperty("Authorization"));
			logger.InfoLog(conn.getRequestProperty("Content-Type"));
			logger.InfoLog(conn.getRequestProperty("Connection"));
			logger.InfoLog(conn.getRequestProperty("X-Forwarded-For"));
			logger.InfoLog(conn.getRequestProperty("Cache-Control"));
			logger.InfoLog(conn.getRequestProperty("Pragma"));
			logger.InfoLog(conn.getRequestProperty("User-Agent"));
			logger.InfoLog(conn.getRequestProperty("Accept"));
			
			
			// Set DoOutput to true if you want to use URLConnection for output.
			// Default is false
			conn.setDoOutput(true);
	
			// Write XML
			OutputStream outputStream = conn.getOutputStream();
			byte[] b = SMS_XML.getBytes("UTF-8");
			outputStream.write(b);
			outputStream.flush();
			outputStream.close();

			//System.out.println(conn.getResponseCode());
			// Read XML
			//InputStream inputStream = conn.getInputStream();
			//byte[] res = new byte[2048];
			//int i = 0;
			//StringBuilder response = new StringBuilder();
			//while ((i = inputStream.read(res)) != -1) {
			//	response.append(new String(res, 0, i));
			//}
			//inputStream.close();
		
			logger.InfoLog("0~0~"+conn.getResponseCode()+"~"+conn.getResponseMessage());
			return "0~0~"+conn.getResponseCode()+"~"+conn.getResponseMessage();
			}
		
		catch (Exception e) {
			if(e.toString().startsWith("java.net.SocketTimeoutException"))
			{
				logger.ErrorLog(e.toString());
				logger.ErrorLog("2~777");
				return "2~777";
			}
			else
				
			{
				e.printStackTrace();
				logger.ErrorLog(e.toString());
				logger.ErrorLog("3~N10~"+e.toString());
				return "3~N10~"+e.toString();
			}
			}
	}

}
