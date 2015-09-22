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
import com.admas.logiware.dto.LoweryOwnerDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.services.masters.MasterServices;
import com.admas.logiware.transowner.logic.TransOwnerLogic;
import com.admas.logiware.util.LogiWareConstants;

/**
 * @author Raj
 * 
 */
@Path("/transOwnerServices")
public class TransOwnerServices {
	
	
	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(MasterServices.class);

	private static TransOwnerLogic transOwnerLogicImpl;	
	
	

	/**
	 * @return the transOwnerLogicImpl
	 */
	public static TransOwnerLogic getTransOwnerLogicImpl() {
		return transOwnerLogicImpl;
	}


	/**
	 * @param transOwnerLogicImpl the transOwnerLogicImpl to set
	 */
	public static void setTransOwnerLogicImpl(TransOwnerLogic transOwnerLogicImpl) {
		TransOwnerServices.transOwnerLogicImpl = transOwnerLogicImpl;
	}


	/*
	 * Lowery Owner Services
	 * */
	@GET
	@Path("/getTransOwner")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllTransOwner(){
		List<LoweryOwnerDto> lLoweryOwnerDtos= new ArrayList<LoweryOwnerDto>();
		logger.info(" Start  TransOwnerServices- > getAllTransOwner ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {

			lLoweryOwnerDtos = transOwnerLogicImpl.getAllTransOwner();
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(lLoweryOwnerDtos);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in TransOwnerServices- > getAllTransOwner", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in TransOwnerServices- > getAllTransOwner", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  TransOwnerServices- > getAllTransOwner");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	@GET
	@Path("/getTransOwnerById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTransOwnerById(@PathParam("id")Integer transOwnerId) {
		logger.info(" Start  TransOwnerServices- > getTransOwnerById ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		LoweryOwnerDto loweryOwnerDto = null;
		try {
			loweryOwnerDto=transOwnerLogicImpl.getTransOwnerById(transOwnerId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setLoweryOwnerDto(loweryOwnerDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in TransOwnerServices- > getTransOwnerById ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in TransOwnerServices- > getTransOwnerById ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  TransOwnerServices- > getTransOwnerById ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
	@POST
	@Path("/addTransOwner")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response addTransOwner(LoweryOwnerDto transOwnerDto) {

		logger.info(" Start  TransOwnerServices- > addTransOwner ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=transOwnerLogicImpl.addTransOwner(transOwnerDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in TransOwnerServices- > addTransOwner", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in TransOwnerServices- > addTransOwner", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  TransOwnerServices- > addTransOwner");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	
	@POST
	@Path("/editTransOwner")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response editTransOwner(LoweryOwnerDto transOwnerDto) {

		logger.info(" Start  TransOwnerServices- > editTransOwner ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=transOwnerLogicImpl.editTransOwner(transOwnerDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in TransOwnerServices- > editTransOwner ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in TransOwnerServices- > editTransOwner ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  TransOwnerServices- > editTransOwner ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	

	
	@GET
	@Path("/deleteTransOwner/{transId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteTransOwner(@PathParam("transId")Integer transOwnerId) {

		logger.info(" Start  TransOwnerServices- > deleteTransOwner ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=transOwnerLogicImpl.deleteTransOwner(transOwnerId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in TransOwnerServices- > deleteTransOwner ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in TransOwnerServices- > deleteTransOwner ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  TransOwnerServices- > deleteTransOwner ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	}
