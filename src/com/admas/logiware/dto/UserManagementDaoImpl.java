package com.admas.logiware.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.CustCompanyEmployee;
import com.admas.logiware.jpa.UserDetails;

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
			UserDetails userDetails = isValid(userName, password);
			if(userDetails != null){
						
				
			}else{
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.INVALID_CREDENTIALS);
			}
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

	private UserDetails isValid(String userName, String password) {

		TypedQuery<UserDetails> userQuery;
		List<UserDetails> userList = new ArrayList<UserDetails>();
		try {
			
//			userQuery = entityManager.createQuery("SELECT u FROM com.admas.logiware.jpa.UserDetails u", com.admas.logiware.jpa.UserDetails.class);
//			userList = userQuery.getResultList();
			
			CriteriaBuilder cb=entityManager.getCriteriaBuilder();
			CriteriaQuery<UserDetails> criteriaQuery=cb.createQuery(com.admas.logiware.jpa.UserDetails.class);
			Root<UserDetails> root=criteriaQuery.from(UserDetails.class);
			criteriaQuery.select(root);
//			criteriaQuery.where());
			TypedQuery<UserDetails> typedQuery=entityManager.createQuery(criteriaQuery);
			userList=typedQuery.getResultList();
			System.out.println(userList.get(0));
			
		} 
		catch(HibernateException he){
			he.printStackTrace();		}
		
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return userList.get(0);
	}
	
	
	

}
