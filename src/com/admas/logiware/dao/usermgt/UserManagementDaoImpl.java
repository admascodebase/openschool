package com.admas.logiware.dao.usermgt;

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

import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.Employee;
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
	public Employee getEmployeeById(Integer empId) throws LogiwareExceptionHandler {
		CriteriaBuilder criteriaBuilder = null;
		try {
			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Employee> criteriaQuery = criteriaBuilder
					.createQuery(com.admas.logiware.jpa.Employee.class);
			Root<Employee> root = criteriaQuery
					.from(Employee.class);
			criteriaQuery.select(root);
			Predicate employeeId = criteriaBuilder.equal(root.get("id"), empId);

			criteriaQuery.where(employeeId);

			TypedQuery<Employee> typedQuery = entityManager
					.createQuery(criteriaQuery);
			List<Employee> lEmployee = typedQuery.getResultList();
			
			if (lEmployee != null && lEmployee.size()>0) {
				return lEmployee.get(0);
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_EMPLOYEE_FOUND);
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

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean addUser(com.admas.logiware.dto.UserDetails userDetails)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
		/*	UserDetails city = userDetails._toJpa();
			entityManager.persist(city);
			entityManager.flush();
			if (city.getId() != null || city.getId() != 0) {
				result = true;
			}*/
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getAllCity ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean saveChangePassword(com.admas.logiware.dto.UserDetails userDetails) throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			
			String newPassword = userDetails.getNewPassword(),password = userDetails.getPassword();
			Integer empId = userDetails.getEmpId(),compId = userDetails.getCompId();
			Query query = entityManager.createQuery(
					"UPDATE UserDetails SET pasword = :newPassword, empId = :empId, compId = :compId WHERE pasword = :password");
			query.setParameter("newPassword", newPassword);
			query.setParameter("empId", empId);
			query.setParameter("compId", compId);
			query.setParameter("password", password);
			int updateResult = query.executeUpdate();
			if (updateResult != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in UserManagementDaoImpl - > saveChangePassword",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error("Exception Error in UserManagementDaoImpl - > saveChangePassword ",
			 e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	public Employee authenticateEmail(String mobileNumber) throws LogiwareExceptionHandler {
		CriteriaBuilder criteriaBuilder = null;
		Employee employee = null;
		try {
			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(com.admas.logiware.jpa.Employee.class);
			Root<Employee> root = criteriaQuery.from(Employee.class);
			criteriaQuery.select(root);
			Predicate emailId = criteriaBuilder.equal(root.get("contactNo"), mobileNumber);
			criteriaQuery.where(emailId);

			TypedQuery<Employee> typedQuery = entityManager.createQuery(criteriaQuery);
			List<Employee> lEmployee = typedQuery.getResultList();

			if (lEmployee != null && lEmployee.size() > 0) {
				return lEmployee.get(0);
				
			} else {
				return employee;
			}
		} catch (HibernateException he) {
			logger.error("HibernateException Error in UserManagementDaoImpl - > authenticateEmail ",he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error("Exception Error in UserManagementDaoImpl - > authenticateEmail ",e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean resetPassword(EmployeeDto employeeDto) throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			String password = "abcd";
			Integer empId = employeeDto.getId();
			Query query = entityManager.createQuery("UPDATE UserDetails SET pasword = :newPassword WHERE empId = :empId");
			query.setParameter("newPassword", password);
			query.setParameter("empId", empId);
			int updateResult = query.executeUpdate();
			if (updateResult != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in UserManagementDaoImpl - > resetPassword",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error("Exception Error in UserManagementDaoImpl - > resetPassword ",
			 e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}
	
	

}
