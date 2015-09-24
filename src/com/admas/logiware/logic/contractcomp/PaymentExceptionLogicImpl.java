package com.admas.logiware.logic.contractcomp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dao.contractcomp.PaymentExceptionDao;
import com.admas.logiware.dto.PaymentExceptionDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.PaymentException;

public class PaymentExceptionLogicImpl implements PaymentExceptionLogic {

	private static PaymentExceptionDao paymentExceptionDaoImpl;
	
	Logger logger = LoggerFactory.getLogger(PaymentExceptionLogicImpl.class);	

	/**
	 * @return the paymentExceptionDaoImpl
	 */
	public static PaymentExceptionDao getPaymentExceptionDaoImpl() {
		return paymentExceptionDaoImpl;
	}

	/**
	 * @param paymentExceptionDaoImpl the paymentExceptionDaoImpl to set
	 */
	public static void setPaymentExceptionDaoImpl(
			PaymentExceptionDao paymentExceptionDaoImpl) {
		PaymentExceptionLogicImpl.paymentExceptionDaoImpl = paymentExceptionDaoImpl;
	}

	@Override
	public List<PaymentExceptionDto> getAllPaymentException(
			Integer contractCompId) throws LogiwareExceptionHandler {
		List<PaymentException> lPaymentExceptions = null;
		List<PaymentExceptionDto> lPaymentExceptionDtos = new ArrayList<PaymentExceptionDto>();
		try {
			lPaymentExceptions = paymentExceptionDaoImpl.getAllPaymentException(contractCompId);

			for (PaymentException paymentException : lPaymentExceptions) {
				lPaymentExceptionDtos.add(paymentException._toDto());
			}

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in PaymentExceptionLogicImpl - > getAllPaymentException ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lPaymentExceptionDtos;
	}

	@Override
	public PaymentExceptionDto getPaymentExceptionById(
			Integer paymentExceptionId) throws LogiwareExceptionHandler {
		PaymentException compRoute = null;
		try {
			compRoute = paymentExceptionDaoImpl.getPaymentExceptionById(paymentExceptionId);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in PaymentExceptionLogicImpl - > getPaymentExceptionById ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return compRoute._toDto();
	}

	@Override
	public Boolean addPaymentException(PaymentExceptionDto paymentExceptionDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = paymentExceptionDaoImpl.addPaymentException(paymentExceptionDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in PaymentExceptionLogicImpl - > addPaymentException ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean editPaymentException(PaymentExceptionDto paymentExceptionDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = paymentExceptionDaoImpl.editPaymentException(paymentExceptionDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in PaymentExceptionLogicImpl - > editPaymentException ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean deletePaymentException(Integer paymentExceptionId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = paymentExceptionDaoImpl.deletePaymentException(paymentExceptionId);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in PaymentExceptionLogicImpl - > deletePaymentException ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}	
	
}