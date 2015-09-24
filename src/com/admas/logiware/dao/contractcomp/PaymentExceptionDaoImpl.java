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
import com.admas.logiware.dto.PaymentExceptionDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.CompanyRoute;
import com.admas.logiware.jpa.PaymentException;

public class PaymentExceptionDaoImpl implements PaymentExceptionDao {

	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(PaymentExceptionDaoImpl.class);

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		PaymentExceptionDaoImpl.entityManager = entityManager;
	}

	@Override
	public List<PaymentException> getAllPaymentException(Integer contractCompId)
			throws LogiwareExceptionHandler {
		List<PaymentException> lPaymentException = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<PaymentException> criteriaQuery = criteriaBuilder
					.createQuery(PaymentException.class);
			Root<PaymentException> paymentExceptionJpa = criteriaQuery.from(PaymentException.class);
			Predicate notDeleted=criteriaBuilder.equal(paymentExceptionJpa.get("delFlag"), 'N');
			Predicate selectedContractComp=criteriaBuilder.equal(paymentExceptionJpa.get("contractCompId"), contractCompId);
			criteriaQuery.select(paymentExceptionJpa);
			criteriaQuery.where(notDeleted);
			criteriaQuery.where(selectedContractComp);
			TypedQuery<PaymentException> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lPaymentException = typedQuery.getResultList();

			if (lPaymentException != null && lPaymentException.size() != 0) {
				return lPaymentException;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_PAY_EXCEPTION_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in PaymentExceptionDaoImpl - > getAllPaymentException",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in PaymentExceptionDaoImpl - > getAllPaymentException ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	public PaymentException getPaymentExceptionById(Integer paymentExceptionId)
			throws LogiwareExceptionHandler {
		PaymentException paymentException = null;
		try {

			TypedQuery<PaymentException> comprouteQuery = entityManager.createQuery(
					"SELECT e FROM PaymentException e WHERE id = :id", PaymentException.class);
			comprouteQuery.setParameter("id", paymentExceptionId);
			paymentException = comprouteQuery.getSingleResult();

			if (paymentException != null) {
				return paymentException;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_PAY_EXCEPTION_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in PaymentExceptionDaoImpl - > getPaymentExceptionById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in PaymentExceptionDaoImpl - > getPaymentExceptionById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addPaymentException(PaymentExceptionDto paymentExceptionDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {			
			PaymentException paymentException = new PaymentException();
			paymentException = paymentExceptionDto._toJpa();
			entityManager.persist(paymentException);
			entityManager.flush();
			if (paymentException.getId() != null || paymentException.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in PaymentExceptionDaoImpl - > addPaymentException",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception Error in PaymentExceptionDaoImpl - > addPaymentException",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editPaymentException(PaymentExceptionDto paymentExceptionDto)
			throws LogiwareExceptionHandler {
		try {
			PaymentException paymentException= new PaymentException();
			paymentException = paymentExceptionDto._toJpa();
			
			entityManager.merge(paymentException);
			entityManager.flush();
			return true;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in PaymentExceptionDaoImpl - > editPaymentException",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception Error in PaymentExceptionDaoImpl - > editPaymentException",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deletePaymentException(Integer paymentExceptionId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE PaymentException SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", paymentExceptionId);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in PaymentExceptionDaoImpl - > deletePaymentException",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error(
			"Exception Error in PaymentExceptionDaoImpl - > deletePaymentException", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}
	
}
