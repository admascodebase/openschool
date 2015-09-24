package com.admas.logiware.logic.contractcomp;

import java.util.List;

import com.admas.logiware.dto.PaymentExceptionDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;


public interface PaymentExceptionLogic {	
	
	public List<PaymentExceptionDto> getAllPaymentException(Integer contractCompId)throws LogiwareExceptionHandler;

	public PaymentExceptionDto getPaymentExceptionById(Integer paymentExceptionId)throws LogiwareExceptionHandler;

	public Boolean addPaymentException(PaymentExceptionDto paymentExceptionDto)throws LogiwareExceptionHandler;

	public Boolean editPaymentException(PaymentExceptionDto paymentExceptionDto)throws LogiwareExceptionHandler;

	public Boolean deletePaymentException(Integer paymentExceptionId)throws LogiwareExceptionHandler;
}
