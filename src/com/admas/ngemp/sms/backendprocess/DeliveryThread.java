package com.admas.ngemp.sms.backendprocess;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.ngemp.enumuration.MessageStatus;
import com.admas.ngemp.sms.dao.ISmsDao;
import com.admas.ngemp.sms.exception.ExceptionHandler;
import com.admas.ngemp.sms.jpa.SmsConfig;
import com.admas.ngemp.sms.jpa.SmsInbox;
import com.admas.ngemp.sms.util.SMSUtil;

public class DeliveryThread implements Runnable, Serializable {

	/**
	 * 
	 */
	
	Logger logger = LoggerFactory.getLogger(DeliveryThread.class);
	private static final long serialVersionUID = 1L;

	private static ISmsDao smsDaoImpl;

	public static ISmsDao getSmsDaoImpl() {
		return smsDaoImpl;
	}

	public static void setSmsDaoImpl(ISmsDao smsDaoImpl) {
		DeliveryThread.smsDaoImpl = smsDaoImpl;
	}

	/** The client thread. */
	private Thread clientThread = null;

	public DeliveryThread(ISmsDao smsDaoImpl) {
		DeliveryThread.smsDaoImpl = smsDaoImpl;
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
		
		String msgStatus="";
		try {
			List<SmsInbox> list = smsDaoImpl.getSentSms();
		 SmsConfig	smsConfig=smsDaoImpl.getSmsConfig();
			for (SmsInbox smsInbox : list) {
			
			msgStatus=SMSUtil.deleveryReport(smsConfig, smsInbox.getMsgId());
			
			logger.info("@@listofmsgs"+smsInbox.getMsgId()+"--->"+msgStatus+"$$$id=="+smsInbox.getId());
//			SmsInbox  inbox=new SmsInbox();
			if(msgStatus.equals(MessageStatus.SENT)){
				smsInbox.setMessageStatus(MessageStatus.SENT);
			}else if(msgStatus.equals(MessageStatus.DELIVERED)){
				smsInbox.setMessageStatus(MessageStatus.DELIVERED);
			}else if(msgStatus.equals(MessageStatus.DND)){
				smsInbox.setMessageStatus(MessageStatus.DND);
			}else if(msgStatus.equals(MessageStatus.FAILED)){
				smsInbox.setMessageStatus(MessageStatus.FAILED);
			}else if(msgStatus.equals(MessageStatus.PROCESSING)){
				smsInbox.setMessageStatus(MessageStatus.PROCESSING);
			}
			
			smsDaoImpl.updateSmsInbox(smsInbox);
			
			}
			Thread.sleep(100);
			
		} catch (ExceptionHandler e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
