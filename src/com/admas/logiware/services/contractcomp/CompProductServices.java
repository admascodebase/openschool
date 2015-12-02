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

import com.admas.logiware.dto.CompProductDto;
import com.admas.logiware.dto.response.CompProductResponse;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.logic.contractcomp.CompProductLogic;
import com.admas.logiware.util.LogiWareConstants;

/**
 * @author 
 *  
 */

@Path("/compProductServices")
public class CompProductServices {

	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(CompProductServices.class);

	private static CompProductLogic compProductLogicImpl;

	
	


	public static CompProductLogic getCompProductLogicImpl() {
		return compProductLogicImpl;
	}


	public static void setCompProductLogicImpl(CompProductLogic compProductLogicImpl) {
		CompProductServices.compProductLogicImpl = compProductLogicImpl;
	}


	@GET
	@Path("/getAllCompProduct/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllComProduct(@PathParam("id")Integer id){
		List<CompProductDto> lCompProduct= new ArrayList<CompProductDto>();
		logger.info(" Start  CompProductServices- > getAllComProduct ");
		CompProductResponse logiwareRespnse = new CompProductResponse();
		try {

			lCompProduct =compProductLogicImpl.getAllCompProduct(id);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setlProductDto(lCompProduct);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompProductServices- > getAllComProduct", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in CompProductServices- > getAllComProduct", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompProductServices- > getAllComProduct");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	@GET
	@Path("/getCompProductById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCompProductById(@PathParam("id")Integer id) {
		logger.info(" Start  CompProductServices- > getCompProductById ");
		CompProductResponse logiwareRespnse = new CompProductResponse();
		CompProductDto companyProductDto = null;
		try {
			companyProductDto=compProductLogicImpl.getCompProductById(id);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setCompProductDto(companyProductDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompProductServices- > getCompProductById ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompProductServices- > getCompProductById ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompProductServices- > getCompProductById ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
	@POST
	@Path("/addCompProduct")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response addCompProduct(CompProductDto CompProductDto) {

		logger.info(" Start  CompProductServices- > addCompProduct ");
		CompProductResponse logiwareRespnse = new CompProductResponse();
		Boolean result=false;
		try {
			result=compProductLogicImpl.addCompProduct(CompProductDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setResult(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompProductServices- > addCompProduct", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompProductServices- > addCompProduct", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompProductServices- > addCompProduct");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	
	@POST
	@Path("/editCompProduct")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response editCompProduct(CompProductDto CompProductDto) {

		logger.info(" Start  CompProductServices- > editCompProduct ");
		CompProductResponse logiwareRespnse = new CompProductResponse();
		Boolean result=false;
		try {
			result=compProductLogicImpl.editCompProduct(CompProductDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setResult(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompProductServices- > editCompProduct ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompProductServices- > editCompProduct ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompProductServices- > editCompProduct ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	@GET
	@Path("/deleteCompProduct/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteCompRoute(@PathParam("id")Integer id) {

		logger.info(" Start  CompProductServices- > deleteCompRoute ");
		CompProductResponse logiwareRespnse = new CompProductResponse();
		Boolean result=false;
		try {
			result=compProductLogicImpl.deleteCompProduct(id);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setResult(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in CompProductServices- > deleteCompRoute ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in CompProductServices- > deleteCompRoute ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  CompProductServices- > deleteCompRoute ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
}
