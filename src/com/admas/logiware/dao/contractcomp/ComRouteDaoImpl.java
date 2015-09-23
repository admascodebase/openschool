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

import com.admas.logiware.dto.CompanyRouteDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.CompanyRoute;

public class ComRouteDaoImpl implements CompRouteDao {

	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(ComRouteDaoImpl.class);

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		ComRouteDaoImpl.entityManager = entityManager;
	}

	@Override
	public List<CompanyRoute> getAllCompRoute() throws LogiwareExceptionHandler {
		List<CompanyRoute> lCompRoutes = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<CompanyRoute> criteriaQuery = criteriaBuilder
					.createQuery(CompanyRoute.class);
			Root<CompanyRoute> companyRouteJpa = criteriaQuery.from(CompanyRoute.class);
			Predicate notDeleted=criteriaBuilder.equal(companyRouteJpa.get("delFlag"), 'N');
			criteriaQuery.select(companyRouteJpa);
			criteriaQuery.where(notDeleted);
			TypedQuery<CompanyRoute> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lCompRoutes = typedQuery.getResultList();

			if (lCompRoutes != null && lCompRoutes.size() != 0) {
				return lCompRoutes;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_CONTRACT_COMP_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ComRouteDaoImpl - > getAllCompRoute",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in ComRouteDaoImpl - > getAllCompRoute ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	public CompanyRoute getCompRouteById(Integer comprouteId)
			throws LogiwareExceptionHandler {
		CompanyRoute compRoute = null;
		try {

			TypedQuery<CompanyRoute> comprouteQuery = entityManager.createQuery(
					"SELECT e FROM CompanyRoute e WHERE id = :id", CompanyRoute.class);
			comprouteQuery.setParameter("id", comprouteId);
			compRoute = comprouteQuery.getSingleResult();

			if (compRoute != null) {
				return compRoute;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_EMPLOYEE_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ComRouteDaoImpl - > getCompRouteById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in ComRouteDaoImpl - > getCompRouteById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addCompRoute(CompanyRouteDto companyRouteDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {			
			CompanyRoute compRoute = new CompanyRoute();
			compRoute = companyRouteDto._toJpa();
			entityManager.persist(compRoute);
			entityManager.flush();
			if (compRoute.getId() != null || compRoute.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ComRouteDaoImpl - > addCompRoute",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception Error in ComRouteDaoImpl - > addCompRoute",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editCompRoute(CompanyRouteDto companyRouteDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			CompanyRoute contractCompany= new CompanyRoute();
			contractCompany = companyRouteDto._toJpa();
			
			entityManager.merge(contractCompany);
			entityManager.flush();
			if (companyRouteDto._toJpa().getId() != null || companyRouteDto._toJpa().getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ComRouteDaoImpl - > editCompRoute",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception Error in ComRouteDaoImpl - > editCompRoute",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteCompRoute(Integer comprouteId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE CompanyRoute SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", comprouteId);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in ComRouteDaoImpl - > deleteCompRoute",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error(
			"Exception Error in ComRouteDaoImpl - > deleteCompRoute", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}
	
}
