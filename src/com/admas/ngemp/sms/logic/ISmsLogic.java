package com.admas.ngemp.sms.logic;

import java.util.List;

import com.admas.ngemp.sms.dto.SmsTemplateDto;
import com.admas.ngemp.sms.exception.ExceptionHandler;


public interface ISmsLogic {	

	public List<SmsTemplateDto> getSmsTempltes();

	public String sendSms(String mobileNo, String message, String route) throws ExceptionHandler;
}
