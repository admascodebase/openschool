package com.admas.logiware.dao.contractcomp;

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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admas.logiware.dto.ContractCompDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.CustContractCompany;
import com.admas.logiware.jpa.Employee;

public class ContractCompDaoImpl implements ContractCompDao {

	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(ContractCompDaoImpl.class);

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		ContractCompDaoImpl.entityManager = entityManager;
	}

	@Override
	public List<CustContractCompany> getAllContractComp()
			throws LogiwareExceptionHandler {
		List<CustContractCompany> lContractCompany = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<CustContractCompany> criteriaQuery = criteriaBuilder
					.createQuery(CustContractCompany.class);
			Root<CustContractCompany> employeeJpa = criteriaQuery.from(CustContractCompany.class);
			Predicate notDeleted=criteriaBuilder.equal(employeeJpa.get("delFlag"), 'N');
			criteriaQuery.select(employeeJpa);
			criteriaQuery.where(notDeleted);
			TypedQuery<CustContractCompany> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lContractCompany = typedQuery.getResultList();

			if (lContractCompany != null && lContractCompany.size() != 0) {
				return lContractCompany;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_CONTRACT_COMP_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ContractCompDaoImpl - > getAllContractComp",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in ContractCompDaoImpl - > getAllContractComp ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	public CustContractCompany getContractCompById(Integer contractCompId)
			throws LogiwareExceptionHandler {
		CustContractCompany contractCompany = null;
		try {

			TypedQuery<CustContractCompany> cityQuery = entityManager.createQuery(
					"SELECT e FROM CustContractCompany e WHERE id = :id", CustContractCompany.class);
			cityQuery.setParameter("id", contractCompId);
			contractCompany = cityQuery.getSingleResult();

			if (contractCompany != null) {
				return contractCompany;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_EMPLOYEE_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ContractCompDaoImpl - > getContractCompById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in ContractCompDaoImpl - > getContractCompById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addContractComp(ContractCompDto contractCompDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {			
			entityManager.persist(contractCompDto._toJpa());
			entityManager.flush();
			if (contractCompDto._toJpa().getId() != null || contractCompDto._toJpa().getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ContractCompDaoImpl - > addContractComp",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in ContractCompDaoImpl - > addContractComp",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean editContractComp(ContractCompDto contractCompDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			entityManager.persist(contractCompDto._toJpa());
			entityManager.flush();
			if (contractCompDto._toJpa().getId() != null || contractCompDto._toJpa().getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ContractCompDaoImpl - > editContractComp",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in ContractCompDaoImpl - > editContractComp",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteContractComp(Integer contractCompId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE CustContractCompany SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", contractCompId);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ContractCompDaoImpl - > deleteContractComp",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error(
			"Exception Error in ContractCompDaoImpl - > deleteContractComp", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	
}
