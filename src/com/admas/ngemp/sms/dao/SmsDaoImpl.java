package com.admas.ngemp.sms.dao;

import java.util.ArrayList;
import java.util.Arrays;
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
				/*
				 * throw new RateAlertException(ExceptionConstants.GETSOURCEID,
				 * exception);
				 */
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			// throw new Exception(exception.getMessage());
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
			// throw new Exception(exception.getMessage());
		} finally {
			entityManager.close();
		}
		return smsTemplateJpa.get(0);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean saveSms(SmsConfig smsConfig, String mobileNo,
			String message, String route, String messageId)
			throws ExceptionHandler {

		boolean Result1 = false;
		try {
			SmsInbox smsInboxJpa = new SmsInbox();
			smsInboxJpa.setMobile(mobileNo);
			smsInboxJpa.setDelFlg("N");
			smsInboxJpa.setSentOn(new Date());
			// smsInboxJpa.setDeleveredOn(null);
			smsInboxJpa.setMsgId(messageId);
			// smsInboxJpa.setMsgPushId("");
			// messageStatus status = null;

			smsInboxJpa.setMessageStatus(MessageStatus.PROCESSING);
			smsInboxJpa.setOrgCode(smsConfig.getOrgId());
			//smsInboxJpa.setMsgStatus('P');
			smsInboxJpa.setRoute(Integer.parseInt(route));
			// smsInboxJpa.set(new Date());

			// smsInboxJpa.setRawMessages(null);
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
			// throw new Exception(exception.getMessage());
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
				// inbox.setDeleveredOn(null);
				inbox.setDelFlg("N");

				RawMessages messages = new RawMessages();
				messages.setMsg(smsDto.getMessage());
				entityManager.persist(messages);
				entityManager.flush();

				/*
				 * inbox.setMsgId(""); inbox.setMsgPushId("");
				 * inbox.setMsgStatus("");
				 */
				inbox.setOrgCode(config.getOrgId());

				// inbox.setRawMessages(messages);

				inbox.setRoute(smsDto.getRoute());
				// inbox.setSentOn(null);

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
		// boolean Result1 = false;
		try {

			rawMessages.setMsg(messages);
			// smsInboxJpa.setRawMessages(null);
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
			logger.info("@##########"+inbox.getMessageStatus());	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/*
	 * @Override public List<Customer> getCustomerList()throws Exception {
	 * List<Customer> customerList = new ArrayList<Customer>();
	 * TypedQuery<com.admas.ngemp.sms.jpa.Customer> customerQuery = null; try {
	 * customerQuery = entityManager.createQuery(
	 * "SELECT c FROM com.currenciesdirect.gtg.compliance.jpa.Customer c"
	 * ,com.admas.ngemp.sms.jpa.Customer.class); try {
	 * List<com.admas.ngemp.sms.jpa.Customer> customerJpa =
	 * customerQuery.getResultList(); for(com.admas.ngemp.sms.jpa.Customer
	 * cj:customerJpa){ Customer customer=new Customer();
	 * customer.setHostelId(cj.getHostelId());
	 * customer.setRegistrationEmail(cj.getRegistrationEmail());
	 * customer.setRegistrationName(cj.getRegistrationName());
	 * customer.setRegistrationPassword(cj.getRegistrationPassword());
	 * customerList.add(customer); }
	 * 
	 * }catch (Exception exception) { throw new
	 * RateAlertException(ExceptionConstants.GETSOURCEID, exception); } } catch
	 * (Exception exception) { throw new Exception(exception.getMessage()); }
	 * finally { entityManager.close(); } return customerList; }
	 * 
	 * 
	 * @Override
	 * 
	 * @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	 * public boolean addCustomer(Customer customer) throws Exception { boolean
	 * result = false; try{ com.admas.ngemp.sms.jpa.Customer customerJpa = new
	 * com.admas.ngemp.sms.jpa.Customer();
	 * customerJpa.setRegistrationEmail(customer.getRegistrationEmail());
	 * customerJpa.setRegistrationName(customer.getRegistrationName());
	 * customerJpa.setRegistrationUserName(customer.getRegistrationUserName());
	 * customerJpa.setRegistrationPassword(customer.getRegistrationPassword());
	 * entityManager.persist(customerJpa); result = true;
	 * }catch(HibernateException he){ he.printStackTrace(); } return result; }
	 * 
	 * 
	 * @Override public Boolean getCustomer(String uName, String password)
	 * throws Exception {
	 * 
	 * boolean result=false; Query customerQuery = null; try { customerQuery =
	 * entityManager.createQuery(
	 * "SELECT c FROM com.currenciesdirect.gtg.compliance.jpa.Customer c WHERE c.registrationUserName=:uName and c.registrationPassword=:password"
	 * ); customerQuery.setParameter("uName", uName);
	 * customerQuery.setParameter("password", password); try {
	 * com.admas.ngemp.sms.jpa.Customer customerJpa =
	 * (com.admas.ngemp.sms.jpa.Customer) customerQuery.getSingleResult();
	 * if(customerJpa!=null){ result=true; } } catch (Exception exception) {
	 * throw new RateAlertException(ExceptionConstants.GETSOURCEID, exception);
	 * } } catch (Exception exception) { throw new
	 * Exception(exception.getMessage()); } finally { entityManager.close(); }
	 * return result; }
	 * 
	 * 
	 * 
	 * @Override
	 * 
	 * @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	 * public Boolean addCustomerDetail(CustomerDetail customer) throws
	 * Exception { boolean result=false; try{
	 * com.admas.ngemp.sms.jpa.CustomerDetail customerDetail=new
	 * com.admas.ngemp.sms.jpa.CustomerDetail();
	 * customerDetail.setFirstName(customer.getFirstName());
	 * customerDetail.setLastName(customer.getLastName());
	 * customerDetail.setMobile(customer.getMobile());
	 * entityManager.persist(customerDetail); CustomerCurrentAddress
	 * customerCurrentAddress=new CustomerCurrentAddress();
	 * customerCurrentAddress
	 * .setCurrentAddress(customer.getAddress().getCurrentAddress());
	 * customerCurrentAddress
	 * .setCurrentPin(customer.getAddress().getCurrentPin());
	 * customerCurrentAddress.setCustomerDetail(customerDetail); State
	 * state=getState
	 * (Integer.valueOf(customer.getAddress().getCurrentState().getStateName
	 * ())); customerCurrentAddress.setState(state);
	 * 
	 * District
	 * district=getDistrict(Integer.valueOf(customer.getAddress().getCurrentState
	 * ().getDistrict().getDistrictName()));
	 * customerCurrentAddress.setDistrict(district);
	 * 
	 * City
	 * city=getCity(Integer.parseInt(customer.getAddress().getCurrentState()
	 * .getDistrict().getCity().getCityName()));
	 * customerCurrentAddress.setCity(city);
	 * 
	 * entityManager.persist(customerCurrentAddress);
	 * 
	 * CustomerPerAddress perAddress=new CustomerPerAddress();
	 * perAddress.setPerAddress(customer.getAddress().getPerAddress());
	 * perAddress.setPerPin(customer.getAddress().getPerPin());
	 * perAddress.setCustomerDetail(customerDetail);
	 * 
	 * state=getState(Integer.parseInt(customer.getAddress().getPerState().
	 * getStateName())); perAddress.setState(state);
	 * 
	 * district=getDistrict(Integer.parseInt(customer.getAddress().getPerState().
	 * getDistrict().getDistrictName())); perAddress.setDistrict(district);
	 * 
	 * city=getCity(Integer.parseInt(customer.getAddress().getPerState().getDistrict
	 * ().getCity().getCityName())); perAddress.setCity(city);
	 * 
	 * //state entityManager.persist(perAddress); result = true; }
	 * catch(HibernateException he){
	 * 
	 * } return result; }
	 * 
	 * public State getState(Integer id){
	 * 
	 * try{ TypedQuery<State>
	 * query=entityManager.createQuery("from State s where s.stateId=:stateId",
	 * State.class); query.setParameter("stateId", id); State
	 * state=query.getSingleResult(); return state; } catch(HibernateException
	 * he){ he.printStackTrace(); } return null;
	 * 
	 * }
	 * 
	 * public District getDistrict(Integer id) { try {
	 * 
	 * TypedQuery<District>
	 * query=entityManager.createQuery("from District d where d.districtId=:disId"
	 * ,District.class); query.setParameter("disId", id); District
	 * d=query.getSingleResult(); return d; } catch (HibernateException he) {
	 * he.printStackTrace(); }
	 * 
	 * return null;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public City getCity(Integer id){ try {
	 * 
	 * TypedQuery<City>
	 * query=entityManager.createQuery("from City c where c.cityId=:cityId"
	 * ,City.class); query.setParameter("cityId", id); City
	 * city=query.getSingleResult(); return city; } catch (HibernateException e)
	 * {
	 * 
	 * e.printStackTrace(); } return null; }
	 */

}
