package com.admas.ngemp.sms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admas.ngemp.enumuration.MessageStatus;
import com.admas.ngemp.sms.dto.SmsDto;
import com.admas.ngemp.sms.dto.SmsTemplateDto;
import com.admas.ngemp.sms.exception.CommServiceErrors;
import com.admas.ngemp.sms.exception.ExceptionHandler;
import com.admas.ngemp.sms.jpa.RawMessages;
import com.admas.ngemp.sms.jpa.SmsConfig;
import com.admas.ngemp.sms.jpa.SmsInbox;

@Repository
public class SmsDaoImpl implements ISmsDao {

	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(SmsDaoImpl.class);

	/**
	 * @param entityManager
	 *            the entityManager to set
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		SmsDaoImpl.entityManager = entityManager;
	}

	public SmsDaoImpl() {
		super();
	}

	@Override
	public List<SmsTemplateDto> getSmsTempltes() {
		List<SmsTemplateDto> lSmsTemplates = new ArrayList<SmsTemplateDto>();
		TypedQuery<com.admas.ngemp.sms.jpa.SmsTemplate> customerQuery = null;
		try {
			customerQuery = entityManager.createQuery(
					"SELECT s FROM com.admas.ngemp.sms.jpa.SmsTemplate s",
					com.admas.ngemp.sms.jpa.SmsTemplate.class);
			try {
				List<com.admas.ngemp.sms.jpa.SmsTemplate> smsTemplateJpa = customerQuery
						.getResultList();
				for (com.admas.ngemp.sms.jpa.SmsTemplate stj : smsTemplateJpa) {
					SmsTemplateDto smsTemplate = new SmsTemplateDto();
					smsTemplate.setId(stj.getId());
					smsTemplate.setMessage(stj.getMessage());
					lSmsTemplates.add(smsTemplate);
				}

			} catch (Exception exception) {
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			entityManager.close();
		}
		return lSmsTemplates;
	}

	@Override
	public SmsConfig getSmsConfig() throws ExceptionHandler {
		TypedQuery<SmsConfig> customerQuery;
		List<SmsConfig> smsTemplateJpa = new ArrayList<SmsConfig>();
		try {
			customerQuery = entityManager.createQuery(
					"SELECT s FROM com.admas.ngemp.sms.jpa.SmsConfig s",
					com.admas.ngemp.sms.jpa.SmsConfig.class);

			smsTemplateJpa = customerQuery.getResultList();
			if (smsTemplateJpa.size() == 0) {
				throw new ExceptionHandler(
						CommServiceErrors.SMS_CONFIG_NOT_FOUND);
			}
			return smsTemplateJpa.get(0);

		} catch (ExceptionHandler exception) {
			exception.printStackTrace();
			throw exception;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return smsTemplateJpa.get(0);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean saveSms( String mobileNo,
			String message, String route,String orgCode, String messageId)
			throws ExceptionHandler {

		boolean Result1 = false;
		try {
			SmsInbox smsInboxJpa = new SmsInbox();
			smsInboxJpa.setMobile(mobileNo);
			smsInboxJpa.setDelFlg("N");
			
			RawMessages messages = new RawMessages();
			messages.setMsg(message);
			entityManager.persist(messages);
			entityManager.flush();
			smsInboxJpa.setRawMessages(messages);
			smsInboxJpa.setSentOn(new Date());
			smsInboxJpa.setMsgId(messageId);
			smsInboxJpa.setMessageStatus(MessageStatus.PROCESSING);
			smsInboxJpa.setOrgCode(orgCode);
			smsInboxJpa.setRoute(Integer.parseInt(route));
			entityManager.persist(smsInboxJpa);
			Result1 = true;
			return Result1;
		} catch (Exception e) {

		}
		return Result1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SmsInbox> getSentSms() throws ExceptionHandler {
		List<SmsInbox> smsInboxs = null;
		try {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<SmsInbox> smsinboxquery = builder
					.createQuery(SmsInbox.class);
			Root<SmsInbox> root = smsinboxquery.from(SmsInbox.class);
			Predicate predicate = builder.equal(root.get("messageStatus"),
					MessageStatus.SENT);
			Predicate predicate2 = builder.equal(root.get("messageStatus"),
					MessageStatus.PROCESSING);
			smsinboxquery.where(builder.or(predicate, predicate2));
			Query query = entityManager.createQuery(smsinboxquery);

			smsInboxs = query.getResultList();

			return smsInboxs;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return smsInboxs;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean saveAllSms(SmsDto smsDto, String mobileNos, SmsConfig config)
			throws ExceptionHandler {
		boolean result = false;
		try {
			Iterator<String> iterator = smsDto.getContactNos().iterator();
			SmsInbox inbox = new SmsInbox();
			while (iterator.hasNext()) {

				Object object = iterator.next();
				inbox.setMobile(object.toString());
				inbox.setDelFlg("N");
				RawMessages messages = new RawMessages();
				messages.setMsg(smsDto.getMessage());
				entityManager.persist(messages);
				entityManager.flush();
				inbox.setOrgCode(config.getOrgId());
				inbox.setRoute(smsDto.getRoute());
				entityManager.persist(inbox);
				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public RawMessages saveRawSms(String messages) throws ExceptionHandler {

		RawMessages rawMessages = new RawMessages();
		try {

			rawMessages.setMsg(messages);
			entityManager.persist(rawMessages);
			return rawMessages;
		} catch (Exception e) {

		}
		return rawMessages;
	}

	@Override
	public String getDeliveryReport(String orgCode, String messageId) {
		String result = "";

		TypedQuery<SmsInbox> query;
		try {
			query = entityManager
					.createQuery(
							"SELECT m FROM SmsInbox m WHERE m.msgId = :msgid and m.orgCode = :orgcode",
							SmsInbox.class);
			query.setParameter("msgid", messageId);
			query.setParameter("orgcode", orgCode);

			List<SmsInbox> smsInboxs = query.getResultList();
			result = smsInboxs.get(0).getMessageStatus().toString();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	 @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void updateSmsInbox(SmsInbox smsInbox) throws ExceptionHandler {
		
		try {
			SmsInbox inbox=entityManager.merge(smsInbox);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
