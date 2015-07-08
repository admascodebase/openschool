package com.admas.ngemp.sms.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.admas.ngemp.enumuration.MessageStatus;


@Entity
@Table(name="sms_inbox")
public class SmsInbox implements Serializable{

	/**
	 * @return the rawMessages
	 */
	public RawMessages getRawMessages() {
		return rawMessages;
	}

	/**
	 * @param rawMessages the rawMessages to set
	 */
	public void setRawMessages(RawMessages rawMessages) {
		this.rawMessages = rawMessages;
	}

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -9032902834294251178L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="ORG_CODE")
	private String orgCode;
	
	@Column(name="ROUTE")
	private Integer route;
	
	@Column(name="MOBILE")
	private String mobile;
	
	@OneToMany
	@JoinColumn(name="RAW_MSG_ID")
	private RawMessages rawMessages;

		
	@Column(name="MSG_ID")
	private String msgId;
	
	@Column(name="MSG_PUSH_ID")
	private String msgPushId;
	
	@Column(name="MSG_STATUS")
	@Enumerated(EnumType.STRING)
    private MessageStatus messageStatus;
	
	@Column(name="SENT_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sentOn;
	
	@Column(name="DELEVERED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deleveredOn;
	
	@Column(name="DEL_FLG")
	private String delFlg;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the orgCode
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * @param orgCode the orgCode to set
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * @return the route
	 */
	public Integer getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(Integer route) {
		this.route = route;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	

	/**
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId the msgId to set
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	/**
	 * @return the msgPushId
	 */
	public String getMsgPushId() {
		return msgPushId;
	}

	/**
	 * @param msgPushId the msgPushId to set
	 */
	public void setMsgPushId(String msgPushId) {
		this.msgPushId = msgPushId;
	}

	

	/**
	 * @return the messageStatus
	 */
	public MessageStatus getMessageStatus() {
		return messageStatus;
	}

	/**
	 * @param messageStatus the messageStatus to set
	 */
	public void setMessageStatus(MessageStatus messageStatus) {
		this.messageStatus = messageStatus;
	}

	/**
	 * @return the delFlg
	 */
	public String getDelFlg() {
		return delFlg;
	}

	/**
	 * @param delFlg the delFlg to set
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	/**
	 * @return the sentOn
	 */
	public Date getSentOn() {
		return sentOn;
	}

	/**
	 * @param sentOn the sentOn to set
	 */
	public void setSentOn(Date sentOn) {
		this.sentOn = sentOn;
	}

	/**
	 * @return the deleveredOn
	 */
	public Date getDeleveredOn() {
		return deleveredOn;
	}

	/**
	 * @param deleveredOn the deleveredOn to set
	 */
	public void setDeleveredOn(Date deleveredOn) {
		this.deleveredOn = deleveredOn;
	}
	
	

	
}
