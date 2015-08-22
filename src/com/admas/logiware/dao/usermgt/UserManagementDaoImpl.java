package com.admas.logiware.dao.usermgt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.CustCompanyEmployee;
import com.admas.logiware.jpa.UserDetails;

@Repository
public class UserManagementDaoImpl implements IUserManagementDao {

	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(UserManagementDaoImpl.class);

	/**
	 * @param entityManager
	 *            the entityManager to set
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		UserManagementDaoImpl.entityManager = entityManager;
	}

	public UserManagementDaoImpl() {
		super();
	}

	@Override
	public UserDetails login(String userName,
			String password) throws LogiwareExceptionHandler {
		List<UserDetails> userList = null;
		CriteriaBuilder criteriaBuilder = null;
		try {
			
			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<UserDetails> criteriaQuery = criteriaBuilder
					.createQuery(com.admas.logiware.jpa.UserDetails.class);
			Root<UserDetails> root = criteriaQuery.from(UserDetails.class);
			criteriaQuery.select(root);
			Predicate predicate1 = criteriaBuilder.and(criteriaBuilder.equal(root.get("userName"), userName));
			Predicate predicate2 = criteriaBuilder.and(criteriaBuilder.equal(root.get("pasword"), password));
			criteriaQuery.where(predicate1);
			criteriaQuery.where(predicate2);
			TypedQuery<UserDetails> typedQuery = entityManager
					.createQuery(criteriaQuery);
			userList = typedQuery.getResultList();
			if (userList != null && userList.size()>0) {
				return userList.get(0);
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.INVALID_CREDENTIALS);
			}
		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error("HibernateException Error in UserManagementDaoImpl - > login ",he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		}catch (Exception e) {
			logger.error("Exception Error in UserManagementDaoImpl - > login ",e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}finally{
			criteriaBuilder = null; 
		}
	}

	
	@Override
	public CustCompanyEmployee getEmployeeById(Integer empId) throws LogiwareExceptionHandler {
		CriteriaBuilder criteriaBuilder = null;
		try {
			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<CustCompanyEmployee> criteriaQuery = criteriaBuilder
					.createQuery(com.admas.logiware.jpa.CustCompanyEmployee.class);
			Root<CustCompanyEmployee> root = criteriaQuery
					.from(CustCompanyEmployee.class);
			criteriaQuery.select(root);
			Predicate employeeId = criteriaBuilder.equal(root.get("id"), empId);

			criteriaQuery.where(employeeId);

			TypedQuery<CustCompanyEmployee> typedQuery = entityManager
					.createQuery(criteriaQuery);
			List<CustCompanyEmployee> lEmployee = typedQuery.getResultList();
			
			if (lEmployee != null && lEmployee.size()>0) {
				return lEmployee.get(0);
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.GENERIC_EXCEPTION);
			}
			
		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error("HibernateException Error in UserManagementDaoImpl - > getEmployeeById ",he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error("Exception Error in UserManagementDaoImpl - > getEmployeeById ",e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

}
