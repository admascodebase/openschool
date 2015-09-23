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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admas.logiware.dto.LoweryOwnerDto;
import com.admas.logiware.dto.TransportDetailsDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.LoweryOwner;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransportDetails> getAllTransportDetail(Integer transOwnerId)
			throws LogiwareExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransportDetails getTransportDetailById(Integer transOwnerId,
			Integer transportDetailsId) throws LogiwareExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean editTransportDetail(TransportDetailsDto transportDetailsDto)
			throws LogiwareExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteTransportDetail(Integer transOwnerId,
			Integer transportDetailsId) throws LogiwareExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addTransOwner(LoweryOwnerDto loweryOwnerDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			LoweryOwner loweryOwner = loweryOwnerDto._toJpa();
			entityManager.persist(loweryOwner);
			entityManager.flush();
			if (loweryOwner.getId() != null || loweryOwner.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in TransOwnerDaoImpl - > addTransOwner",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in TransOwnerDaoImpl - > addTransOwner ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<LoweryOwner> getAllTransOwner() throws LogiwareExceptionHandler {
		List<LoweryOwner> lLoweryOwners = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<LoweryOwner> criteriaQuery = criteriaBuilder
					.createQuery(LoweryOwner.class);
			Root<LoweryOwner> BranchJpa = criteriaQuery.from(LoweryOwner.class);
			Predicate notDeleted=criteriaBuilder.equal(BranchJpa.get("delFlag"), 'N');
			criteriaQuery.select(BranchJpa);
			criteriaQuery.where(notDeleted);
			TypedQuery<LoweryOwner> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lLoweryOwners = typedQuery.getResultList();

			if (lLoweryOwners != null && lLoweryOwners.size() != 0) {
				return lLoweryOwners;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_LOWERYOWNERS_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in TransOwnerDaoImpl - > getAllTransOwner",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in TransOwnerDaoImpl - > getAllBranch ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	public LoweryOwner getTransOwnerById(Integer loweryOwnerId)
			throws LogiwareExceptionHandler {
		LoweryOwner loweryOwner = null;
		try {

			TypedQuery<LoweryOwner> cityQuery = entityManager.createQuery(
					"SELECT c FROM LoweryOwner c WHERE id = :id", LoweryOwner.class);
			cityQuery.setParameter("id", loweryOwnerId);
			loweryOwner = cityQuery.getSingleResult();

			if (loweryOwner != null) {
				return loweryOwner;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_CITY_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in TransOwnerDaoImpl - > getTransOwnerById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in TransOwnerDaoImpl - > getTransOwnerById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editTransOwner(LoweryOwnerDto loweryOwnerDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			LoweryOwner loweryOwner =loweryOwnerDto._toJpa();
			entityManager.merge(loweryOwner);
			entityManager.flush();
			if (loweryOwner.getId() != null || loweryOwner.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in TransOwnerDaoImpl - > editTransOwner",
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
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteTransOwner(Integer loweryOwnerId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE LoweryOwner SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", loweryOwnerId);
			int updateResult = query.executeUpdate();
			if (updateResult != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in TransOwnerDaoImpl - > deleteTransOwner",
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
	*/

}
