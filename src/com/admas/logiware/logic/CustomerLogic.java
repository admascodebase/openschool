/**
 * 
 */
package com.admas.logiware.logic;

import java.util.List;

import com.admas.logiware.dto.Customer;
import com.admas.logiware.exception.LogiwareExceptionHandler;

/**
 * @author Raj
 *
 */
public interface CustomerLogic {
	
	public Customer getCustomer(Integer id)throws LogiwareExceptionHandler;
	public List<Customer> getAllCustomer()throws LogiwareExceptionHandler;
	public Boolean deleteCustomer(Integer id)throws LogiwareExceptionHandler,Exception;

}
