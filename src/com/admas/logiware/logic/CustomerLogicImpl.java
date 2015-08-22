/**
 * 
 */
package com.admas.logiware.logic;

import java.util.List;

import com.admas.logiware.dao.CustomerDao;
import com.admas.logiware.dto.Customer;

/**
 * @author Raj
 *
 */
public class CustomerLogicImpl implements CustomerLogic {
	
	private static CustomerDao customerDao ;//=new CustomerDaoImpl();

	/**
	 * 
	 */
	public CustomerLogicImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.admas.logiware.logic.CustomerLogic#getCustomer(int)
	 */
	@Override
	public Customer getCustomer(Integer id) {
		return customerDao.getCustomer(id);
	}

	/* (non-Javadoc)
	 * @see com.admas.logiware.logic.CustomerLogic#getAllCustomer()
	 */
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
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
