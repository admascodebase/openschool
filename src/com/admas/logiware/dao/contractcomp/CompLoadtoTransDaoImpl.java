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

import com.admas.logiware.dto.CompProductDto;
import com.admas.logiware.dto.CompanyLoadToTransDto;
import com.admas.logiware.dto.CompanyRouteDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.CompProduct;
import com.admas.logiware.jpa.CompanyLoadToTrans;
import com.admas.logiware.jpa.CompanyRoute;

public class CompLoadtoTransDaoImpl implements CompLoadToTransDao {

	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(CompLoadtoTransDaoImpl.class);

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		CompLoadtoTransDaoImpl.entityManager = entityManager;
	}

	@Override
	public List<CompanyLoadToTrans> getAllCompLoadtoTrans()
			throws LogiwareExceptionHandler {
		List<CompanyLoadToTrans> lCompLoadToTrans = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<CompanyLoadToTrans> criteriaQuery = criteriaBuilder
					.createQuery(CompanyLoadToTrans.class);
			Root<CompanyLoadToTrans> companyRouteJpa = criteriaQuery.from(CompanyLoadToTrans.class);
			Predicate notDeleted=criteriaBuilder.equal(companyRouteJpa.get("delFlag"), 'N');
			//Predicate contCompId=criteriaBuilder.equal(companyRouteJpa.get("companyLoadDetail"), id);
			criteriaQuery.select(companyRouteJpa);
			criteriaQuery.where(notDeleted);
			TypedQuery<CompanyLoadToTrans> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lCompLoadToTrans = typedQuery.getResultList();

			if (lCompLoadToTrans != null && lCompLoadToTrans.size() != 0) {
				return lCompLoadToTrans;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_LOAD_TRANS_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in CompLoadtoTransDaoImpl - > getAllCompLoadtoTrans",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in CompLoadtoTransDaoImpl - > getAllCompLoadtoTrans ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	public CompanyLoadToTrans getCompLoadtoTransById(Integer id)
			throws LogiwareExceptionHandler {
		CompanyLoadToTrans companyLoadToTrans = null;
		try {

			TypedQuery<CompanyLoadToTrans> comprouteQuery = entityManager.createQuery(
					"SELECT e FROM CompanyLoadToTrans e WHERE id = :id", CompanyLoadToTrans.class);
			comprouteQuery.setParameter("id", id);
			companyLoadToTrans = comprouteQuery.getSingleResult();

			if (companyLoadToTrans != null) {
				return companyLoadToTrans;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_LOAD_TRANS_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in CompLoadtoTransDaoImpl - > getCompLoadtoTransById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in CompLoadtoTransDaoImpl - > getCompLoadtoTransById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addCompLoadtoTrans(CompanyLoadToTransDto companyLoadToTransDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {			
			CompanyLoadToTrans compLoadToTrans = new CompanyLoadToTrans();
			compLoadToTrans = companyLoadToTransDto._toJpa();
			entityManager.persist(compLoadToTrans);
			entityManager.flush();
			if (compLoadToTrans.getId() != null || compLoadToTrans.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in CompLoadtoTransDaoImpl - > addCompLoadtoTrans",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception Error in CompLoadtoTransDaoImpl - > addCompLoadtoTrans",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editCompLoadtoTrans(CompanyLoadToTransDto companyLoadToTransDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			CompanyLoadToTrans companyLoadToTrans= new CompanyLoadToTrans();
			companyLoadToTrans = companyLoadToTransDto._toJpa();
			
			entityManager.merge(companyLoadToTrans);
			entityManager.flush();
			if (companyLoadToTransDto._toJpa().getId() != null || companyLoadToTransDto._toJpa().getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in CompLoadtoTransDaoImpl - > editCompLoadtoTrans",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception Error in CompLoadtoTransDaoImpl - > editCompLoadtoTrans",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteCompLoadtoTrans(Integer id)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE CompanyLoadToTrans SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", id);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in CompLoadtoTransDaoImpl - > deleteCompLoadtoTrans",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error(
			"Exception Error in CompLoadtoTransDaoImpl - > deleteCompLoadtoTrans", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	
}
