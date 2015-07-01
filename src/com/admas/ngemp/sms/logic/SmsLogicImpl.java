package com.admas.ngemp.sms.logic;

import java.util.List;

import com.admas.ngemp.sms.dao.ISmsDao;
import com.admas.ngemp.sms.dto.SmsDto;
import com.admas.ngemp.sms.dto.SmsTemplateDto;
import com.admas.ngemp.sms.exception.ExceptionHandler;
import com.admas.ngemp.sms.jpa.SmsConfig;
import com.admas.ngemp.sms.util.SMSUtil;

public class SmsLogicImpl implements ISmsLogic{
	
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
	public String sendSms(String mobileNo, String message , String route) throws ExceptionHandler {
		String result = "";
		boolean result1=false;
		try{
			SmsConfig smsConfig = smsDaoImpl.getSmsConfig();
			result = SMSUtil.sendSms(smsConfig, mobileNo, message, route);
			if(!result.equals("")){
				result1=smsDaoImpl.saveSms(smsConfig, mobileNo, message, route);
			}
		}catch(ExceptionHandler ex){
			throw ex;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public String sendSms(SmsDto smsDto) throws ExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
