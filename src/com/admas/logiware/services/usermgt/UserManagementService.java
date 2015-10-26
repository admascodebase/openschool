package com.admas.logiware.services.usermgt;

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
import com.admas.logiware.dto.UserDetails;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.logic.usermgt.UserManagementLogicImpl;
import com.admas.logiware.util.LogiWareConstants;

@Path("/userMgtServices")
public class UserManagementService {

	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(UserManagementService.class);

	private static UserManagementLogicImpl userManagementLogicImpl;

	@GET
	@Path("/login/{username}/{password}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response login(@PathParam("username") String userName,
			@PathParam("password") String password) {
		logger.info(" start  UserManagementService- > login");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		UserDetails userDetailsDto = null;
		try {
			userDetailsDto = userManagementLogicImpl.login(userName, password);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setUerDetailsDto(userDetailsDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in UserManagementService- > login", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in UserManagementService- > login", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  UserManagementService- > login");
		return Response.status(200).entity(logiwareRespnse).build();

	}

	@POST
	@Path("/saveChangePassword")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response saveChangePassword(UserDetails userDetails) {

		logger.info(" Start  UserManagementService- > saveChangePassword ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=userManagementLogicImpl.saveChangePassword(userDetails);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in UserManagementService- > saveChangePassword ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in UserManagementService- > saveChangePassword ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  UserManagementService- > saveChangePassword ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	
	@GET
	@Path("/authenticateEmail/{mobileNumber}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response authenticateEmail(@PathParam("mobileNumber")String mobileNumber) {
		logger.info(" start  UserManagementService- > authenticateEmail");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		EmployeeDto  employeeDto = null;
		try {
			employeeDto = userManagementLogicImpl.authenticateEmail(mobileNumber);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setEmployeeDto(employeeDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in UserManagementService- > login", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in UserManagementService- > login", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  UserManagementService- > login");
		return Response.status(200).entity(logiwareRespnse).build();

	}



	@POST
	@Path("/resetPassword")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	public Response resetPassword(EmployeeDto employeeDto) {

		logger.info(" Start  UserManagementService- > saveChangePassword ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		Boolean result=false;
		try {
			result=userManagementLogicImpl.resetPassword(employeeDto);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in UserManagementService- > saveChangePassword ", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			logger.error("Error in UserManagementService- > saveChangePassword ", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  UserManagementService- > saveChangePassword ");
		return Response.status(200).entity(logiwareRespnse).build();
	}

	
	/**
	 * @return the userManagementLogicImpl
	 */
	public UserManagementLogicImpl getUserManagementLogicImpl() {
		return userManagementLogicImpl;
	}

	/**
	 * @param userManagementLogicImpl
	 *            the userManagementLogicImpl to set
	 */
	public void setUserManagementLogicImpl(
			UserManagementLogicImpl userManagementLogicImpl) {
		this.userManagementLogicImpl = userManagementLogicImpl;
	}

}
