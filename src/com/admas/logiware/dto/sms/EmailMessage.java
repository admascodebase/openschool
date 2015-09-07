package com.admas.logiware.dto.sms;

import java.io.Serializable;

import javax.activation.DataHandler;


public class EmailMessage extends Message implements Serializable {
	
	public MessageAttributes[] messageAttributes;
	public DataHandler[] attachments;
	public String attachmentFileName; 

	
	private Integer retryCount;

	public Integer getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}

	public MessageAttributes[] getMessageAttributes() {
		return messageAttributes;
	}

	public void setMessageAttributes(MessageAttributes[] messageAttributes) {
		this.messageAttributes = messageAttributes;
	}

	public DataHandler[] getAttachments() {
		return attachments;
	}

	public void setAttachments(DataHandler[] attachments) {
		this.attachments = attachments;
	}
	
	public String getAttachmentFileName() {
		return attachmentFileName;
	}

	public void setAttachmentFileName(String attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
	}
}