/**
 * 
 */
package com.admas.logiware.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.admas.logiware.dto.Customer;

/**
 * @author MAHESH
 *
 */
public class CustomerDaoImpl implements CustomerDao {
	
	private static EntityManager entityManager;
	
	
	@PersistenceContext
	public static void setEntityManager(EntityManager entityManager) {
		CustomerDaoImpl.entityManager = entityManager;
	}

	/**
	 * 
	 */
	public CustomerDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.admas.logiware.dao.CustomerDao#getCustomer(int)
	 */
	@Override
	public Customer getCustomer(Integer id) {

		//com.admas.logiware.jpa.Customer

		Customer customer=new Customer();
		TypedQuery<com.admas.logiware.jpa.Customer> customerQuery=null;
		try{
			customerQuery=entityManager.createQuery("SELECT c FROM com.admas.logiware.jpa.Customer c WHERE c.id=:id",com.admas.logiware.jpa.Customer.class);
			customerQuery.setParameter("id", id);
			com.admas.logiware.jpa.Customer cust=(com.admas.logiware.jpa.Customer) customerQuery.getSingleResult();
			customer.setName(cust.getName());
			return customer;
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		finally {
			entityManager.close();
		}
		return null;
	}

}
