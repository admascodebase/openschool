/**
 * 
 */
package com.admas.logiware.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.admas.logiware.dto.Customer;
import com.admas.logiware.logic.CustomerLogic;
import com.admas.logiware.logic.CustomerLogicImpl;

/**
 * @author Raj
 *
 */
@Path("/customerServices")
public class CustomerServices {

	
	private CustomerLogic customerLogic=new CustomerLogicImpl();
	
	@GET
	@Path("/getCustomerById/{customerId}")
	@Produces({ MediaType.APPLICATION_JSON})
	public Response getCustomerById(@PathParam("customerId") Integer id) {
		Customer customer = new Customer();
		 try {
			 customer = customerLogic.getCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(customer).build();

	}

}
