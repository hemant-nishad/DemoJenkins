package com.springboot.Model;

import org.springframework.stereotype.Component;

@Component
public class InputParam {
	
	int MobileNumber;
	String msg;
	
	public void setMobileNumber(int mobileNumber) {
		MobileNumber = mobileNumber;
	}
	
	public int getMobileNumber() {
		return MobileNumber;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

	public String getMsg() {
		return msg;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
