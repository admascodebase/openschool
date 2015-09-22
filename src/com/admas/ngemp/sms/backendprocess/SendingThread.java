package com.admas.ngemp.sms.backendprocess;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.jpa.sms.RawMessages;
import com.admas.logiware.jpa.sms.SmsConfig;
import com.admas.logiware.jpa.sms.SmsInbox;
import com.admas.ngemp.enumuration.MessageStatus;
import com.admas.ngemp.sms.dao.ISmsDao;
import com.admas.ngemp.sms.util.SMSUtil;

public class SendingThread implements Runnable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 636503200596245692L;
	public SendingThread() {

	
	}
	
	Logger logger = LoggerFactory.getLogger(DeliveryThread.class);
	/**
	 * @return the smsDaoImpl
	 */
	public static ISmsDao getSmsDaoImpl() {
		return smsDaoImpl;
	}

	/**
	 * @param smsDaoImpl the smsDaoImpl to set
	 */
	public static void setSmsDaoImpl(ISmsDao smsDaoImpl) {
		SendingThread.smsDaoImpl = smsDaoImpl;
	}

	private static ISmsDao smsDaoImpl;

	private Thread clientThread = null;
	
	public SendingThread(ISmsDao smsDaoImpl) {
		SendingThread.smsDaoImpl = smsDaoImpl;
		this.startClient();
	}

	private synchronized void startClient() {
		if (clientThread == null) {
			clientThread = new Thread(this, "DeliveryReportThread");
			clientThread.start();
		}
	}

	@Override
	public void run() {
		while (true) {
			
			try {
				List<SmsInbox> list = smsDaoImpl.getAsyncSms();
				SmsConfig smsConfig = smsDaoImpl.getSmsConfig();
				for (SmsInbox smsInbox : list) {
					logger.info("in sending thread" + smsInbox.getMobile());
					Date date=new Date();
					RawMessages messages = smsDaoImpl.getrawsms(smsInbox.getRawMsgId());
					String messageId = SMSUtil.sendSms(smsConfig, smsInbox.getMobile(), messages.getMsg(), smsInbox.getRoute().toString());
					
					smsInbox.setSentOn(date);
					smsInbox.setMessageStatus(MessageStatus.PROCESSING);
					smsInbox.setMsgId(messageId);
					smsDaoImpl.updateSmsInbox(smsInbox);
				}
				Thread.sleep(100);

			} catch (LogiwareExceptionHandler e1) {
			} catch (InterruptedException e) {
			}
		}

	}

}
