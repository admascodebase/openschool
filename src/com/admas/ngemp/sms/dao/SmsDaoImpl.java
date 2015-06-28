package com.admas.ngemp.sms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.admas.ngemp.sms.dto.SmsTemplateDto;
import com.admas.ngemp.sms.exception.CommServiceErrors;
import com.admas.ngemp.sms.exception.ExceptionHandler;
import com.admas.ngemp.sms.jpa.SmsConfig;

@Repository
public class SmsDaoImpl implements ISmsDao{

	private static EntityManager entityManager;
	
	
	/**
	 * @param entityManager the entityManager to set
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
			customerQuery = entityManager.createQuery("SELECT s FROM com.admas.ngemp.sms.jpa.SmsTemplate s",com.admas.ngemp.sms.jpa.SmsTemplate.class);
			try {
				List<com.admas.ngemp.sms.jpa.SmsTemplate>smsTemplateJpa = customerQuery.getResultList();
				for(com.admas.ngemp.sms.jpa.SmsTemplate stj:smsTemplateJpa){
					SmsTemplateDto smsTemplate=new SmsTemplateDto();
					smsTemplate.setId(stj.getId());
					smsTemplate.setMessage(stj.getMessage());					
					lSmsTemplates.add(smsTemplate);
				}

			}catch (Exception exception) {
				/*throw new RateAlertException(ExceptionConstants.GETSOURCEID,
						exception);*/
			}
		}  catch (Exception exception) {
			exception.printStackTrace();
			//throw new Exception(exception.getMessage());
		} finally {
			entityManager.close();
		}
		return lSmsTemplates;
	}


	@Override
	public SmsConfig getSmsConfig() throws ExceptionHandler {
		TypedQuery<SmsConfig> customerQuery = null;
		try {
			customerQuery = entityManager.createQuery(
					"SELECT s FROM com.admas.ngemp.sms.jpa.SmsConfig s",
					com.admas.ngemp.sms.jpa.SmsConfig.class);

			List<SmsConfig> smsTemplateJpa = customerQuery.getResultList();
			if (smsTemplateJpa.isEmpty()) {
				throw new ExceptionHandler(
						CommServiceErrors.SMS_CONFIG_NOT_FOUND);
			}
			return smsTemplateJpa.get(0);

		} catch (ExceptionHandler exception) {
			throw exception;
		} catch (Exception e) {
			e.printStackTrace();
			// throw new Exception(exception.getMessage());
		} finally {
			entityManager.close();
		}
		return null;
	}

	

	/*@Override
	public List<Customer> getCustomerList()throws Exception {
		List<Customer> customerList = new ArrayList<Customer>();
		TypedQuery<com.admas.ngemp.sms.jpa.Customer> customerQuery = null;
		try {
			customerQuery = entityManager.createQuery("SELECT c FROM com.currenciesdirect.gtg.compliance.jpa.Customer c",com.admas.ngemp.sms.jpa.Customer.class);
			try {
				List<com.admas.ngemp.sms.jpa.Customer> customerJpa = customerQuery.getResultList();
				for(com.admas.ngemp.sms.jpa.Customer cj:customerJpa){
					Customer customer=new Customer();
					customer.setHostelId(cj.getHostelId());
					customer.setRegistrationEmail(cj.getRegistrationEmail());
					customer.setRegistrationName(cj.getRegistrationName());
					customer.setRegistrationPassword(cj.getRegistrationPassword());
					customerList.add(customer);
				}

			}catch (Exception exception) {
				throw new RateAlertException(ExceptionConstants.GETSOURCEID,
						exception);
			}
		}  catch (Exception exception) {
			throw new Exception(exception.getMessage());
		} finally {
			entityManager.close();
		}
		return customerList;
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean addCustomer(Customer customer) throws Exception {
		boolean result = false;
		try{
			com.admas.ngemp.sms.jpa.Customer customerJpa = new com.admas.ngemp.sms.jpa.Customer();
			customerJpa.setRegistrationEmail(customer.getRegistrationEmail());
			customerJpa.setRegistrationName(customer.getRegistrationName());
			customerJpa.setRegistrationUserName(customer.getRegistrationUserName());
			customerJpa.setRegistrationPassword(customer.getRegistrationPassword());
			entityManager.persist(customerJpa);
			result = true;
		}catch(HibernateException he){
			he.printStackTrace();
		}
		return result;
	}


	@Override
	public Boolean getCustomer(String uName, String password) throws Exception {
		
		boolean result=false;
		Query customerQuery = null;
		try {
			customerQuery = entityManager.createQuery("SELECT c FROM com.currenciesdirect.gtg.compliance.jpa.Customer c WHERE c.registrationUserName=:uName and c.registrationPassword=:password");
			customerQuery.setParameter("uName", uName);
			customerQuery.setParameter("password", password);
			try {
				com.admas.ngemp.sms.jpa.Customer customerJpa = (com.admas.ngemp.sms.jpa.Customer) customerQuery.getSingleResult();
				if(customerJpa!=null){
					result=true;
				}
			} catch (Exception exception) {
				throw new RateAlertException(ExceptionConstants.GETSOURCEID,
						exception);
			}
		}  catch (Exception exception) {
			throw new Exception(exception.getMessage());
		} finally {
			entityManager.close();
		}
		return result;
	}



	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addCustomerDetail(CustomerDetail customer) throws Exception {
		boolean result=false;
		try{
		com.admas.ngemp.sms.jpa.CustomerDetail customerDetail=new com.admas.ngemp.sms.jpa.CustomerDetail();
		customerDetail.setFirstName(customer.getFirstName());
		customerDetail.setLastName(customer.getLastName());
		customerDetail.setMobile(customer.getMobile());
		entityManager.persist(customerDetail);
		CustomerCurrentAddress customerCurrentAddress=new CustomerCurrentAddress();
		customerCurrentAddress.setCurrentAddress(customer.getAddress().getCurrentAddress());
		customerCurrentAddress.setCurrentPin(customer.getAddress().getCurrentPin());
		customerCurrentAddress.setCustomerDetail(customerDetail);
		State state=getState(Integer.valueOf(customer.getAddress().getCurrentState().getStateName()));
		customerCurrentAddress.setState(state);
		
		District district=getDistrict(Integer.valueOf(customer.getAddress().getCurrentState().getDistrict().getDistrictName()));
		customerCurrentAddress.setDistrict(district);
		
		City city=getCity(Integer.parseInt(customer.getAddress().getCurrentState().getDistrict().getCity().getCityName()));
		customerCurrentAddress.setCity(city);
		
		entityManager.persist(customerCurrentAddress);
		
		CustomerPerAddress perAddress=new CustomerPerAddress();
		perAddress.setPerAddress(customer.getAddress().getPerAddress());
		perAddress.setPerPin(customer.getAddress().getPerPin());
		perAddress.setCustomerDetail(customerDetail);
		
		state=getState(Integer.parseInt(customer.getAddress().getPerState().getStateName()));
		perAddress.setState(state);
		
		district=getDistrict(Integer.parseInt(customer.getAddress().getPerState().getDistrict().getDistrictName()));
		perAddress.setDistrict(district);
		
		city=getCity(Integer.parseInt(customer.getAddress().getPerState().getDistrict().getCity().getCityName()));
		perAddress.setCity(city);
		
		//state
		entityManager.persist(perAddress);
		result = true;
		}
		catch(HibernateException he){
			
		}
		return result;
	}
	
	public State getState(Integer id){
		
		try{
			TypedQuery<State> query=entityManager.createQuery("from State s where s.stateId=:stateId", State.class);
			query.setParameter("stateId", id);
			State state=query.getSingleResult();
			return state;
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		return null;
		
	}
	
	public District getDistrict(Integer id) {
		try {
			
			TypedQuery<District> query=entityManager.createQuery("from District d where d.districtId=:disId",District.class);
			query.setParameter("disId", id);
			District d=query.getSingleResult();
			return d;
		} catch (HibernateException he) {
			he.printStackTrace();
		}
			
		return null;
		
	}

	
	
	public City getCity(Integer id){
		try {
				
			TypedQuery<City> query=entityManager.createQuery("from City c where c.cityId=:cityId",City.class);
			query.setParameter("cityId", id);
			City city=query.getSingleResult();
			return city;
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		return null;
	}*/
	
	
	
}
