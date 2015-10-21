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

import com.admas.logiware.dto.CompanyRouteDto;
import com.admas.logiware.dto.LogiwareRespnse;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.logic.contractcomp.CompRouteLogic;
import com.admas.logiware.util.LogiWareConstants;

/**
 * @author 
 *  
 */

@Path("/compRouteServices")
public class CompRouteServices {

	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(CompRouteServices.class);

	private static CompRouteLogic compRouteLogicImpl;

	/**
	 * @return the compRouteLogicImpl
	 */
	public static CompRouteLogic getCompRouteLogicImpl() {
		return compRouteLogicImpl;
	}


	/**
	 * @param compRouteLogicImpl the compRouteLogicImpl to set
	 */
	public static void setCompRouteLogicImpl(CompRouteLogic compRouteLogicImpl) {
		CompRouteServices.compRouteLogicImpl = compRouteLogicImpl;
	}


	/*
	 * Employee Services
	 * */
	@GET
	@Path("/getAllCompRoute/{contractCompId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllCompRoute(@PathParam("contractCompId")Integer contractCompId){
		List<CompanyRouteDto> lCompRoute= new ArrayList<CompanyRouteDto>();
		logger.info(" Start  CompRouteServices- > getAllCompRoute ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {

			lCompRoute =compRouteLogicImpl.getAllCompRoute(contractCompId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setlCompanyRouteDto(lCompRoute);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompRouteServices- > getAllCompRoute", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in CompRouteServices- > getAllCompRoute", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompRouteServices- > getAllCompRoute");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	@GET
	@Path("/getCompRouteById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCompRouteById(@PathParam("id")Integer CompRouteId) {
		logger.info(" Start  CompRouteServices- > getCompRouteById ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		CompanyRouteDto companyRouteDto = null;
		try {
			companyRouteDto=compRouteLogicImpl.getCompRouteById(CompRouteId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setCompanyRouteDto(companyRouteDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompRouteServices- > getCompRouteById ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompRouteServices- > getCompRouteById ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompRouteServices- > getCompRouteById ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
	@POST
	@Path("/addCompRoute")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response addCompRoute(CompanyRouteDto CompRouteDto) {

		logger.info(" Start  CompRouteServices- > addCompRoute ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=compRouteLogicImpl.addCompRoute(CompRouteDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompRouteServices- > addCompRoute", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompRouteServices- > addCompRoute", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompRouteServices- > addCompRoute");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	
	@POST
	@Path("/editCompRoute")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response editEmployee(CompanyRouteDto CompRouteDto) {

		logger.info(" Start  CompRouteServices- > editCompRoute ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=compRouteLogicImpl.editCompRoute(CompRouteDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompRouteServices- > editCompRoute ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompRouteServices- > editCompRoute ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompRouteServices- > editCompRoute ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	@GET
	@Path("/deleteCompRoute/{CompRouteId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteCompRoute(@PathParam("CompRouteId")Integer CompRouteId) {

		logger.info(" Start  CompRouteServices- > deleteCompRoute ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=compRouteLogicImpl.deleteCompRoute(CompRouteId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompRouteServices- > deleteCompRoute ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompRouteServices- > deleteCompRoute ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompRouteServices- > deleteCompRoute ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
}
