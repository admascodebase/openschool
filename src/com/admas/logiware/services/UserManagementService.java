package com.admas.logiware.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.admas.logiware.dto.IUserManagementDao;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.ngemp.sms.services.SmsService;

@Path("/userMgtServices")
public class UserManagementService {

		static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
				.getLogger(SmsService.class);
		private static IUserManagementDao uaserIUserManagementDao;

		@GET
		@Path("/login/{username}/{password}")
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Response login(@PathParam("username") String userName,
				@PathParam("password") String password) {
			Boolean result = false;
			logger.info(" start  UserManagementService- > login");
			try {			
				result = uaserIUserManagementDao.login(userName, password);
			} catch (LogiwareExceptionHandler e) {
				logger.error("Error in UserManagementService- > login",e);
			} catch (Exception e) {
				logger.error("Error in UserManagementService- > login",e);
			}
			logger.info(" end  UserManagementService- > login");
			return Response.status(200).entity(result).build();

		}
}
