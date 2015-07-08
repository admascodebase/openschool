package com.admas.ngemp.sms.dao;

import java.util.List;

import com.admas.ngemp.sms.dto.SmsDto;
import com.admas.ngemp.sms.dto.SmsTemplateDto;
import com.admas.ngemp.sms.exception.ExceptionHandler;
import com.admas.ngemp.sms.jpa.SmsConfig;
import com.admas.ngemp.sms.jpa.SmsInbox;


public interface ISmsDao {

	public List<SmsTemplateDto> getSmsTempltes();
	
	public SmsConfig getSmsConfig() throws ExceptionHandler;

	public boolean saveSms(SmsDto smsDto, String mobileNo,
			String message, String route , String messageId)throws ExceptionHandler;

	public boolean saveAllSms(SmsDto smsDto, String mobileNos, SmsConfig config) throws ExceptionHandler;
	
	public List<SmsInbox> getSentSms() throws ExceptionHandler;

	public String getDeliveryReport(String orgCode, String messageId)throws ExceptionHandler;

	public void updateSmsInbox(SmsInbox smsInbox)throws ExceptionHandler;

	


}
