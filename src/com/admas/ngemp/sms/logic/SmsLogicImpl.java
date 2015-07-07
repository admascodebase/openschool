package com.admas.ngemp.sms.logic;

import java.util.Iterator;
import java.util.List;

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
	public String sendSms(String mobileNo, String message, String route)
			throws ExceptionHandler {
		String messageId = "";
		boolean result = false;
		try {
			SmsConfig smsConfig = smsDaoImpl.getSmsConfig();
			messageId = SMSUtil.sendSms(smsConfig, mobileNo, message, route);
			if (!messageId.equals("")) {
				result = smsDaoImpl.saveSms(smsConfig, mobileNo, message,
						route, messageId);
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
	public String sendSms(SmsDto smsDto) throws ExceptionHandler {

		String result = "";

		Iterator<String> iterator = smsDto.getContactNos().iterator();
		String mobileNos = "";

		while (iterator.hasNext()) {

			Object object = iterator.next();

			mobileNos += "," + object.toString();

		}
		result = sendSms(mobileNos, smsDto.getMessage(), smsDto.getRoute()
				.toString());
		SmsConfig config = smsDaoImpl.getSmsConfig();
		boolean res = smsDaoImpl.saveAllSms(smsDto, mobileNos, config);

		return result;
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

}
