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

import com.admas.logiware.dto.CompanyLoadDetailDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.CompanyLoadDetail;

public class ContractCompLoadDaoImpl implements ContractCompLoadDao{

	
	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(ContractCompLoadDaoImpl.class);

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		ContractCompLoadDaoImpl.entityManager = entityManager;
	}

	@Override
	public List<CompanyLoadDetail> getAllContractCompLoadDetails(Integer contractCompId)
			throws LogiwareExceptionHandler {
		List<CompanyLoadDetail> lCompLoadDetails = null;
		CriteriaBuilder criteriaBuilder = null;
		try {
			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<CompanyLoadDetail> criteriaQuery = criteriaBuilder
					.createQuery(CompanyLoadDetail.class);
			Root<CompanyLoadDetail> companyRouteJpa = criteriaQuery.from(CompanyLoadDetail.class);
			Predicate notDeleted=criteriaBuilder.equal(companyRouteJpa.get("delFlag"), 'N');
			Predicate contCompId=criteriaBuilder.equal(companyRouteJpa.get("contractCompId"), contractCompId);
			criteriaQuery.select(companyRouteJpa);
			criteriaQuery.where(notDeleted, contCompId);
			TypedQuery<CompanyLoadDetail> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lCompLoadDetails = typedQuery.getResultList();

			if (lCompLoadDetails != null && lCompLoadDetails.size() != 0) {
				return lCompLoadDetails;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_LOAD_ENTRY_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ContractCompLoadDaoImpl - > getAllContractCompLoadDetails",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in ContractCompLoadDaoImpl - > getAllContractCompLoadDetails ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	public CompanyLoadDetail getContractCompLoadDetailsById(Integer id)
			throws LogiwareExceptionHandler {
		CompanyLoadDetail compLoadDetail = null;
		try {

			TypedQuery<CompanyLoadDetail> compLoadQuery = entityManager.createQuery(
					"SELECT e FROM CompanyLoadDetail e WHERE id = :id", CompanyLoadDetail.class);
			compLoadQuery.setParameter("id", id);
			compLoadDetail = compLoadQuery.getSingleResult();

			if (compLoadDetail != null) {
				return compLoadDetail;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_LOAD_ENTRY_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ContractCompLoadDaoImpl - > getContractCompLoadDetailsById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in ContractCompLoadDaoImpl - > getContractCompLoadDetailsById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addContractCompLoadDetails(
			CompanyLoadDetailDto companyLoadDetailDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			CompanyLoadDetail compLoadDetails = new CompanyLoadDetail();
			compLoadDetails = companyLoadDetailDto._toJpa();
			entityManager.persist(compLoadDetails);
			entityManager.flush();
			if (compLoadDetails.getId() != null || compLoadDetails.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ContractCompLoadDaoImpl - > addContractCompLoadDetails",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception Error in ContractCompLoadDaoImpl - > addContractCompLoadDetails",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editContractCompLoadDetails(
			CompanyLoadDetailDto companyLoadDetailDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			CompanyLoadDetail compLoadDetails= new CompanyLoadDetail();
			compLoadDetails = companyLoadDetailDto._toJpa();
			
			entityManager.merge(compLoadDetails);
			entityManager.flush();
			if (companyLoadDetailDto._toJpa().getId() != null || companyLoadDetailDto._toJpa().getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ContractCompLoadDaoImpl - > editContractCompLoadDetails",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception Error in ContractCompLoadDaoImpl - > editContractCompLoadDetails",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteContractCompLoadDetails(Integer id)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE CompanyLoadDetail SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", id);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ContractCompLoadDaoImpl - > deleteContractCompLoadDetails",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error(
			"Exception Error in ContractCompLoadDaoImpl - > deleteContractCompLoadDetails", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}
	

}
