/**
 * 
 */
package com.admas.logiware.logic;

import java.util.ArrayList;
import java.util.List;

import com.admas.logiware.dao.CustomerDao;
import com.admas.logiware.dto.Customer;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.ngemp.sms.services.SmsService;

/**
 * @author Raj
 *
 */
public class CustomerLogicImpl implements CustomerLogic {
	
	private static CustomerDao customerDao ;//=new CustomerDaoImpl();
	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(SmsService.class);

	/**
	 * 
	 */
	public CustomerLogicImpl() {
	}

	/* (non-Javadoc)
	 * @see com.admas.logiware.logic.CustomerLogic#getCustomer(int)
	 */
	@Override
	public Customer getCustomer(Integer id) throws LogiwareExceptionHandler{
		try{
		return customerDao.getCustomer(id);
		}
		catch(LogiwareExceptionHandler e){
			throw e;
		}
		catch(Exception e){
			logger.info(""+e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.admas.logiware.logic.CustomerLogic#getAllCustomer()
	 */
	@Override
	public List<Customer> getAllCustomer()throws LogiwareExceptionHandler {
		List<Customer>customers=new ArrayList<Customer>();
		try {
			for(com.admas.logiware.jpa.Customer customer:customerDao.getAllCustomer()){
				Customer cust=new Customer();
				cust.setId(customer.getId());
				cust.setName(customer.getName());
				cust.setContact_no(customer.getContact_no());
				cust.setEmail(customer.getEmail());
				cust.setAddress(customer.getAddress());
				customers.add(cust);
			}
		}
		catch (LogiwareExceptionHandler e) {
			throw e;
		}
		catch(Exception exception){
			logger.info(""+exception);
		}
		return customers;
	}
	
	@Override
	public Boolean deleteCustomer(Integer id)throws LogiwareExceptionHandler,Exception {
		try{
		return customerDao.deleteCustomer(id);
		}
		catch(LogiwareExceptionHandler e){
			throw e;
		}
		catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @return the customerDao
	 */
	public static CustomerDao getCustomerDao() {
		return customerDao;
	}

	/**
	 * @param customerDao the customerDao to set
	 */
	public static void setCustomerDao(CustomerDao customerDao) {
		CustomerLogicImpl.customerDao = customerDao;
	}


	

}
