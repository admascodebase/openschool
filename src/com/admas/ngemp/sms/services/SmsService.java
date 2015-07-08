package com.admas.ngemp.sms.services;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.ngemp.sms.dto.SmsDto;
import com.admas.ngemp.sms.dto.SmsTemplateDto;
import com.admas.ngemp.sms.exception.ExceptionHandler;
import com.admas.ngemp.sms.logic.ISmsLogic;

@Path("/smsServices")
public class SmsService {

	static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory
			.getLogger(SmsService.class);
	Logger logger = LoggerFactory.getLogger(SmsService.class);
	private static ISmsLogic smsLogicImpl;

	@GET
	@Path("/sendSms/{mobile}/{message}/{route}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response sendSms(@PathParam("mobile") String mobile,
			@PathParam("message") String message,
			@PathParam("route") String route,SmsDto smsDto) {
		String result = "";
		LOG.info(" start  SmsService- > sendSms");
		try {			
			result = smsLogicImpl.sendSms(smsDto, mobile, message, route);
		} catch (ExceptionHandler e) {
		  LOG.error("Error in SmsService- > sendSms",e);
		} catch (Exception e) {
			 LOG.error("Error in SmsService- > sendSms",e);
		}
		LOG.info(" end  SmsService- > sendSms");
		return Response.status(200).entity(result).build();

	}

	@POST
	@Path("/sendSmsToMany")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response sendSmsToMany(SmsDto smsDto) throws Exception {
		String result="";
		logger.info("#######GG######## json object"+smsDto);
		for (String Contact: smsDto.getContactNos()) {
			logger.info("$$$$$$$$$$$contacts==="+Contact);
			result=result+smsLogicImpl.sendSms(smsDto, Contact, smsDto.getMessage(), smsDto.getRoute().toString())+",";
		}
		
//		String result = smsLogicImpl.sendSms(smsDto);
		return Response.status(200).entity(result).build();
	}

	
	@GET
	@Path("/getDeleveryReport/{orgCode}/{messageId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getDeleveryReport(@PathParam("orgCode") String orgCode,
			@PathParam("messageId") String messageId) throws Exception {
		String result = "";
		try {
			result = smsLogicImpl.getDeleveryReport(orgCode, messageId);
		} catch (Exception e) {
		}
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/getBalance/{route}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getBalance(@PathParam("route") String route)
			throws Exception {

		String result = "";
		try {
			result = smsLogicImpl.getBalance(Integer.parseInt(route));
		} catch (Exception e) {
		}

		return Response.status(200).entity(result).build();
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
