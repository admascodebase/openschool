/**
 * 
 */
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

import com.admas.logiware.dto.CompanyLoadToTransDto;
import com.admas.logiware.dto.response.CompLoadToTransResponse;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.logic.contractcomp.CompLoadToTransLogic;
import com.admas.logiware.util.LogiWareConstants;

@Path("/compLoadToTransServices")
public class CompLoadToTransServices {

	
	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(ContractCompServices.class);

	private static CompLoadToTransLogic compLoadToTransLogicImpl;

	
	
	/**
	 * @return the compLoadToTransLogicImpl
	 */
	public static CompLoadToTransLogic getCompLoadToTransLogicImpl() {
		return compLoadToTransLogicImpl;
	}


	/**
	 * @param compLoadToTransLogicImpl the compLoadToTransLogicImpl to set
	 */
	public static void setCompLoadToTransLogicImpl(
			CompLoadToTransLogic compLoadToTransLogicImpl) {
		CompLoadToTransServices.compLoadToTransLogicImpl = compLoadToTransLogicImpl;
	}


	@GET
	@Path("/getAllCompLoadToTrans/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllCompLoadToTrans(){
		List<CompanyLoadToTransDto> lCompanyLoadToTransDto= new ArrayList<CompanyLoadToTransDto>();
		logger.info(" Start  CompLoadToTransServices- > getAllCompLoadToTrans ");
		CompLoadToTransResponse logiwareRespnse = new CompLoadToTransResponse();
		try {

			lCompanyLoadToTransDto =compLoadToTransLogicImpl.getAllCompLoadToTrans();
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setlCompanyLoadToTransDtos(lCompanyLoadToTransDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompLoadToTransServices- > getAllCompLoadToTrans", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in CompLoadToTransServices- > getAllCompLoadToTrans", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompLoadToTransServices- > getAllCompLoadToTrans");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	@GET
	@Path("/getCompLoadToTransById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCompLoadToTransById(@PathParam("id")Integer id) {
		logger.info(" Start  CompLoadToTransServices- > getCompLoadToTransById ");
		CompLoadToTransResponse logiwareRespnse = new CompLoadToTransResponse();
		CompanyLoadToTransDto companyLoadToTransDto = null;
		try {
			companyLoadToTransDto=compLoadToTransLogicImpl.getCompLoadToTransById(id);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setCompanyLoadToTransDto(companyLoadToTransDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompLoadToTransServices- > getCompLoadToTransById ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompLoadToTransServices- > getCompLoadToTransById ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompLoadToTransServices- > getCompLoadToTransById ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
	@POST
	@Path("/addCompLoadToTrans")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response addCompLoadToTrans(CompanyLoadToTransDto companyLoadDetailDto) {

		logger.info(" Start  CompLoadToTransServices- > addCompLoadToTrans ");
		CompLoadToTransResponse logiwareRespnse = new CompLoadToTransResponse();
		Boolean result=false;
		try {
			result=compLoadToTransLogicImpl.addCompLoadToTrans(companyLoadDetailDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setResult(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompLoadToTransServices- > addCompLoadToTrans", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompLoadToTransServices- > addCompLoadToTrans", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompLoadToTransServices- > addCompLoadToTrans");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	
	@POST
	@Path("/editCompLoadToTrans")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response editCompLoadToTrans(CompanyLoadToTransDto companyLoadToTransDto) {

		logger.info(" Start  CompLoadToTransServices- > editCompLoadToTrans ");
		CompLoadToTransResponse logiwareRespnse = new CompLoadToTransResponse();
		Boolean result=false;
		try {
			result=compLoadToTransLogicImpl.editCompLoadToTrans(companyLoadToTransDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setResult(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompLoadToTransServices- > editCompLoadToTrans ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompLoadToTransServices- > editCompLoadToTrans ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompLoadToTransServices- > editCompLoadToTrans ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	@GET
	@Path("/deleteCompLoadToTrans/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteCompLoadToTrans(@PathParam("id")Integer id) {

		logger.info(" Start  CompLoadToTransServices- > deleteCompLoadDtl ");
		CompLoadToTransResponse logiwareRespnse = new CompLoadToTransResponse();
		Boolean result=false;
		try {
			result=compLoadToTransLogicImpl.deleteCompLoadToTrans(id);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setResult(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompLoadToTransServices- > deleteCompLoadToTrans ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompLoadToTransServices- > deleteCompLoadToTrans ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompLoadToTransServices- > deleteCompLoadToTrans ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
}
