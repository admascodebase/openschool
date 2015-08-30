/**
 * 
 */
package com.admas.logiware.dao;

import java.util.List;

import com.admas.logiware.dto.Customer;
import com.admas.logiware.exception.LogiwareExceptionHandler;

/**
 * @author Raj
 *
 */
public interface CustomerDao {
	
	public Customer getCustomer(Integer id)throws LogiwareExceptionHandler;
	public List<com.admas.logiware.jpa.Customer> getAllCustomer()throws LogiwareExceptionHandler;
	public Boolean deleteCustomer(Integer id)throws LogiwareExceptionHandler;
	public Boolean addCustomer(Customer customer)throws LogiwareExceptionHandler;

}
