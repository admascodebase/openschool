/**
 * 
 */
package com.admas.logiware.util;

import java.io.Serializable;
import java.util.List;

import com.admas.logiware.dto.Customer;

/**
 * @author Raj
 *
 */
public class RestResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int status;
	private List<Customer>customersList;

	/**
	 * 
	 */
	public RestResponse() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Customer> getCustomersList() {
		return customersList;
	}

	public void setCustomersList(List<Customer> customersList) {
		this.customersList = customersList;
	}
	

}
