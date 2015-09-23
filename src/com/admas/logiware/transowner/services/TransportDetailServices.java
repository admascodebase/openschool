/**
 * 
 */
package com.admas.logiware.transowner.services;

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
import com.admas.logiware.dto.TransportDetailsDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.services.masters.MasterServices;
import com.admas.logiware.transowner.logic.TransportDetailLogic;
import com.admas.logiware.util.LogiWareConstants;

/**
 * @author
 * 
 */
@Path("/transportDetailServices")
public class TransportDetailServices {

	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(MasterServices.class);

	private static TransportDetailLogic transportDetailLogicImpl;

	
	/**
	 * @return the transportDetailLogicImpl
	 */
	public static TransportDetailLogic getTransportDetailLogicImpl() {
		return transportDetailLogicImpl;
	}

	/**
	 * @param transportDetailLogicImpl the transportDetailLogicImpl to set
	 */
	public static void setTransportDetailLogicImpl(
			TransportDetailLogic transportDetailLogicImpl) {
		TransportDetailServices.transportDetailLogicImpl = transportDetailLogicImpl;
	}

	/*
	 * Lowery Owner Services
	 */
	@GET
	@Path("/getTransportDetail/{transOwnerId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTransportDetail(@PathParam("transOwnerId") Integer transOwnerId) {
		List<TransportDetailsDto> transportDetailsDto = new ArrayList<TransportDetailsDto>();
		logger.info(" Start  TransportDetailServices- > getTransportDetail ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {

			transportDetailsDto = transportDetailLogicImpl.getAllTransportDetail(transOwnerId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(transportDetailsDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in TransportDetailServices- > getTransportDetail", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in TransportDetailServices- > getTransportDetail", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  TransportDetailServices- > getTransportDetail");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	@GET
	@Path("/getTransportDetailById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTransportDetailById(@PathParam("id") Integer transId) {
		logger.info(" Start  TransportDetailServices- > getTransOwnerById ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		TransportDetailsDto transportDetailsDto = null;
		try {
			transportDetailsDto = transportDetailLogicImpl.getTransportDetailById(transId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setTransportDetailsDto(transportDetailsDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in TransportDetailServices- > getTransportDetailById ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in TransportDetailServices- > getTransportDetailById ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  TransOwnerServices- > getTransportDetailById ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	@POST
	@Path("/addTransportDetail")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addTransportDetail(TransportDetailsDto transportDetailsDto) {

		logger.info(" Start  TransportDetailServices- > addTransportDetail ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result = false;
		try {
			result = transportDetailLogicImpl.addTransportDetail(transportDetailsDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in TransportDetailServices- > addTransportDetail", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in TransportDetailServices- > addTransportDetail", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  TransportDetailServices- > addTransportDetail");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	@POST
	@Path("/editTransportDetail")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response editTransOwner(TransportDetailsDto transportDetailsDto) {

		logger.info(" Start  TransportDetailServices- > editTransOwner ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result = false;
		try {
			result = transportDetailLogicImpl.editTransportDetail(transportDetailsDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in TransportDetailServices- > editTransOwner ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in TransportDetailServices- > editTransOwner ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  TransportDetailServices- > editTransOwner ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	@GET
	@Path("/deleteTransportDetail/{transId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteTransportDetail(@PathParam("transId") Integer transportDetailsId) {

		logger.info(" Start  TransportDetailServices- > deleteTransportDetail ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result = false;
		try {
			result = transportDetailLogicImpl.deleteTransportDetail(transportDetailsId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in TransportDetailServices- > deleteTransportDetail ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in TransportDetailServices- > deleteTransportDetail ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  TransportDetailServices- > deleteTransOwner ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
}
