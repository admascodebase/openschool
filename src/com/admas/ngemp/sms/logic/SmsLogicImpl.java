package com.admas.ngemp.sms.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.ngemp.sms.dao.ISmsDao;
import com.admas.ngemp.sms.dto.SmsDto;
import com.admas.ngemp.sms.dto.SmsTemplateDto;
import com.admas.ngemp.sms.exception.ExceptionHandler;
import com.admas.ngemp.sms.jpa.SmsConfig;
import com.admas.ngemp.sms.util.SMSUtil;

public class SmsLogicImpl implements ISmsLogic {

	Logger logger = LoggerFactory.getLogger(SmsLogicImpl.class);

	private static ISmsDao smsDaoImpl;

	public static ISmsDao getSmsDaoImpl() {
		return smsDaoImpl;
	}

	public static void setSmsDaoImpl(ISmsDao smsDaoImpl) {
		SmsLogicImpl.smsDaoImpl = smsDaoImpl;
	}

	@Override
	public List<SmsTemplateDto> getSmsTempltes() {
		return smsDaoImpl.getSmsTempltes();
	}

	@Override
	public String sendSms(String mobileNo, String message, String route, String orgCode)
			throws ExceptionHandler {
		String messageId = "";
		boolean result = false;
		try {
			SmsConfig smsConfig = smsDaoImpl.getSmsConfig();
			messageId = SMSUtil.sendSms(smsConfig, mobileNo, message, route);
			if (!messageId.equals("")) {
				result = smsDaoImpl.saveSms( mobileNo, message,
						route,orgCode, messageId);
				if (!result) {
					logger.error("failed to store sms details");
				}
			}
		} catch (ExceptionHandler ex) {
			throw ex;
		}
		return messageId;
	}

	@Override
	public Map<String, String> sendSms(SmsDto smsDto) throws ExceptionHandler {
		boolean result;
		Map<String,String> resultMap = new HashMap<String,String>();
		SmsConfig smsConfig = smsDaoImpl.getSmsConfig();
		for (String contactNo : smsDto.getContactNos()) {			
			String messageId = SMSUtil.sendSms(smsConfig, contactNo, smsDto.getMessage(), smsDto.getRoute().toString());
			if (!messageId.equals("")) {
				resultMap.put(contactNo, messageId);
				result = smsDaoImpl.saveSms( contactNo,  smsDto.getMessage(),smsDto.getRoute().toString(),smsDto.getOrgCode(), messageId);
				if (!result) {
					logger.error("failed to store sms details");
				}
			}
		}

		return resultMap;
	}

	@Override
	public String getDeleveryReport(String orgCode, String messageId) {

		String result = "";
		try {
			result = smsDaoImpl.getDeliveryReport(orgCode, messageId);
			return result;
		} catch (ExceptionHandler e) {

		}
		return result;
	}

	@Override
	public String getBalance(Integer route) throws ExceptionHandler {

		String result = "";
		try {

			SmsConfig smsConfig = smsDaoImpl.getSmsConfig();
			result = SMSUtil.getBalance(smsConfig, route.toString());
		} catch (ExceptionHandler e) {

		}

		return result;

	}

	@Override
	public boolean saveSms(SmsDto smsDto) throws ExceptionHandler {
		boolean Result =false;
		try{
			
			for (String mobileNo: smsDto.getContactNos()) {
				Result=smsDaoImpl.saveSmsAsync(smsDto, mobileNo);
			}
		return Result;
		}catch(Exception e){
			
		}
		return Result;
	}

}
