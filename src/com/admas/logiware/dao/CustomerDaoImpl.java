/**
 * 
 */
package com.admas.logiware.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admas.logiware.dto.Customer;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;

/**
 * @author Raj
 *
 */

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private static EntityManager entityManager;


	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
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
	public Customer getCustomer(Integer id)throws LogiwareExceptionHandler {


		Customer customer=new Customer();
		TypedQuery<com.admas.logiware.jpa.Customer> customerQuery=null;
		try{
			customerQuery=entityManager.createQuery("SELECT c FROM com.admas.logiware.jpa.Customer c WHERE c.id=:id",com.admas.logiware.jpa.Customer.class);
			customerQuery.setParameter("id", id);
			com.admas.logiware.jpa.Customer cust=(com.admas.logiware.jpa.Customer) customerQuery.getSingleResult();
				if(cust!=null && "N".equals(cust.getDel_flag())){
					throw new LogiwareExceptionHandler(LogiwareServiceErrors.CUSTOMER_INACTIVE);
				}
				else{
					customer.setName(cust.getName());
					return customer;
				}
		}
		catch(LogiwareExceptionHandler e){
			throw e;
		}
		catch(NoResultException re){
			throw new LogiwareExceptionHandler(LogiwareServiceErrors.NO_CUSTOMER_FOUND);
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public List<com.admas.logiware.jpa.Customer> getAllCustomer()throws LogiwareExceptionHandler{
		TypedQuery<com.admas.logiware.jpa.Customer>query=null;
		List<com.admas.logiware.jpa.Customer>result=null;
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		try{
			CriteriaQuery<com.admas.logiware.jpa.Customer> criteriaQuery = criteriaBuilder.createQuery(com.admas.logiware.jpa.Customer.class);
			Root<com.admas.logiware.jpa.Customer> criteria = criteriaQuery.from(com.admas.logiware.jpa.Customer.class);
			ParameterExpression<String> predicate = criteriaBuilder.parameter(String.class);
			criteriaQuery.select(criteria).where(criteriaBuilder.equal(criteria.get("del_flag"), predicate));
			query=entityManager.createQuery(criteriaQuery);
			query.setParameter(predicate, "Y");
			result=query.getResultList();
			if(result!=null){
				if(result.size()!=0){
				return result;
				}
				else{
					throw new LogiwareExceptionHandler(LogiwareServiceErrors.NO_CUSTOMER_FOUND);
				}
			}else{
				throw new LogiwareExceptionHandler(LogiwareServiceErrors.GENERIC_EXCEPTION);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		}catch (Exception e) {
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}finally{
			criteriaBuilder = null; 
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public Boolean deleteCustomer(Integer id)throws LogiwareExceptionHandler {
		Boolean result=false;
		try{
			com.admas.logiware.jpa.Customer customer=entityManager.find(com.admas.logiware.jpa.Customer.class, id);
			if(customer!=null){
				if("N".equals(customer.getDel_flag())){
					throw new LogiwareExceptionHandler(LogiwareServiceErrors.CUSTOMER_INACTIVE);	
				}
				customer.setDel_flag("N");
				result=true;
			}
		}
		catch(LogiwareExceptionHandler exception){
			throw exception;

		}catch(Exception exception){
			entityManager.getTransaction().rollback();
			throw new LogiwareExceptionHandler(LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		finally {
			entityManager.close();
		}
		return result;
	}

}
