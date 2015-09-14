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

import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.dto.LogiwareRespnse;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.logic.masters.MastersLogic;
import com.admas.logiware.services.masters.MasterServices;
import com.admas.logiware.util.LogiWareConstants;

/**
 * @author Raj
 * 
 */
@Path("/transOwnerServices")
public class TransOwnerServices {
	
	
	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(MasterServices.class);

	private static MastersLogic mastersLogic;

	/**
	 * @return the mastersLogic
	 */
	public static MastersLogic getMastersLogic() {
		return mastersLogic;
	}

	/**
	 * @param mastersLogic
	 *            the mastersLogic to set
	 */
	public static void setMastersLogic(MastersLogic mastersLogic) {
		TransOwnerServices.mastersLogic = mastersLogic;
	}
	
	
	/*
	 * Employee Services
	 * */
	@GET
	@Path("/getTransOwner")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllTransOwner(){
		List<EmployeeDto> lEmployees= new ArrayList<EmployeeDto>();
		logger.info(" Start  MasterService- > getAllEmployee ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {

			lEmployees = mastersLogic.getAllEmployee();
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(lEmployees);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > getAllEmployee", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > getAllEmployee", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > getAllEmployee");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	@GET
	@Path("/getTransOwnerById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTransOwnerById(@PathParam("id")Integer employeeId) {
		logger.info(" Start  MasterService- > getEmployeeById ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		EmployeeDto employeeDto = null;
		try {
			employeeDto=mastersLogic.getEmployeeById(employeeId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setEmployeeDto(employeeDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > getEmployeeById ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > getEmployeeById ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > getEmployeeById ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
	@POST
	@Path("/addTransOwner")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response addTransOwner(EmployeeDto employeeDto) {

		logger.info(" Start  MasterService- > addEmployee ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.addEmployee(employeeDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > addEmployee", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > addEmployee", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > addEmployee");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	
	@POST
	@Path("/editTransOwner")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response editEmployee(EmployeeDto employeeDto) {

		logger.info(" Start  MasterService- > editEmployee ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.editEmployee(employeeDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > editEmployee ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > editEmployee ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > editEmployee ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	

	
	@GET
	@Path("/deleteTransOwner{transId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteTransOwner(@PathParam("employeeId")Integer employeeId) {

		logger.info(" Start  MasterService- > deleteTransOwner ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.deleteEmployee(employeeId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > deleteTransOwner ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > deleteTransOwner ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > deleteTransOwner ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	}
