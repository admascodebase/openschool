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

import com.admas.logiware.dto.sms.SmsDto;
import com.admas.logiware.dto.sms.SmsTemplateDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.sms.RawMessages;
import com.admas.logiware.jpa.sms.SmsConfig;
import com.admas.logiware.jpa.sms.SmsInbox;
import com.admas.ngemp.enumuration.MessageStatus;

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
	public List<SmsTemplateDto> getSmsTempltes()
			throws LogiwareExceptionHandler {
		List<SmsTemplateDto> lSmsTemplates = new ArrayList<SmsTemplateDto>();
		TypedQuery<com.admas.logiware.jpa.sms.SmsTemplate> customerQuery = null;
		try {
			customerQuery = entityManager.createQuery(
					"SELECT s FROM com.admas.ngemp.sms.jpa.SmsTemplate s",
					com.admas.logiware.jpa.sms.SmsTemplate.class);
			try {
				List<com.admas.logiware.jpa.sms.SmsTemplate> smsTemplateJpa = customerQuery
						.getResultList();
				for (com.admas.logiware.jpa.sms.SmsTemplate stj : smsTemplateJpa) {
					SmsTemplateDto smsTemplate = new SmsTemplateDto();
					smsTemplate.setId(stj.getId());
					smsTemplate.setMessage(stj.getMessage());
					lSmsTemplates.add(smsTemplate);
				}

			} catch (Exception e) {
				logger.error(
						"Exception Error in SmsDaoImpl - > getSmsTempltes ", e);
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.GENERIC_EXCEPTION);
			} finally {
				entityManager.close();
			}
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in SmsDaoImpl - > getSmsTempltes",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error("Exception Error in SmsDaoImpl - > getSmsTempltes ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
		return lSmsTemplates;
	}

	@Override
	public SmsConfig getSmsConfig() throws LogiwareExceptionHandler {
		TypedQuery<SmsConfig> customerQuery;
		List<SmsConfig> smsTemplateJpa = new ArrayList<SmsConfig>();
		try {
			customerQuery = entityManager.createQuery(
					"SELECT s FROM SmsConfig s", SmsConfig.class);

			smsTemplateJpa = customerQuery.getResultList();
			if (smsTemplateJpa.size() == 0) {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.SMS_CONFIG_NOT_FOUND);
			}
			return smsTemplateJpa.get(0);

		} catch (LogiwareExceptionHandler exception) {
			throw exception;
		} catch (Exception e) {
			logger.error("Exception Error in SmsDaoImpl - > getSmsConfig ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean saveSms(String mobileNo, String message, String route,
			String orgCode, String messageId) throws LogiwareExceptionHandler {

		boolean Result1 = false;
		try {
			SmsInbox smsInboxJpa = new SmsInbox();
			smsInboxJpa.setMobile(mobileNo);
			smsInboxJpa.setDelFlg("N");
			RawMessages messages = new RawMessages();
			messages.setMsg(message);
			entityManager.persist(messages);
			entityManager.flush();
			smsInboxJpa.setRawMsgId(messages.getId());
			smsInboxJpa.setSentOn(new Date());
			smsInboxJpa.setMsgId(messageId);
			smsInboxJpa.setMessageStatus(MessageStatus.PROCESSING);
			smsInboxJpa.setOrgCode(orgCode);
			smsInboxJpa.setRoute(Integer.parseInt(route));
			entityManager.persist(smsInboxJpa);
			Result1 = true;
			return Result1;
		} catch (HibernateException he) {
			logger.error("HibernateException Error in SmsDaoImpl - > saveSms",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error("Exception Error in SmsDaoImpl - > saveSms ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SmsInbox> getSentSms() throws LogiwareExceptionHandler {
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
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in SmsDaoImpl - > getSentSms", he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error("Exception Error in SmsDaoImpl - > getSentSms ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean saveAllSms(SmsDto smsDto, String mobileNos, SmsConfig config)
			throws LogiwareExceptionHandler {
		boolean result = false;
		try {
			Iterator<String> iterator = smsDto.getContactNos().iterator();
			SmsInbox inbox = new SmsInbox();
			while (iterator.hasNext()) {
				try {
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
				} catch (HibernateException he) {
					logger.error(
							"HibernateException Error in SmsDaoImpl - > saveAllSms",
							he);
				} catch (Exception e) {
					logger.error(
							"Exception Error in SmsDaoImpl - > saveAllSms ", e);
				} finally {
					entityManager.close();
				}
			}

		} catch (Exception e) {
			logger.error(
					"Exception Error in SmsDaoImpl - > saveAllSms ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;

	}

	public RawMessages saveRawSms(String messages)
			throws LogiwareExceptionHandler {

		RawMessages rawMessages = new RawMessages();
		try {

			rawMessages.setMsg(messages);
			entityManager.persist(rawMessages);
			return rawMessages;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in SmsDaoImpl - > saveRawSms", he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error("Exception Error in SmsDaoImpl - > saveRawSms ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public String getDeliveryReport(String orgCode, String messageId) throws LogiwareExceptionHandler {
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
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in SmsDaoImpl - > getDeliveryReport", he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error("Exception Error in SmsDaoImpl - > getDeliveryReport ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void updateSmsInbox(SmsInbox smsInbox)
			throws LogiwareExceptionHandler {

		try {
			entityManager.merge(smsInbox);
			entityManager.flush();
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in SmsDaoImpl - > updateSmsInbox", he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error("Exception Error in SmsDaoImpl - > updateSmsInbox ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public boolean saveSmsAsync(SmsDto smsDto, String mobileNo)
			throws LogiwareExceptionHandler {
		boolean result = false;
		SmsInbox inbox = new SmsInbox();
		try {
			inbox.setDelFlg("N");
			inbox.setMessageStatus(MessageStatus.ASYNC);
			inbox.setMobile(mobileNo);
			inbox.setMsgId("");
			inbox.setMsgPushId("");
			inbox.setOrgCode(smsDto.getOrgCode());
			RawMessages messages = new RawMessages();
			messages.setMsg(smsDto.getMessage());
			entityManager.persist(messages);
			entityManager.flush();
			inbox.setRawMsgId(messages.getId());
			inbox.setRoute(smsDto.getRoute());
			// inbox.setSentOn(null);
			result = true;
			entityManager.persist(inbox);
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in SmsDaoImpl - > saveSmsAsync", he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error("Exception Error in SmsDaoImpl - > saveSmsAsync ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SmsInbox> getAsyncSms() throws LogiwareExceptionHandler {

		List<SmsInbox> asyncSmsList = new ArrayList<SmsInbox>();

		try {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();

			CriteriaQuery<SmsInbox> criteriaQuery = builder
					.createQuery(SmsInbox.class);

			Root<SmsInbox> root = criteriaQuery.from(SmsInbox.class);

			Predicate predicate = builder.equal(root.get("messageStatus"),
					MessageStatus.ASYNC);

			criteriaQuery.where(predicate);

			Query query = entityManager.createQuery(criteriaQuery);

			asyncSmsList = query.getResultList();
			
			return asyncSmsList;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in SmsDaoImpl - > getAsyncSms", he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error("Exception Error in SmsDaoImpl - > getAsyncSms ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public RawMessages getrawsms(Integer rawMessageId)
			throws LogiwareExceptionHandler {
		RawMessages messages = new RawMessages();
		try {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<RawMessages> criteriaQuery = builder
					.createQuery(RawMessages.class);
			Root<RawMessages> root = criteriaQuery.from(RawMessages.class);
			Predicate predicate = builder.equal(root.get("id"), rawMessageId);
			criteriaQuery.where(predicate);
			Query query = entityManager.createQuery(criteriaQuery);
			List<RawMessages> rawMessages = query.getResultList();
			messages = rawMessages.get(0);
			return messages;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in SmsDaoImpl - > getrawsms", he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error("Exception Error in SmsDaoImpl - > getrawsms ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

}
