package com.admas.ngemp.sms.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dto.sms.SmsDto;
import com.admas.logiware.dto.sms.SmsTemplateDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.sms.SmsConfig;
import com.admas.ngemp.sms.dao.ISmsDao;
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
	public List<SmsTemplateDto> getSmsTempltes() throws LogiwareExceptionHandler {
		try {
			return smsDaoImpl.getSmsTempltes();
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in SmsLogicImpl - > getSmsTempltes ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
	}

	@Override
	public String sendSms(String mobileNo, String message, String route,
			String orgCode) throws LogiwareExceptionHandler {
		String messageId = "";
		boolean result = false;
		try {
			SmsConfig smsConfig = smsDaoImpl.getSmsConfig();
			messageId = SMSUtil.sendSms(smsConfig, mobileNo, message, route);
			if (!messageId.equals("")) {
				result = smsDaoImpl.saveSms(mobileNo, message, route, orgCode,
						messageId);
				if (!result) {
					throw new LogiwareExceptionHandler(
							LogiwareServiceErrors.GENERIC_EXCEPTION);
				}
			}
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in SmsLogicImpl - > sendSms ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return messageId;
	}

	@Override
	public Map<String, String> sendSms(SmsDto smsDto)
			throws LogiwareExceptionHandler {
		boolean result;
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			SmsConfig smsConfig = smsDaoImpl.getSmsConfig();
			for (String contactNo : smsDto.getContactNos()) {
				String messageId = SMSUtil.sendSms(smsConfig, contactNo,
						smsDto.getMessage(), smsDto.getRoute().toString());
				if (!messageId.equals("")) {
					resultMap.put(contactNo, messageId);
					result = smsDaoImpl.saveSms(contactNo, smsDto.getMessage(),
							smsDto.getRoute().toString(), smsDto.getOrgCode(),
							messageId);
					if (!result) {
						throw new LogiwareExceptionHandler(
								LogiwareServiceErrors.SMS_SAVING_FAIL);
					}
				}
			}
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in SmsLogicImpl - > sendSms ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return resultMap;
	}

	@Override
	public String getDeleveryReport(String orgCode, String messageId) throws LogiwareExceptionHandler{

		String result = "";
		try {
			result = smsDaoImpl.getDeliveryReport(orgCode, messageId);
			return result;
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in SmsLogicImpl - > getDeleveryReport ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
	}

	@Override
	public String getBalance(Integer route) throws LogiwareExceptionHandler {

		String result = "";
		try {
			SmsConfig smsConfig = smsDaoImpl.getSmsConfig();
			result = SMSUtil.getBalance(smsConfig, route.toString());
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in SmsLogicImpl - > getBalance ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}

		return result;

	}

	@Override
	public boolean saveSms(SmsDto smsDto) throws LogiwareExceptionHandler {
		boolean Result = false;
		try {

			for (String mobileNo : smsDto.getContactNos()) {
				try{
					Result = smsDaoImpl.saveSmsAsync(smsDto, mobileNo);
				} catch (LogiwareExceptionHandler e) {
					logger.error("Exception Error in SmsLogicImpl - > saveSms ",
							e);
				} catch (Exception e) {
					logger.error("Exception Error in SmsLogicImpl - > saveSms ",
							e);
				}
			}
			return Result;
		} catch (Exception e) {
			logger.error("Exception Error in SmsLogicImpl - > saveSms ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
	}

}
