package com.admas.ngemp.sms.logic;

import java.util.List;
import java.util.Map;

import com.admas.ngemp.sms.dto.SmsDto;
import com.admas.ngemp.sms.dto.SmsTemplateDto;
import com.admas.ngemp.sms.exception.ExceptionHandler;


public interface ISmsLogic {	

	public List<SmsTemplateDto> getSmsTempltes();

	public String sendSms(String mobileNo, String message, String route , String orgCode) throws ExceptionHandler;

	public Map<String, String> sendSms(SmsDto smsDto)throws ExceptionHandler;

	public String getDeleveryReport(String orgCode, String messageId)throws ExceptionHandler;

	public String getBalance(Integer route)throws ExceptionHandler;
}
