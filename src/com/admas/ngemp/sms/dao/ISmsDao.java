package com.admas.ngemp.sms.dao;

import java.util.List;

import com.admas.logiware.dto.sms.SmsDto;
import com.admas.logiware.dto.sms.SmsTemplateDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.jpa.sms.RawMessages;
import com.admas.logiware.jpa.sms.SmsConfig;
import com.admas.logiware.jpa.sms.SmsInbox;


public interface ISmsDao {

	public List<SmsTemplateDto> getSmsTempltes() throws LogiwareExceptionHandler;
	
	public SmsConfig getSmsConfig() throws LogiwareExceptionHandler;

	public boolean saveSms(String mobileNo,
			String message, String route ,String orgCode , String messageId)throws LogiwareExceptionHandler;

	public boolean saveAllSms(SmsDto smsDto, String mobileNos, SmsConfig config) throws LogiwareExceptionHandler;
	
	public List<SmsInbox> getSentSms() throws LogiwareExceptionHandler;

	public String getDeliveryReport(String orgCode, String messageId)throws LogiwareExceptionHandler;

	public void updateSmsInbox(SmsInbox smsInbox)throws LogiwareExceptionHandler;

	public boolean saveSmsAsync(SmsDto smsDto, String mobileNo)throws LogiwareExceptionHandler;

	public List<SmsInbox> getAsyncSms()throws LogiwareExceptionHandler;

	public RawMessages getrawsms(Integer integer)throws LogiwareExceptionHandler;

	


}
