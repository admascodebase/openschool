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

import com.admas.logiware.dto.CompanyLoadDetailDto;
import com.admas.logiware.dto.response.CompLoadDtlResponse;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.logic.contractcomp.CompLoadDtlLogic;
import com.admas.logiware.util.LogiWareConstants;

@Path("/compLoaddtlServices")
public class CompLoadDtlServices {

	
	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(ContractCompServices.class);

	private static CompLoadDtlLogic compLoadDtlLogic;

	/**
	 * @return the compLoadDtlLogic
	 */
	public static CompLoadDtlLogic getCompLoadDtlLogic() {
		return compLoadDtlLogic;
	}

	/**
	 * @param compLoadDtlLogic the compLoadDtlLogic to set
	 */
	public static void setCompLoadDtlLogic(CompLoadDtlLogic compLoadDtlLogic) {
		CompLoadDtlServices.compLoadDtlLogic = compLoadDtlLogic;
	}

	
	@GET
	@Path("/getAllCompLoadDtl/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllComLoadDtl(@PathParam("id")Integer id){
		List<CompanyLoadDetailDto> lCompanyLoadDetailDtos= new ArrayList<CompanyLoadDetailDto>();
		logger.info(" Start  CompLoadDtlServices- > getAllComLoadDtl ");
		CompLoadDtlResponse logiwareRespnse = new CompLoadDtlResponse();
		try {

			lCompanyLoadDetailDtos =compLoadDtlLogic.getAllCompLoadDtl(id);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setlCompanyLoadDetailDtos(lCompanyLoadDetailDtos);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompLoadDtlServices- > getAllComLoadDtl", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in CompLoadDtlServices- > getAllComLoadDtl", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompLoadDtlServices- > getAllComLoadDtl");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	@GET
	@Path("/getCompLoadDtlById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCompLoadDtlById(@PathParam("id")Integer id) {
		logger.info(" Start  CompLoadDtlServices- > getCompProductById ");
		CompLoadDtlResponse logiwareRespnse = new CompLoadDtlResponse();
		CompanyLoadDetailDto companyLoadDetailDto = null;
		try {
			companyLoadDetailDto=compLoadDtlLogic.getCompLoadDtlById(id);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setCompanyLoadDetailDto(companyLoadDetailDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompLoadDtlServices- > getCompProductById ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompLoadDtlServices- > getCompProductById ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompLoadDtlServices- > getCompProductById ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
	@POST
	@Path("/addCompLoadDtl")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response addCompLoadDtl(CompanyLoadDetailDto companyLoadDetailDto) {

		logger.info(" Start  CompLoadDtlServices- > addCompLoadDtl ");
		CompLoadDtlResponse logiwareRespnse = new CompLoadDtlResponse();
		Boolean result=false;
		try {
			result=compLoadDtlLogic.addCompLoadDtl(companyLoadDetailDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setResult(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompLoadDtlServices- > addCompLoadDtl", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompLoadDtlServices- > addCompLoadDtl", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompLoadDtlServices- > addCompLoadDtl");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	
	@POST
	@Path("/editCompLoadDtl")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response editCompLoadDtl(CompanyLoadDetailDto companyLoadDetailDto) {

		logger.info(" Start  CompLoadDtlServices- > editCompLoadDtl ");
		CompLoadDtlResponse logiwareRespnse = new CompLoadDtlResponse();
		Boolean result=false;
		try {
			result=compLoadDtlLogic.editCompLoadDtl(companyLoadDetailDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setResult(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompLoadDtlServices- > editCompLoadDtl ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompLoadDtlServices- > editCompLoadDtl ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompLoadDtlServices- > editCompLoadDtl ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	@GET
	@Path("/deleteCompLoadDtl/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteCompLoadDtl(@PathParam("id")Integer id) {

		logger.info(" Start  CompLoadDtlServices- > deleteCompLoadDtl ");
		CompLoadDtlResponse logiwareRespnse = new CompLoadDtlResponse();
		Boolean result=false;
		try {
			result=compLoadDtlLogic.deleteCompLoadDtl(id);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setResult(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompLoadDtlServices- > deleteCompLoadDtl ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompLoadDtlServices- > deleteCompLoadDtl ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompLoadDtlServices- > deleteCompLoadDtl ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
}
