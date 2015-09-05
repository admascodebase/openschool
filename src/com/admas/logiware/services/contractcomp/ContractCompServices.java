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

import com.admas.logiware.dto.ContractCompDto;
import com.admas.logiware.dto.LogiwareRespnse;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.logic.contractcomp.ContractCompLogic;
import com.admas.logiware.util.LogiWareConstants;

/**
 * @author Admas
 * 
 */

@Path("/contractCompServices")
public class ContractCompServices {

	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(ContractCompServices.class);

	private static ContractCompLogic contractCompLogic;

	/**
	 * @return the contractCompLogic
	 */
	public static ContractCompLogic getContractCompLogic() {
		return contractCompLogic;
	}

	/**
	 * @param contractCompLogic the contractCompLogic to set
	 */
	public static void setContractCompLogic(ContractCompLogic contractCompLogic) {
		ContractCompServices.contractCompLogic = contractCompLogic;
	}
	
	/*
	 * Employee Services
	 * */
	@GET
	@Path("/getAllContractComp")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllContractComp(){
		List<ContractCompDto> lContractComp= new ArrayList<ContractCompDto>();
		logger.info(" Start  ContractCompServices- > getAllContractComp ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {

			lContractComp =contractCompLogic.getAllContractComp();
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(lContractComp);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in ContractCompServices- > getAllContractComp", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in ContractCompServices- > getAllContractComp", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  ContractCompServices- > getAllContractComp");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	@GET
	@Path("/getContractCompById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getContractCompById(@PathParam("id")Integer contractCompId) {
		logger.info(" Start  ContractCompServices- > getContractCompById ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		ContractCompDto contractCompDto = null;
		try {
			contractCompDto=contractCompLogic.getContractCompById(contractCompId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setContractCompDto(contractCompDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in ContractCompServices- > getContractCompById ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in ContractCompServices- > getContractCompById ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  ContractCompServices- > getContractCompById ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
	@POST
	@Path("/addContractComp")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response addContractComp(ContractCompDto contractCompDto) {

		logger.info(" Start  ContractCompServices- > addContractComp ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=contractCompLogic.addContractComp(contractCompDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in ContractCompServices- > addContractComp", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in ContractCompServices- > addContractComp", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  ContractCompServices- > addContractComp");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	
	@POST
	@Path("/editContractComp")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response editEmployee(ContractCompDto contractCompDto) {

		logger.info(" Start  ContractCompServices- > editContractComp ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=contractCompLogic.editContractComp(contractCompDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in ContractCompServices- > editContractComp ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in ContractCompServices- > editContractComp ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  ContractCompServices- > editContractComp ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	

	
	@GET
	@Path("/deleteContractComp/{contractCompId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteContractComp(@PathParam("contractCompId")Integer contractCompId) {

		logger.info(" Start  ContractCompServices- > deleteContractComp ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=contractCompLogic.deleteContractComp(contractCompId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in ContractCompServices- > deleteContractComp ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in ContractCompServices- > deleteContractComp ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  ContractCompServices- > deleteContractComp ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
}
