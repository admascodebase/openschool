package com.admas.ngemp.sms.logic;

import java.util.List;
import java.util.Map;

import com.admas.logiware.dto.sms.SmsDto;
import com.admas.logiware.dto.sms.SmsTemplateDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;


public interface ISmsLogic {	

	public List<SmsTemplateDto> getSmsTempltes() throws LogiwareExceptionHandler;

	public String sendSms(String mobileNo, String message, String route , String orgCode) throws LogiwareExceptionHandler;

	public Map<String, String> sendSms(SmsDto smsDto)throws LogiwareExceptionHandler;

	public String getDeleveryReport(String orgCode, String messageId)throws LogiwareExceptionHandler;

	public String getBalance(Integer route)throws LogiwareExceptionHandler;

	public boolean saveSms(SmsDto smsDto)throws LogiwareExceptionHandler;
}
