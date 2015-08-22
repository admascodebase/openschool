/**
 * 
 */
package com.admas.logiware.logic;

import java.util.List;

import com.admas.logiware.dto.Customer;

/**
 * @author Raj
 *
 */
public interface CustomerLogic {
	
	public Customer getCustomer(Integer id);
	public List<Customer> getAllCustomer();

}
