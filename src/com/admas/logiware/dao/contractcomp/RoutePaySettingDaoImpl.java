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

import com.admas.logiware.dto.RoutePaySettingDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.RoutePaySetting;

public class RoutePaySettingDaoImpl implements RoutePaySettingDao {

	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(RoutePaySettingDaoImpl.class);

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		RoutePaySettingDaoImpl.entityManager = entityManager;
	}

	@Override
	public List<RoutePaySetting> getAllRoutePaySetting(Integer routeId)
			throws LogiwareExceptionHandler {
		List<RoutePaySetting> routePaySetting = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<RoutePaySetting> criteriaQuery = criteriaBuilder
					.createQuery(RoutePaySetting.class);
			Root<RoutePaySetting> jpa = criteriaQuery.from(RoutePaySetting.class);
			Predicate notDeleted=criteriaBuilder.equal(jpa.get("delFlag"), 'N');
			Predicate route=criteriaBuilder.equal(jpa.get("routeId"), routeId);
			criteriaQuery.select(jpa);
			criteriaQuery.where(notDeleted, route);
			TypedQuery<RoutePaySetting> typedQuery = entityManager
					.createQuery(criteriaQuery);
			routePaySetting = typedQuery.getResultList();

			if (routePaySetting != null && routePaySetting.size() != 0) {
				return routePaySetting;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_ROUTE_PAY_SETTING_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in RoutePaySettingDaoImpl - > getAllRoutePaySetting",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in RoutePaySettingDaoImpl - > getAllRoutePaySetting ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	public RoutePaySetting getRoutePaySettingById(Integer id)
			throws LogiwareExceptionHandler {
		RoutePaySetting routePaySetting = null;
		try {

			TypedQuery<RoutePaySetting> comprouteQuery = entityManager.createQuery(
					"SELECT e FROM RoutePaySetting e WHERE id = :id", RoutePaySetting.class);
			comprouteQuery.setParameter("id", id);
			routePaySetting = comprouteQuery.getSingleResult();

			if (routePaySetting != null) {
				return routePaySetting;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_ROUTE_PAY_SETTING_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in RoutePaySettingDaoImpl - > getRoutePaySettingById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in RoutePaySettingDaoImpl - > getRoutePaySettingById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean addRoutePaySetting(RoutePaySettingDto routePaySettingDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {			
			RoutePaySetting routePaySetting = new RoutePaySetting();
			routePaySetting = routePaySettingDto._toJpa();
			entityManager.persist(routePaySettingDto._toJpa());
			entityManager.flush();
			if (routePaySetting.getId() != null || routePaySetting.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in RoutePaySettingDaoImpl - > addRoutePaySetting",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception Error in RoutePaySettingDaoImpl - > addRoutePaySetting",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean editRoutePaySetting(RoutePaySettingDto routePaySettingDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			RoutePaySetting contractCompany= new RoutePaySetting();
			contractCompany = routePaySettingDto._toJpa();			
			entityManager.merge(contractCompany);
			entityManager.flush();
			if (routePaySettingDto._toJpa().getId() != null || routePaySettingDto._toJpa().getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in RoutePaySettingDaoImpl - > editRoutePaySetting",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception Error in RoutePaySettingDaoImpl - > editRoutePaySetting",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Boolean deleteRoutePaySetting(Integer id)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE RoutePaySetting SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", id);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in RoutePaySettingDaoImpl - > deleteRoutePaySetting",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error(
			"Exception Error in RoutePaySettingDaoImpl - > deleteCompRoute", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}
	
}
