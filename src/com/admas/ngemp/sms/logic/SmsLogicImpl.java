package com.admas.ngemp.sms.logic;

import java.util.List;

import com.admas.ngemp.sms.dao.ISmsDao;
import com.admas.ngemp.sms.dto.SmsTemplateDto;

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
	
	
}
