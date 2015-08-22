package com.admas.logiware.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.admas.logiware.dao.CustCompEmployee;
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
	public com.admas.logiware.dao.UserDetails login(String userName, String password)
			throws LogiwareExceptionHandler {
		com.admas.logiware.dao.UserDetails userDetailsDto=new com.admas.logiware.dao.UserDetails();
		try {
			if ((userName != null && !userName.isEmpty())
					|| (password != null && !password.isEmpty())) {
				UserDetails userDetails = isValid(userName, password);
				CustCompanyEmployee companyEmployee = null;
				if (userDetails != null) {
					companyEmployee = getEmployeeById(userDetails
							.getEmpId());				
					
					
				} else {
					throw new LogiwareExceptionHandler(
							LogiwareServiceErrors.INVALID_CREDENTIALS);
				}
				if(companyEmployee!=null){
					
					CustCompEmployee employeeDto=new CustCompEmployee();
					
					employeeDto.setAddress(companyEmployee.getAddress());
					employeeDto.setBranchId(companyEmployee.getBranchId());
					employeeDto.setCompId(companyEmployee.getCompId());
					employeeDto.setContactNo(companyEmployee.getContactNo());
					employeeDto.setGender(companyEmployee.getGender());
					employeeDto.setId(companyEmployee.getId());
					employeeDto.setIsSysAcc(companyEmployee.getIsSysAcc());
					employeeDto.setName(companyEmployee.getName());
					employeeDto.setPan(companyEmployee.getPan());
					employeeDto.setSalary(companyEmployee.getSalary());
					employeeDto.setSalaryType(companyEmployee.getSalaryType());
					
					userDetailsDto.setCustCompEmployee(employeeDto);
					userDetailsDto.setLastLogin(userDetails.getLastLoginTime());
					userDetailsDto.setPassword(userDetails.getPasword());
					userDetailsDto.setUserName(userDetails.getUserName());
				}else{
					throw new LogiwareExceptionHandler(
							LogiwareServiceErrors.GENERIC_EXCEPTION);					
				}
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.INVALID_INPUT);
			}
		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (Exception e) {

		}
		return userDetailsDto;
	}

	private UserDetails isValid(String userName, String password) {

		TypedQuery<UserDetails> userQuery;
		List<UserDetails> userList = new ArrayList<UserDetails>();
		try {

			// userQuery =
			// entityManager.createQuery("SELECT u FROM com.admas.logiware.jpa.UserDetails u",
			// com.admas.logiware.jpa.UserDetails.class);
			// userList = userQuery.getResultList();

			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<UserDetails> criteriaQuery = cb
					.createQuery(com.admas.logiware.jpa.UserDetails.class);
			Root<UserDetails> root = criteriaQuery.from(UserDetails.class);
			criteriaQuery.select(root);
			Predicate p1 = cb.and(cb.equal(root.get("userName"), userName));
			Predicate p2 = cb.and(cb.equal(root.get("pasword"), password));
			criteriaQuery.where(p1);
			criteriaQuery.where(p2);
			TypedQuery<UserDetails> typedQuery = entityManager
					.createQuery(criteriaQuery);
			userList = typedQuery.getResultList();
			System.out.println(userList.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList.get(0);
	}

	private CustCompanyEmployee getEmployeeById(Integer empId) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<CustCompanyEmployee> criteriaQuery = cb
				.createQuery(com.admas.logiware.jpa.CustCompanyEmployee.class);
		Root<CustCompanyEmployee> root = criteriaQuery
				.from(CustCompanyEmployee.class);
		criteriaQuery.select(root);
		Predicate employeeId = cb.equal(root.get("id"), empId);

		criteriaQuery.where(employeeId);

		TypedQuery<CustCompanyEmployee> typedQuery = entityManager
				.createQuery(criteriaQuery);
		List<CustCompanyEmployee> lEmployee = typedQuery.getResultList();
		System.out.println("employee-" + lEmployee.get(0));
		return lEmployee.get(0);
	}

}
