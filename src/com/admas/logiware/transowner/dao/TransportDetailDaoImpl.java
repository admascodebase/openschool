/**
 * 
 */
package com.admas.logiware.transowner.dao;

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

import com.admas.logiware.dto.TransportDetailsDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.TransportDetails;

/**
 * @author 
 *
 */

@Repository
public class TransportDetailDaoImpl implements TransportDetailDao {

	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(TransportDetailDaoImpl.class);


	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		TransportDetailDaoImpl.entityManager = entityManager;
	}

	/**
	 * 
	 */
	public TransportDetailDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addTransportDetail(TransportDetailsDto transportDetailsDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			TransportDetails transportDetails = transportDetailsDto._toJpa();
			entityManager.persist(transportDetails);
			entityManager.flush();
			if (transportDetails.getId() != null || transportDetails.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in TransportDetailDaoImpl - > addTransportDetail",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in TransportDetailDaoImpl - > addTransportDetail ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<TransportDetails> getAllTransportDetail(Integer transOwnerId)
			throws LogiwareExceptionHandler {
		List<TransportDetails> transportDetails = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<TransportDetails> criteriaQuery = criteriaBuilder
					.createQuery(TransportDetails.class);
			Root<TransportDetails> transportDetailJpa = criteriaQuery.from(TransportDetails.class);
			Predicate notDeleted=criteriaBuilder.equal(transportDetailJpa.get("delFlag"), 'N');
			Predicate transOwner=criteriaBuilder.equal(transportDetailJpa.get("loweryNo"),transOwnerId);
			criteriaQuery.select(transportDetailJpa);
			criteriaQuery.where(notDeleted);
			criteriaQuery.where(transOwner);
			TypedQuery<TransportDetails> typedQuery = entityManager
					.createQuery(criteriaQuery);
			transportDetails = typedQuery.getResultList();

			if (transportDetails != null && transportDetails.size() != 0) {
				return transportDetails;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_LOWERY_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in TransportDetailDaoImpl - > getAllTransportDetail",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in TransportDetailDaoImpl - > getAllTransportDetail ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	public TransportDetails getTransportDetailById(Integer transportDetailsId) throws LogiwareExceptionHandler {
		TransportDetails transportDetails = null;
		try {

			TypedQuery<TransportDetails> cityQuery = entityManager.createQuery(
					"SELECT c FROM TransportDetails c WHERE id = :id", TransportDetails.class);
			cityQuery.setParameter("id", transportDetailsId);
			transportDetails = cityQuery.getSingleResult();

			if (transportDetails != null) {
				return transportDetails;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_LOWERY_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in TransportDetailDaoImpl - > getTransportDetailById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in TransportDetailDaoImpl - > getTransportDetailById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean editTransportDetail(TransportDetailsDto transportDetailsDto)
			throws LogiwareExceptionHandler {
			Boolean result = false;
			try {
				TransportDetails transportDetails =transportDetailsDto._toJpa();
				entityManager.merge(transportDetails);
				entityManager.flush();
				if (transportDetails.getId() != null || transportDetails.getId() != 0) {
					result = true;
				}
				return result;
			} catch (HibernateException he) {
				logger.error(
						"HibernateException Error in TransportDetailDaoImpl - > editTransportDetail",
						he);
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
			} catch (Exception e) {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.GENERIC_EXCEPTION);
			} finally {
				entityManager.close();
			}
	}

	@Override
	public Boolean deleteTransportDetail(Integer transportDetailsId) throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE TransportDetails SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", transportDetailsId);
			int updateResult = query.executeUpdate();
			if (updateResult != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in TransportDetailDaoImpl - > deleteTransportDetail",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

}
