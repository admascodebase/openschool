package com.admas.logiware.dao.masters;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admas.logiware.dto.CityDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.City;

public class MastersDaoImpl implements MastersDao {

	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(MastersDaoImpl.class);

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		MastersDaoImpl.entityManager = entityManager;
	}

	@Override
	public List<City> getAllCity() throws LogiwareExceptionHandler {

		List<City> lCities = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<City> criteriaQuery = criteriaBuilder
					.createQuery(City.class);
			Root<City> cityJpa = criteriaQuery.from(City.class);
			criteriaQuery.select(cityJpa);
			TypedQuery<City> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lCities = typedQuery.getResultList();

			if (lCities != null && lCities.size() != 0) {
				return lCities;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_CITY_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > getAllCity ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addCity(CityDto cityDto) throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			City city = new City();
			city.setName(cityDto.getName());
			city.setStateId(cityDto.getStateId());
			city.setDelFlag('N');
			entityManager.persist(city);
			entityManager.flush();

			if (city.getId() != null || city.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > getAllCity ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editCity(CityDto cityDto) throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			City city = new City();
			city.setId(cityDto.getId());
			city.setName(cityDto.getName());
			city.setStateId(cityDto.getStateId());
			city.setDelFlag('N');			
			entityManager.merge(city);
			entityManager.flush();
			if (city.getId() != null || city.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > editCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
//			 logger.error("Exception Error in MastersDaoImpl - > editCity ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteCity(CityDto cityDto) throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			Query query = entityManager.createQuery(
					"UPDATE City SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", cityDto.getId());
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > deleteCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
//			 logger.error(
//			 "Exception Error in UserManagementDaoImpl - > deleteCity", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

}
