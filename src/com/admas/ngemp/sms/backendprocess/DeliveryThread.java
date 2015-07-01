package com.admas.ngemp.sms.backendprocess;

import java.io.Serializable;
import java.util.List;

import com.admas.ngemp.sms.dao.ISmsDao;
import com.admas.ngemp.sms.exception.ExceptionHandler;
import com.admas.ngemp.sms.jpa.SmsInbox;

public class DeliveryThread implements Runnable, Serializable {

	/**
	 * 
	 */
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

	public DeliveryThread() {
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
		try {
			List<SmsInbox> list = smsDaoImpl.getSentSms();
			for (SmsInbox smsInbox : list) {
				
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
