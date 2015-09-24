package com.admas.logiware.dao.contractcomp;

import java.util.List;

import com.admas.logiware.dto.PaymentExceptionDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.jpa.PaymentException;


public interface PaymentExceptionDao {
	
	public List<PaymentException> getAllPaymentException(Integer contractCompId)throws LogiwareExceptionHandler;

	public PaymentException getPaymentExceptionById(Integer paymentExceptionId)throws LogiwareExceptionHandler;

	public Boolean addPaymentException(PaymentExceptionDto paymentExceptionDto)throws LogiwareExceptionHandler;

	public Boolean editPaymentException(PaymentExceptionDto paymentExceptionDto)throws LogiwareExceptionHandler;

	public Boolean deletePaymentException(Integer paymentExceptionId)throws LogiwareExceptionHandler;
}
