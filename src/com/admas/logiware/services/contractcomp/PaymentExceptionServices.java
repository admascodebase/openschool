package com.admas.logiware.services.contractcomp;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.admas.logiware.dto.LogiwareRespnse;
import com.admas.logiware.dto.PaymentExceptionDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.logic.contractcomp.PaymentExceptionLogic;
import com.admas.logiware.util.LogiWareConstants;

/**
 * @author 
 *  
 */

@Path("/paymentExceptionServices")
public class PaymentExceptionServices {

	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(PaymentExceptionServices.class);

	private static PaymentExceptionLogic paymentExceptionLogicImpl;	

	@GET
	@Path("/getAllPaymentException/{ContractCompid}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllPaymentException(@PathParam("ContractCompid")Integer contractCompId){
		List<PaymentExceptionDto> lPaymentExceptionDtos= new ArrayList<PaymentExceptionDto>();
		logger.info(" Start  PaymentExceptionServices- > getAllCompRoute ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {
			lPaymentExceptionDtos =paymentExceptionLogicImpl.getAllPaymentException(contractCompId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(lPaymentExceptionDtos);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in PaymentExceptionServices- > getAllPaymentException", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in PaymentExceptionServices- > getAllPaymentException", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  PaymentExceptionServices- > getAllPaymentException");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	@GET
	@Path("/getPaymentExceptionById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getPaymentExceptionById(@PathParam("id")Integer id) {
		logger.info(" Start  PaymentExceptionServices- > getCompRouteById ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		PaymentExceptionDto paymentExceptionDto = null;
		try {
			paymentExceptionDto=paymentExceptionLogicImpl.getPaymentExceptionById(id);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setPaymentExceptionDto(paymentExceptionDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in PaymentExceptionServices- > getPaymentExceptionById ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in PaymentExceptionServices- > getPaymentExceptionById ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  PaymentExceptionServices- > getPaymentExceptionById ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
	@POST
	@Path("/addPaymentException")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response addPaymentException(PaymentExceptionDto paymentExceptionDto) {

		logger.info(" Start  PaymentExceptionServices- > addPaymentException ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=paymentExceptionLogicImpl.addPaymentException(paymentExceptionDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in PaymentExceptionServices- > addPaymentException", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in PaymentExceptionServices- > addPaymentException", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  PaymentExceptionServices- > addPaymentException");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	
	@POST
	@Path("/editPaymentException")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response editPaymentException(PaymentExceptionDto paymentExceptionDto) {

		logger.info(" Start  PaymentExceptionServices- > editPaymentException ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=paymentExceptionLogicImpl.editPaymentException(paymentExceptionDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in PaymentExceptionServices- > editPaymentException ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in PaymentExceptionServices- > editPaymentException ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  PaymentExceptionServices- > editCompRoute ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	@GET
	@Path("/deletePaymentException/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deletePaymentException(@PathParam("id")Integer id) {

		logger.info(" Start  PaymentExceptionServices- > deletePaymentException ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=paymentExceptionLogicImpl.deletePaymentException(id);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in PaymentExceptionServices- > deletePaymentException ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in PaymentExceptionServices- > deletePaymentException ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  PaymentExceptionServices- > deletePaymentException ");
		return Response.status(200).entity(logiwareRespnse).build();
	}


	/**
	 * @return the paymentExceptionLogicImpl
	 */
	public static PaymentExceptionLogic getPaymentExceptionLogicImpl() {
		return paymentExceptionLogicImpl;
	}


	/**
	 * @param paymentExceptionLogicImpl the paymentExceptionLogicImpl to set
	 */
	public static void setPaymentExceptionLogicImpl(
			PaymentExceptionLogic paymentExceptionLogicImpl) {
		PaymentExceptionServices.paymentExceptionLogicImpl = paymentExceptionLogicImpl;
	}

	
	
}
