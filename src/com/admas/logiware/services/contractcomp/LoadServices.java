/**
 * 
 */
package com.admas.logiware.services.contractcomp;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.admas.logiware.dto.LoadDto;
import com.admas.logiware.dto.LogiwareRespnse;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.logic.contractcomp.LoadLogic;
import com.admas.logiware.util.LogiWareConstants;

@Path("/loadServices")
public class LoadServices {

	
	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(ContractCompServices.class);

	private static LoadLogic loadLogic;

	
	
	/**
	 * @return the loadLogic
	 */
	public static LoadLogic getLoadLogic() {
		return loadLogic;
	}



	/**
	 * @param loadLogic the loadLogic to set
	 */
	public static void setLoadLogic(LoadLogic loadLogic) {
		LoadServices.loadLogic = loadLogic;
	}



	@GET
	@Path("/getAllLoadEntry/{contractCompId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllLoadEntry(@PathParam("contractCompId")Integer contractCompId){
		List<LoadDto> lLoadDto= new ArrayList<LoadDto>();
		logger.info(" Start  loadServices- > getAllLoadEntry ");
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {

			lLoadDto =loadLogic.getAllLoadEntry(contractCompId);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(lLoadDto);
		} catch (LogiwareExceptionHandler e) {
			logger.error("Error in loadServices- > getAllLoadEntry", e);
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in loadServices- > getAllLoadEntry", e);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
					.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		logger.info(" end  loadServices- > getAllLoadEntry");
		return Response.status(200).entity(logiwareRespnse).build();
	}

}
