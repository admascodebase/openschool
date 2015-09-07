package com.admas.logiware.dto.sms;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Yogesh B
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Message implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	public String locale;
	public String event;
	public int deliveryDelay;
	public String customerEmail;
	public String customerNumber;
	public String customerType;
	private Date DeliveredOn;

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public int getDeliveryDelay() {
		return deliveryDelay;
	}

	public void setDeliveryDelay(int deliveryDelay) {
		this.deliveryDelay = deliveryDelay;
	}

	public Date getDeliveredOn() {
		return DeliveredOn;
	}

	public void setDeliveredOn(Date deliveredOn) {
		DeliveredOn = deliveredOn;
	}

}