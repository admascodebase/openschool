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
import com.admas.logiware.dto.CompanyRouteDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.CompProduct;
import com.admas.logiware.jpa.CompanyRoute;

public class CompProductDaoImpl implements CompProductDao {

	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(CompProductDaoImpl.class);

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		CompProductDaoImpl.entityManager = entityManager;
	}

	@Override
	public List<CompProduct> getAllCompProduct(Integer contractCompId) throws LogiwareExceptionHandler {
		List<CompProduct> lCompProducts = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<CompProduct> criteriaQuery = criteriaBuilder
					.createQuery(CompProduct.class);
			Root<CompProduct> companyRouteJpa = criteriaQuery.from(CompProduct.class);
			Predicate notDeleted=criteriaBuilder.equal(companyRouteJpa.get("delFlag"), 'N');
			Predicate contCompId=criteriaBuilder.equal(companyRouteJpa.get("compId"), contractCompId);
			criteriaQuery.select(companyRouteJpa);
			criteriaQuery.where(notDeleted, contCompId);
			TypedQuery<CompProduct> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lCompProducts = typedQuery.getResultList();

			if (lCompProducts != null && lCompProducts.size() != 0) {
				return lCompProducts;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_CONTRACT_COMP_PRODUCT_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in CompProductDaoImpl - > getAllCompProduct",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in CompProductDaoImpl - > getAllCompProduct ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	public CompProduct getCompProductById(Integer comprouteId)
			throws LogiwareExceptionHandler {
		CompProduct compProduct = null;
		try {

			TypedQuery<CompProduct> comprouteQuery = entityManager.createQuery(
					"SELECT e FROM CompProduct e WHERE id = :id", CompProduct.class);
			comprouteQuery.setParameter("id", comprouteId);
			compProduct = comprouteQuery.getSingleResult();

			if (compProduct != null) {
				return compProduct;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_CONTRACT_COMP_PRODUCT_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in CompProductDaoImpl - > getCompProductById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in CompProductDaoImpl - > getCompProductById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addCompProduct(CompProductDto compProductDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {			
			CompProduct compProduct = new CompProduct();
			compProduct = compProductDto._toJpa();
			entityManager.persist(compProduct);
			entityManager.flush();
			if (compProduct.getId() != null || compProduct.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in CompProductDaoImpl - > addCompProduct",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception Error in CompProductDaoImpl - > addCompProduct",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editCompProduct(CompProductDto compProductDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			CompProduct contractCompany= new CompProduct();
			contractCompany = compProductDto._toJpa();
			
			entityManager.merge(contractCompany);
			entityManager.flush();
			if (compProductDto._toJpa().getId() != null || compProductDto._toJpa().getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in CompProductDaoImpl - > editCompProduct",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception Error in CompProductDaoImpl - > editCompProduct",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteCompProduct(Integer comprouteId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE CompProduct SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", comprouteId);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in CompProductDaoImpl - > deleteCompProduct",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error(
			"Exception Error in CompProductDaoImpl - > deleteCompProduct", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}
	
}
