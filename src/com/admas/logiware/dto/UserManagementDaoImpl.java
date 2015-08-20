package com.admas.logiware.dto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;

@Repository
public class UserManagementDaoImpl implements IUserManagementDao {

	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(UserManagementDaoImpl.class);

	/**
	 * @param entityManager
	 *            the entityManager to set
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		UserManagementDaoImpl.entityManager = entityManager;
	}

	public UserManagementDaoImpl() {
		super();
	}

	@Override
	public Boolean login(String userName, String password) throws LogiwareExceptionHandler {
		try{
		if( (userName!=null && !userName.isEmpty()) || (password!=null && !password.isEmpty())){
			
		}else{
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.INVALID_INPUT);
		}
		}catch(LogiwareExceptionHandler ex){
			throw ex;
		}catch(Exception e){
			
		}
		return true;
	}
	
	
	

}
