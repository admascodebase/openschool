package com.admas.logiware.dao.contractcomp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.Load;

public class LoadDaoImpl implements LoadDao{

	
	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(LoadDaoImpl.class);

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		LoadDaoImpl.entityManager = entityManager;
	}

	@Override
	public List<Load> getAllLoadEntry(Integer contractCompId) throws LogiwareExceptionHandler {

		List<Load> lLoad = null;
		CriteriaBuilder criteriaBuilder = null;
		try {
/*			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Load> criteriaQuery = criteriaBuilder.createQuery(Load.class);
			Root<Load> loadJpa = criteriaQuery.from(Load.class);
//			Predicate notDeleted=criteriaBuilder.equal(loadJpa.get("delFlag"), 'N');
//			Predicate contCompId=criteriaBuilder.equal(loadJpa.get("compId"), contractCompId);
			criteriaQuery.select(loadJpa);
			criteriaQuery.where(notDeleted);
			TypedQuery<Load> typedQuery = entityManager.createQuery(criteriaQuery);
			lLoad = typedQuery.getResultList();

			if (lLoad != null && lLoad.size() != 0) {
				return lLoad;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_LOAD_ENTRY_FOUND);
			}
*/
			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Load> criteriaQuery = criteriaBuilder
					.createQuery(Load.class);
			Root<Load> loadJpa = criteriaQuery.from(Load.class);
			criteriaQuery.select(loadJpa);
			TypedQuery<Load> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lLoad = typedQuery.getResultList();

			if (lLoad != null && lLoad.size() != 0) {
				return lLoad;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_CITY_FOUND);
			}


			
		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in loadDaoImpl - > getAllLoadEntry",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in loadDaoImpl - > getAllLoadEntry ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}

	}

}
