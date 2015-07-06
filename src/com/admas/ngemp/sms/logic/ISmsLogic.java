package com.admas.ngemp.sms.logic;

import java.util.List;

import com.admas.ngemp.sms.dto.SmsDto;
import com.admas.ngemp.sms.dto.SmsTemplateDto;
import com.admas.ngemp.sms.exception.ExceptionHandler;


public interface ISmsLogic {	

	public List<SmsTemplateDto> getSmsTempltes();

	public String sendSms(String mobileNo, String message, String route) throws ExceptionHandler;

	public String sendSms(SmsDto smsDto)throws ExceptionHandler;

	public String getDeleveryReport(String orgCode, String messageId)throws ExceptionHandler;

	public String getBalance(Integer route)throws ExceptionHandler;
}
