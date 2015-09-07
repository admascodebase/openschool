package com.admas.ngemp.sms.dao;

import java.util.List;

import com.admas.logiware.dto.sms.SmsDto;
import com.admas.logiware.dto.sms.SmsTemplateDto;
import com.admas.logiware.jpa.sms.RawMessages;
import com.admas.logiware.jpa.sms.SmsConfig;
import com.admas.logiware.jpa.sms.SmsInbox;
import com.admas.ngemp.sms.exception.ExceptionHandler;


public interface ISmsDao {

	public List<SmsTemplateDto> getSmsTempltes();
	
	public SmsConfig getSmsConfig() throws ExceptionHandler;

	public boolean saveSms(String mobileNo,
			String message, String route ,String orgCode , String messageId)throws ExceptionHandler;

	public boolean saveAllSms(SmsDto smsDto, String mobileNos, SmsConfig config) throws ExceptionHandler;
	
	public List<SmsInbox> getSentSms() throws ExceptionHandler;

	public String getDeliveryReport(String orgCode, String messageId)throws ExceptionHandler;

	public void updateSmsInbox(SmsInbox smsInbox)throws ExceptionHandler;

	public boolean saveSmsAsync(SmsDto smsDto, String mobileNo)throws ExceptionHandler;

	public List<SmsInbox> getAsyncSms()throws ExceptionHandler;

	public RawMessages getrawsms(Integer integer)throws ExceptionHandler;

	


}
