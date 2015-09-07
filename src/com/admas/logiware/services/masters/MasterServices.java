/**
 * 
 */
package com.admas.logiware.services.masters;

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

import com.admas.logiware.dto.CityDto;
import com.admas.logiware.dto.CompanyBranchDto;
import com.admas.logiware.dto.CompanyDto;
import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.dto.LogiwareRespnse;
import com.admas.logiware.dto.SettingsDto;
import com.admas.logiware.dto.StateDto;
import com.admas.logiware.dto.TransportTypeDtlDto;
import com.admas.logiware.dto.TransportTypeDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.logic.masters.MastersLogic;
import com.admas.logiware.util.LogiWareConstants;

/**
 * @author Admas
 * 
 */

@Path("/masterServices")
public class MasterServices {

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
		MasterServices.mastersLogic = mastersLogic;
	}

	@GET
	@Path("/getAllCity")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllCity() {

		List<CityDto> lCities = new ArrayList<CityDto>();
		logger.info(" Start  MasterService- > getAllCity ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {

			lCities = mastersLogic.getAllCity();
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(lCities);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > getAllCity", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > getAllCity", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > getAllCity");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	@POST
	@Path("/addCity")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response addCity(CityDto cityDto) {

		logger.info(" Start  MasterService- > addCity ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.addCity(cityDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > addCity", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > addCity", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > addCity");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	
	@POST
	@Path("/editCity")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response editCity(CityDto cityDto) {

		logger.info(" Start  MasterService- > editCity ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.editCity(cityDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > editCity ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > editCity ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > editCity ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	

	
	@POST
	@Path("/deleteCity")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response deleteCity(CityDto cityDto) {

		logger.info(" Start  MasterService- > deleteCity ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.deleteCity(cityDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > deleteCity ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > deleteCity ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > deleteCity ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	@GET
	@Path("/getAllCompany")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllCompany(){
		List<CompanyDto> lCompanies = new ArrayList<CompanyDto>();
		logger.info(" Start  MasterService- > getAllCompany ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {

			lCompanies = mastersLogic.getAllcompany();
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(lCompanies);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > getAllCompany", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > getAllCompany", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > getAllCompany");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	
	@POST
	@Path("/addCompany")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response addCompany(CompanyDto companyDto) {

		logger.info(" Start  MasterService- > addCompany ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.addCompany(companyDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > addCompany", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > addCompany", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > addCompany");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	
	
	@POST
	@Path("/editCompany")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response editCompany(CompanyDto companyDto) {

		logger.info(" Start  MasterService- > editCompany ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.editCompany(companyDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > editCompany ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > editCompany ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > editCompany ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	@GET
	@Path("/deleteCompany/{companyId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteCompany(@PathParam("companyId")Integer companyId) {

		logger.info(" Start  MasterService- > deleteCompany ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.deleteCompany(companyId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > deleteCompany ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > deleteCity ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > deleteCompany ");
		return Response.status(200).entity(logiwareRespnse).build();
	}


	

	@GET
	@Path("/getCompanyById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCompanyById(@PathParam("id")Integer companyId) {
		logger.info(" Start  MasterService- > getCompanyById ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		CompanyDto companyDto=null;
		try {
			companyDto=mastersLogic.getCompanyById(companyId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setCompanyDto(companyDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > getCompanyById ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > getCompanyById ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > getCompanyById ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	@GET
	@Path("/getCityById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCityById(@PathParam("id")Integer cityId) {
		logger.info(" Start  MasterService- > getCityById ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		CityDto cityDto=null;
		try {
			cityDto=mastersLogic.getCityById(cityId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(cityDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > getCityById ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > getCityById ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > getCityById ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	/*
	 * Employee Services
	 * */
	@GET
	@Path("/getAllEmployee")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllEmployee(){
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
	@Path("/getEmployeeById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getEmployeeById(@PathParam("id")Integer employeeId) {
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
	@Path("/addEmployee")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response addEmployee(EmployeeDto employeeDto) {

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
	@Path("/editEmployee")
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
	@Path("/deleteEmployee/{employeeId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteEmployee(@PathParam("employeeId")Integer employeeId) {

		logger.info(" Start  MasterService- > deleteEmployee ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.deleteEmployee(employeeId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > deleteEmployee ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > deleteEmployee ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > deleteEmployee ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	//Transport type services start 
	
	@POST
	@Path("/addTransportType")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response addTransportType(TransportTypeDto transportTypeDto) {

		logger.info(" Start  MasterService- > addTransportType Method");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.addTransportType(transportTypeDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > addTransportType Method", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > addCity", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > addTransportType Method");
		return Response.status(200).entity(logiwareRespnse).build();
	}
		
	

	@GET
	@Path("/getAllTransportType")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllTransportType() {

		List<TransportTypeDto> lTransportTypes = new ArrayList<TransportTypeDto>();
		logger.info(" Start  MasterService- > getAllTransportType Method");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {

			lTransportTypes = mastersLogic.getAllTransportType();
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(lTransportTypes);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > getAllTransportType", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > getAllTransportType", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > getAllTransportType");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	@GET
	@Path("/getTransportTypeById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTransportTypeById(@PathParam("id")Integer TransportTypeId) {
		logger.info(" Start  MasterService- > getTransportTypeById ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		TransportTypeDto transportTypeDto = null;
		try {
			transportTypeDto = mastersLogic.getTransportTypeById(TransportTypeId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setTransportTypeDto(transportTypeDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > getTransportTypeById ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > getTransportTypeById ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > getTransportTypeById ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	@POST
	@Path("/editTransportType")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response editTransportType(TransportTypeDto transportTypeDto) {

		logger.info(" Start  MasterService- > editTransportType ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.editTransportType(transportTypeDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > editTransportType ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > editTransportType ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > editTransportType ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	

	
	@GET
	@Path("/deleteTransportType/{transportTypeId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteTransportType(@PathParam("transportTypeId")Integer transportTypeId) {

		logger.info(" Start  MasterService- > deleteTransportType ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.deleteTransportType(transportTypeId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > deleteTransportType ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > deleteTransportType ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > deleteTransportType ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	//Transport type services End 
	
	//Transport type details services Start 
	
	@POST
	@Path("/addTransportTypeDtl")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response addTransportTypeDtl(TransportTypeDtlDto transportTypeDtlDto) {

		logger.info(" Start  MasterService- > addTransportTypeDtl Method");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.addTransportTypeDtl(transportTypeDtlDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > addTransportTypeDtl Method", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > addTransportTypeDtl", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > addTransportTypeDtl Method");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	@GET
	@Path("/getAllTransportTypeDtl/{transportTypeId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllTransportTypeDtl(@PathParam("transportTypeId")Integer transportTypeId) {

		List<TransportTypeDtlDto> lTransportTypesDtl = new ArrayList<TransportTypeDtlDto>();
		logger.info(" Start  MasterService- > getAllTransportTypeDtl Method");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {
			lTransportTypesDtl = mastersLogic.getAllTransportTypeDtl(transportTypeId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(lTransportTypesDtl);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > getAllTransportTypeDtl", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > getAllTransportTypeDtl", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > getAllTransportType");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	@GET
	@Path("/getTransportTypeDtlById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTransportTypeDtlById(@PathParam("id")Integer TransportTypeId) {
		logger.info(" Start  MasterService- > getTransportTypeDtlById ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		TransportTypeDtlDto transportTypeDtlDto = null;
		try {
			transportTypeDtlDto = mastersLogic.getTransportTypeDtlById(TransportTypeId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(transportTypeDtlDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > getTransportTypeDtlById ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > getTransportTypeDtlById ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > getTransportTypeDtlById ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	@POST
	@Path("/editTransportTypeDtl")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response editTransportTypeDtl(TransportTypeDtlDto transportTypeDtlDto) {

		logger.info(" Start  MasterService- > editTransportTypeDtl ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.editTransportTypeDtl(transportTypeDtlDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > editTransportTypeDtl ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > editTransportTypeDtl ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > editTransportTypeDtl ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	@GET
	@Path("/deleteTransportTypeDtl/{transportTypeDtlId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response editTransportTypeDtl(@PathParam("transportTypeDtlId")Integer transportTypeDtlId) {

		logger.info(" Start  MasterService- > editTransportTypeDtl ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=mastersLogic.deleteTransportTypeDtl(transportTypeDtlId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in MasterService- > editTransportTypeDtl ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in MasterService- > editTransportTypeDtl ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  MasterService- > editTransportTypeDtl ");
		return Response.status(200).entity(logiwareRespnse).build();
	}
		
	// end transport type details services
	
	
	//start branch details services  
	
		@POST
		@Path("/addBranch")
		@Produces({ MediaType.APPLICATION_JSON })
		@Consumes({MediaType.APPLICATION_JSON })
		public Response addBranch(CompanyBranchDto companyBranchDto) {

			logger.info(" Start  MasterService- > addBranch Method");
			LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
			Boolean result=false;
			try {
				result=mastersLogic.addBranch(companyBranchDto);
				logiwareRespnse.setCode(LogiWareConstants.SUCESS);
				logiwareRespnse.setData(result);
			} catch (LogiwareExceptionHandler e) {
				logger.error("Error in MasterService- > addBranch Method", e);
				logiwareRespnse.setCode(e.getErrorCode());
				logiwareRespnse.setDescription(e.getDescription());
			} catch (Exception e) {
				logger.error("Error in MasterService- > addBranch", e);
				logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
						.getErrorCode());
				logiwareRespnse
						.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
								.getErrorDescription());
			}
			logger.info(" end  MasterService- > addBranch Method");
			return Response.status(200).entity(logiwareRespnse).build();
		}
		
		@GET
		@Path("/getAllBranch")
		@Produces({ MediaType.APPLICATION_JSON })
		public Response getAllBranch() {

			List<CompanyBranchDto> lBranch = new ArrayList<CompanyBranchDto>();
			logger.info(" Start  MasterService- > getAllBranch Method");
			LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
			try {

				lBranch = mastersLogic.getAllBranch();
				logiwareRespnse.setCode(LogiWareConstants.SUCESS);
				logiwareRespnse.setData(lBranch);
			} catch (LogiwareExceptionHandler e) {
				logger.error("Error in MasterService- > getAllBranch", e);
				logiwareRespnse.setCode(e.getErrorCode());
				logiwareRespnse.setDescription(e.getDescription());
			} catch (Exception e) {
				logger.error("Error in MasterService- > getAllBranch", e);
				logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
						.getErrorCode());
				logiwareRespnse
						.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
								.getErrorDescription());
			}
			logger.info(" end  MasterService- > getAllBranch");
			return Response.status(200).entity(logiwareRespnse).build();
		}

		
		@GET
		@Path("/getBranchById/{id}")
		@Produces({ MediaType.APPLICATION_JSON })
		public Response getBranchById(@PathParam("id")Integer branchId) {
			logger.info(" Start  MasterService- > getBranchById ");
			LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
			CompanyBranchDto companyBranchDto = null;
			try {
				companyBranchDto = mastersLogic.getBranchById(branchId);
				logiwareRespnse.setCode(LogiWareConstants.SUCESS);
				logiwareRespnse.setCompanyBranchDto(companyBranchDto);
			} catch (LogiwareExceptionHandler e) {
				logger.error("Error in MasterService- > getBranchById ", e);
				logiwareRespnse.setCode(e.getErrorCode());
				logiwareRespnse.setDescription(e.getDescription());
			} catch (Exception e) {
				logger.error("Error in MasterService- > getBranchById ", e);
				logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
						.getErrorCode());
				logiwareRespnse
						.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
								.getErrorDescription());
			}
			logger.info(" end  MasterService- > getBranchById ");
			return Response.status(200).entity(logiwareRespnse).build();
		}
		
		@POST
		@Path("/editBranch")
		@Produces({ MediaType.APPLICATION_JSON })
		@Consumes({MediaType.APPLICATION_JSON })
		public Response editBranch(CompanyBranchDto companyBranchDto) {

			logger.info(" Start  MasterService- > editBranch ");
			LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
			Boolean result=false;
			try {
				result=mastersLogic.editBranch(companyBranchDto);
				logiwareRespnse.setCode(LogiWareConstants.SUCESS);
				logiwareRespnse.setData(result);
			} catch (LogiwareExceptionHandler e) {
				logger.error("Error in MasterService- > editBranch ", e);
				logiwareRespnse.setCode(e.getErrorCode());
				logiwareRespnse.setDescription(e.getDescription());
			} catch (Exception e) {
				logger.error("Error in MasterService- > editBranch ", e);
				logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
						.getErrorCode());
				logiwareRespnse
						.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
								.getErrorDescription());
			}
			logger.info(" end  MasterService- > editBranch ");
			return Response.status(200).entity(logiwareRespnse).build();
		}
		
		@GET
		@Path("/deleteBranch/{branchId}")
		@Produces({ MediaType.APPLICATION_JSON })
		public Response deleteBranch(@PathParam("branchId")Integer branchId) {

			logger.info(" Start  MasterService- > deleteBranch ");
			LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
			Boolean result=false;
			try {
				result=mastersLogic.deleteBranch(branchId);
				logiwareRespnse.setCode(LogiWareConstants.SUCESS);
				logiwareRespnse.setData(result);
			} catch (LogiwareExceptionHandler e) {
				logger.error("Error in MasterService- > deleteBranch ", e);
				logiwareRespnse.setCode(e.getErrorCode());
				logiwareRespnse.setDescription(e.getDescription());
			} catch (Exception e) {
				logger.error("Error in MasterService- > deleteBranch ", e);
				logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
						.getErrorCode());
				logiwareRespnse
						.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
								.getErrorDescription());
			}
			logger.info(" end  MasterService- > deleteBranch ");
			return Response.status(200).entity(logiwareRespnse).build();
		}
			
		// end branch details services
	
		//start of state services
		
		@GET
		@Path("/getAllState")
		@Produces({ MediaType.APPLICATION_JSON })
		public Response getAllState() {
			List<StateDto> lState = new ArrayList<StateDto>();
			logger.info(" Start  MasterService- > getAllBranch Method");
			LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
			try {
				lState = mastersLogic.getAllState();
				logiwareRespnse.setCode(LogiWareConstants.SUCESS);
				logiwareRespnse.setData(lState);
			} catch (LogiwareExceptionHandler e) {
				logger.error("Error in MasterService- > getAllBranch", e);
				logiwareRespnse.setCode(e.getErrorCode());
				logiwareRespnse.setDescription(e.getDescription());
			} catch (Exception e) {
				logger.error("Error in MasterService- > getAllBranch", e);
				logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
						.getErrorCode());
				logiwareRespnse
						.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
								.getErrorDescription());
			}
			logger.info(" end  MasterService- > getAllBranch");
			return Response.status(200).entity(logiwareRespnse).build();
		}
		
		@GET
		@Path("/getSettingByType/{compId}/{type}")
		@Produces({ MediaType.APPLICATION_JSON })
		public Response getSettingByType(@PathParam("compId")Integer compId,@PathParam("type")String type) {
			SettingsDto setting = new SettingsDto();
			logger.info(" Start  MasterService- > getSettingByType Method");
			LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
			try {
				setting = mastersLogic.getSettingByType(compId,type);
				logiwareRespnse.setCode(LogiWareConstants.SUCESS);
				logiwareRespnse.setData(setting);
			} catch (LogiwareExceptionHandler e) {
				logger.error("Error in MasterService- > getSettingByType", e);
				logiwareRespnse.setCode(e.getErrorCode());
				logiwareRespnse.setDescription(e.getDescription());
			} catch (Exception e) {
				logger.error("Error in MasterService- > getSettingByType", e);
				logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
						.getErrorCode());
				logiwareRespnse
						.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
								.getErrorDescription());
			}
			logger.info(" end  MasterService- > getSettingByType");
			return Response.status(200).entity(logiwareRespnse).build();
		}
		
		
}
