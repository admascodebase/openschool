package com.admas.logiware.services.usermgt;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
			logiwareRespnse.setData(userDetailsDto);
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
