/**
 * 
 */
package com.admas.logiware.services.masters;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.admas.logiware.dto.CityDto;
import com.admas.logiware.dto.LogiwareRespnse;
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
}
