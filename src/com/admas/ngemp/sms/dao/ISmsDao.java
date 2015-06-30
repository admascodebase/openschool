package com.admas.ngemp.sms.dao;

import java.util.List;

import com.admas.ngemp.sms.dto.SmsTemplateDto;
import com.admas.ngemp.sms.exception.ExceptionHandler;
import com.admas.ngemp.sms.jpa.SmsConfig;


public interface ISmsDao {

	public List<SmsTemplateDto> getSmsTempltes();
	
	public SmsConfig getSmsConfig() throws ExceptionHandler;

	public boolean saveSms(SmsConfig smsConfig, String mobileNo,
			String message, String route)throws ExceptionHandler;
	

}
