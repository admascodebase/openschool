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
import com.admas.logiware.dto.RoutePaySettingDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.logic.contractcomp.RoutePaySettingLogic;
import com.admas.logiware.util.LogiWareConstants;

@Path("/routePaymentSettingServices")
public class RoutePaymentServices {

	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(RoutePaymentServices.class);

	private static RoutePaySettingLogic routePaySettingLogicImpl;
	

	/**
	 * @return the routePaySettingLogicImpl
	 */
	public static RoutePaySettingLogic getRoutePaySettingLogicImpl() {
		return routePaySettingLogicImpl;
	}


	/**
	 * @param routePaySettingLogicImpl the routePaySettingLogicImpl to set
	 */
	public static void setRoutePaySettingLogicImpl(
			RoutePaySettingLogic routePaySettingLogicImpl) {
		RoutePaymentServices.routePaySettingLogicImpl = routePaySettingLogicImpl;
	}


	/*
	 * 
	 * */
	@GET
	@Path("/getAllRoutePaySetting/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllRoutePaySetting(@PathParam("id")Integer id){
		List< RoutePaySettingDto> lRoutePaySettingDto= new ArrayList< RoutePaySettingDto>();
		logger.info(" Start  RoutePaySettingService- > getAllCompRoute ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {

			lRoutePaySettingDto =routePaySettingLogicImpl.getAllRoutePaySetting(id);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(lRoutePaySettingDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in RoutePaySettingService- > getAllRoutePaySetting", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in RoutePaySettingService- > getAllRoutePaySetting", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  RoutePaySettingService- > getAllRoutePaySetting");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	@GET
	@Path("/getRoutePaySettingById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getRoutePaySettingById(@PathParam("id")Integer id) {
		logger.info(" Start  RoutePaySettingService- > getRoutePaySettingById ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		RoutePaySettingDto routePaySettingDto = null;
		try {
			routePaySettingDto=routePaySettingLogicImpl.getRoutePaySettingById(id);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setRoutePaySettingDto(routePaySettingDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in RoutePaySettingService- > getRoutePaySettingById ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in RoutePaySettingService- > getRoutePaySettingById ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  RoutePaySettingService- > getRoutePaySettingById ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
	@POST
	@Path("/addRoutePaySetting")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response addRoutePaySetting(RoutePaySettingDto routePaySettingDto) {

		logger.info(" Start  RoutePaySettingService- > addRoutePaySetting ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=routePaySettingLogicImpl.addRoutePaySetting(routePaySettingDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in RoutePaySettingService- > addRoutePaySetting", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in RoutePaySettingService- > addRoutePaySetting", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  RoutePaySettingService- > addRoutePaySetting");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	
	@POST
	@Path("/editRoutePaySetting")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response editRoutePaySetting(RoutePaySettingDto routePaySettingDto) {

		logger.info(" Start  RoutePaySettingService- > editRoutePaySetting ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=routePaySettingLogicImpl.editRoutePaySetting(routePaySettingDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in RoutePaySettingService- > editRoutePaySetting ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in RoutePaySettingService- > editRoutePaySetting ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  RoutePaySettingService- > editRoutePaySetting ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	@GET
	@Path("/deleteRoutePaySetting/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteRoutePaySetting(@PathParam("id")Integer id) {

		logger.info(" Start  RoutePaySettingService- > deleteCompRoute ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=routePaySettingLogicImpl.deleteRoutePaySetting(id);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in RoutePaySettingService- > deleteRoutePaySetting ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in RoutePaySettingService- > deleteRoutePaySetting ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  RoutePaySettingService- > deleteRoutePaySetting ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
}
