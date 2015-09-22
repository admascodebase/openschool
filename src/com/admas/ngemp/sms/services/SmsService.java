package com.admas.ngemp.sms.services;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dto.LogiwareRespnse;
import com.admas.logiware.dto.sms.SmsDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.util.LogiWareConstants;
import com.admas.ngemp.sms.logic.ISmsLogic;

@Path("/smsServices")
public class SmsService {

	static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory
			.getLogger(SmsService.class);
	Logger logger = LoggerFactory.getLogger(SmsService.class);
	private static ISmsLogic smsLogicImpl;

	@GET
	@Path("/sendSms/{mobile}/{message}/{route}/{orgCode}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response sendSms(@PathParam("mobile") String mobile,
			@PathParam("message") String message,
			@PathParam("route") String route,@PathParam("orgCode") String orgCode) {
		String result = "";
		LOG.info(" start  SmsService- > sendSms");		
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {
			result = smsLogicImpl.sendSms( mobile, message, route,orgCode);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > sendSms", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > sendSms", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > sendSms");
		return Response.status(200).entity(logiwareRespnse).build();	

	}

	@POST
	@Path("/sendSmsToMany")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response sendSmsToMany(SmsDto smsDto) throws Exception {
		
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {
			Map<String,String> result =smsLogicImpl.sendSms(smsDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > sendSmsToMany", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > sendSmsToMany", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > sendSmsToMany ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
	@GET
	@Path("/getDeleveryReport/{orgCode}/{messageId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getDeleveryReport(@PathParam("orgCode") String orgCode,
			@PathParam("messageId") String messageId) throws Exception {
		String result = "";
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {
			result = smsLogicImpl.getDeleveryReport(orgCode, messageId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > getDeleveryReport", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > getDeleveryReport", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > getDeleveryReport");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	@GET
	@Path("/getBalance/{route}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getBalance(@PathParam("route") String route)
			throws Exception {
		String result = "";
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {
			result = smsLogicImpl.getBalance(Integer.parseInt(route));
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > getBalance", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > getBalance", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > getBalance");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	@POST
	@Path("/sendSmsToManyAsync")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response sendSmsToManyAsync(SmsDto smsDto) throws Exception {
		
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {
			boolean result =smsLogicImpl.saveSms(smsDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > getBalance", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > getBalance", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > getBalance");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	/**
	 * @return the smsLogicImpl
	 */
	public static ISmsLogic getSmsLogicImpl() {
		return smsLogicImpl;
	}

	/**
	 * @param smsLogicImpl
	 *            the smsLogicImpl to set
	 */
	public static void setSmsLogicImpl(ISmsLogic smsLogicImpl) {
		SmsService.smsLogicImpl = smsLogicImpl;
	}

}
