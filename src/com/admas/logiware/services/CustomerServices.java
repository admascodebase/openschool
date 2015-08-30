/**
 * 
 */
package com.admas.logiware.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.admas.logiware.dto.Customer;
import com.admas.logiware.dto.LogiwareRespnse;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.logic.CustomerLogic;
import com.admas.logiware.util.LogiWareConstants;

/**
 * @author Raj
 * 
 */
@Path("/customerServices")
public class CustomerServices {
	
	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(CustomerServices.class);

	private static CustomerLogic customerLogic;// =new CustomerLogicImpl();

	@GET
	@Path("/getCustomerById/{customerId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCustomerById(@PathParam("customerId") Integer id) {
		Customer customer = null;
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try {
			customer = customerLogic.getCustomer(id);
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(customer);
		} catch (LogiwareExceptionHandler e) {
			
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
		}
		catch (Exception e) {
		}
		return Response.status(200).entity(logiwareRespnse).build();

	}

	@GET
	@Path("/getAllCustomer")
	@Produces({ MediaType.APPLICATION_JSON})
	public Response getAllCustomer(){

		List<Customer>list=null;
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try{
			list=customerLogic.getAllCustomer();
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(list);
		}
		catch(LogiwareExceptionHandler handler){
			logger.error("Error in CustomerService- > getAllCustomer", handler);
			logiwareRespnse.setCode(handler.getErrorCode());
			logiwareRespnse.setDescription(handler.getDescription());
		}
		catch(Exception handler){
			logger.error("Error in CustomerService- > getAllCustomer", handler);
			logiwareRespnse.setCode(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorCode());
			logiwareRespnse
			.setDescription(LogiwareServiceErrors.GENERIC_EXCEPTION
					.getErrorDescription());
		}
		return Response.status(200).entity(logiwareRespnse).build();
	}
	
	@GET
	@Path("deleteCustomer/{customerId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response deleteCustomer(@PathParam("customerId")Integer id){
		
		Boolean result=false;
		LogiwareRespnse logiwareRespnse = new LogiwareRespnse();
		try{
			result=customerLogic.deleteCustomer(id);
			if(result){
			logiwareRespnse.setCode(LogiWareConstants.SUCESS);
			logiwareRespnse.setData(result);
			}
		}
		catch(LogiwareExceptionHandler e){
			
			logiwareRespnse.setCode(e.getErrorCode());
			logiwareRespnse.setDescription(e.getDescription());
			
		}
		catch(Exception exception){
			logger.info(""+exception);
		}
		return Response.status(200).entity(logiwareRespnse).build();
		
	}
	
	@POST
	@Path("/addCustomer")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addCustomer(Customer customer){
		
		Boolean result =false;
		LogiwareRespnse logiwareRespnse=new LogiwareRespnse();
		try{
			result=customerLogic.addCustomer(customer);
				logiwareRespnse.setCode(LogiWareConstants.SUCESS);
				logiwareRespnse.setData(result);
		}catch(LogiwareExceptionHandler le){
			logiwareRespnse.setCode(le.getErrorCode());
			logiwareRespnse.setDescription(le.getDescription());
		}
		return Response.status(200).entity(logiwareRespnse).build();
		
	}

	/**
	 * @return the customerLogic
	 */
	public CustomerLogic getCustomerLogic() {
		return customerLogic;
	}

	/**
	 * @param customerLogic
	 *            the customerLogic to set
	 */
	public void setCustomerLogic(CustomerLogic customerLogic) {
		this.customerLogic = customerLogic;
	}

}
