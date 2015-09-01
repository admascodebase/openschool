package com.admas.logiware.dao.masters;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admas.logiware.dto.CityDto;
import com.admas.logiware.dto.CompanyDto;
import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.dto.TransportTypeDtlDto;
import com.admas.logiware.dto.TransportTypeDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.City;
import com.admas.logiware.jpa.Company;
import com.admas.logiware.jpa.Employee;
import com.admas.logiware.jpa.TransportType;
import com.admas.logiware.jpa.TransportTypeDtl;

public class MastersDaoImpl implements MastersDao {

	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(MastersDaoImpl.class);

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		MastersDaoImpl.entityManager = entityManager;
	}

	@Override
	public List<City> getAllCity() throws LogiwareExceptionHandler {

		List<City> lCities = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<City> criteriaQuery = criteriaBuilder
					.createQuery(City.class);
			Root<City> cityJpa = criteriaQuery.from(City.class);
			criteriaQuery.select(cityJpa);
			TypedQuery<City> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lCities = typedQuery.getResultList();

			if (lCities != null && lCities.size() != 0) {
				return lCities;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_CITY_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > getAllCity ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addCity(CityDto cityDto) throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			City city = new City();
			city.setName(cityDto.getName());
			city.setStateId(cityDto.getStateId());
			city.setDelFlag('N');
			entityManager.persist(city);
			entityManager.flush();

			if (city.getId() != null || city.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > getAllCity ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editCity(CityDto cityDto) throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			City city = new City();
			city.setId(cityDto.getId());
			city.setName(cityDto.getName());
			city.setStateId(cityDto.getStateId());
			city.setDelFlag('N');
			entityManager.merge(city);
			entityManager.flush();
			if (city.getId() != null || city.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > editCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			// logger.error("Exception Error in MastersDaoImpl - > editCity ",
			// e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteCity(CityDto cityDto) throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE City SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", cityDto.getId());
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > deleteCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			// logger.error(
			// "Exception Error in UserManagementDaoImpl - > deleteCity", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	public List<Company> getAllCompany() throws LogiwareExceptionHandler {

		List<Company> lCompanies = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Company> criteriaQuery = criteriaBuilder
					.createQuery(Company.class);
			Root<Company> companyJpa = criteriaQuery.from(Company.class);
			Predicate notDeleted=criteriaBuilder.equal(companyJpa.get("delFlag"), 'N');
			criteriaQuery.select(companyJpa);
			criteriaQuery.where(notDeleted);
			TypedQuery<Company> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lCompanies = typedQuery.getResultList();

			if (lCompanies != null && lCompanies.size() != 0) {
				return lCompanies;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_COMPANY_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllCompany",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > getAllCompany ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addcompany(CompanyDto companyDto)
			throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			Company company = new Company();
			company.setName(companyDto.getName());
			company.setAddress(companyDto.getAddress());
			company.setContactNo1(companyDto.getContactNo1());
			company.setContactNo2(companyDto.getContactNo2());
			company.setCustId(companyDto.getCustId());
			company.setEmailId1(companyDto.getEmailId1());
			company.setEmailId2(companyDto.getEmailId2());
			company.setLogo(companyDto.getLogo());
			company.setPanNo(companyDto.getPanNo());
			company.setTanNo(companyDto.getTanNo());
			company.setTagLine(companyDto.getTagLine());
			company.setDelFlag('N');
			entityManager.persist(company);
			entityManager.flush();

			if (company.getId() != null || company.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > addCompany",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			// logger.error(
			// "Exception Error in UserManagementDaoImpl - > addCompany",
			// e);

			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editCompany(CompanyDto companyDto)
			throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			Company company = new Company();
			company.setId(companyDto.getId());
			company.setName(companyDto.getName());
			company.setAddress(companyDto.getAddress());
			company.setContactNo1(companyDto.getContactNo1());
			company.setContactNo2(companyDto.getContactNo2());
			company.setCustId(companyDto.getCustId());
			company.setEmailId1(companyDto.getEmailId1());
			company.setEmailId2(companyDto.getEmailId2());
			company.setLogo(companyDto.getLogo());
			company.setPanNo(companyDto.getPanNo());
			company.setTanNo(companyDto.getTanNo());
			company.setTagLine(companyDto.getTagLine());

			entityManager.merge(company);
			entityManager.flush();
			if (company.getId() != null || company.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > editCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			// logger.error("Exception Error in MastersDaoImpl - > editCity ",
			// e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteCompany(Integer companyId)
			throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE Company SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", companyId);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > deleteCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > deleteCity",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	public Company getCompanyById(Integer companyId)
			throws LogiwareExceptionHandler {

		Company company = null;
		try {

			TypedQuery<Company> companyQuery = entityManager.createQuery(
					"SELECT c FROM Company c WHERE id = :id", Company.class);
			companyQuery.setParameter("id", companyId);
			company = companyQuery.getSingleResult();

			if (company != null) {
				return company;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_COMPANY_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getCompanyById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > getCompanyById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public City getCityById(Integer cityId) throws LogiwareExceptionHandler {

		City city = null;
		try {

			TypedQuery<City> cityQuery = entityManager.createQuery(
					"SELECT c FROM City c WHERE id = :id", City.class);
			cityQuery.setParameter("id", cityId);
			city = cityQuery.getSingleResult();

			if (city != null) {
				return city;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_CITY_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getCityById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > getCityById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Employee> getAllEmployee() throws LogiwareExceptionHandler {

		List<Employee> lEmployees = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Employee> criteriaQuery = criteriaBuilder
					.createQuery(Employee.class);
			Root<Employee> employeeJpa = criteriaQuery.from(Employee.class);
			Predicate notDeleted=criteriaBuilder.equal(employeeJpa.get("delFlag"), 'N');
			criteriaQuery.select(employeeJpa);
			criteriaQuery.where(notDeleted);
			TypedQuery<Employee> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lEmployees = typedQuery.getResultList();

			if (lEmployees != null && lEmployees.size() != 0) {
				return lEmployees;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_EMPLOYEE_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllEmployee",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > getAllEmployee ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}

	}

	@Override
	public Employee getEmployeeById(Integer employeeId)
			throws LogiwareExceptionHandler {

		Employee employee = null;
		try {

			TypedQuery<Employee> cityQuery = entityManager.createQuery(
					"SELECT e FROM Employee e WHERE id = :id", Employee.class);
			cityQuery.setParameter("id", employeeId);
			employee = cityQuery.getSingleResult();

			if (employee != null) {
				return employee;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_EMPLOYEE_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getEmployeeById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > getEmployeeById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addEmployee(EmployeeDto employeeDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Employee employee = new Employee();
			employee.setAddress(employeeDto.getAddress());
			employee.setBranchId(employeeDto.getBranchId());
			employee.setCompId(employeeDto.getCompId());
			employee.setContactNo(employeeDto.getContactNo());
			employee.setGender(employeeDto.getGender());
			// employee.setId(employeeDto.getId());
			employee.setIsSysAcc(employeeDto.getIsSysAcc());
			employee.setName(employeeDto.getName());
			employee.setPan(employeeDto.getPan());
			employee.setSalary(employeeDto.getSalary());
			employee.setSalaryType(employeeDto.getSalaryType());
			employee.setDelFlg(employeeDto.getDelFlag());

			entityManager.persist(employee);
			entityManager.flush();
			if (employee.getId() != null || employee.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > addEmployee",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > addEmployee",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editEmployee(EmployeeDto employeeDto)
			throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			Employee employee = new Employee();
			
			employee.setAddress(employeeDto.getAddress());
			employee.setBranchId(employeeDto.getBranchId());
			employee.setCompId(employeeDto.getCompId());
			employee.setContactNo(employeeDto.getContactNo());
			employee.setGender(employeeDto.getGender());
			 employee.setId(employeeDto.getId());
			employee.setIsSysAcc(employeeDto.getIsSysAcc());
			employee.setName(employeeDto.getName());
			employee.setPan(employeeDto.getPan());
			employee.setSalary(employeeDto.getSalary());
			employee.setSalaryType(employeeDto.getSalaryType());
			employee.setDelFlg(employeeDto.getDelFlag());
			
			entityManager.merge(employee);
			entityManager.flush();
			
			if (employee.getId() != null || employee.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > editEmployee",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			// logger.error("Exception Error in MastersDaoImpl - > editCity ",
			// e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteEmployee(Integer employeeId)
			throws LogiwareExceptionHandler {
		
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE Employee SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", employeeId);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > deleteEmployee",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			// logger.error(
			// "Exception Error in UserManagementDaoImpl - > deleteCity", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addaddTransportType(TransportTypeDto transportTypeDto)
			throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			TransportType transportType = new TransportType();
			transportType.setCompId(transportTypeDto.getCompId());
			transportType.setName(transportTypeDto.getName());
			transportType.setDescription(transportTypeDto.getDescription());
			entityManager.persist(transportType);
			entityManager.flush();

			if (transportType.getId() != null || transportType.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > addaddTransportType",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > addaddTransportType ",e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<TransportType> getAllTransportType()
			throws LogiwareExceptionHandler {

		List<TransportType> lTransportTypes = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<TransportType> criteriaQuery = criteriaBuilder
					.createQuery(TransportType.class);
			Root<TransportType> transportTypeJpa = criteriaQuery.from(TransportType.class);
			criteriaQuery.select(transportTypeJpa);
			TypedQuery<TransportType> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lTransportTypes = typedQuery.getResultList();

			if (lTransportTypes != null && lTransportTypes.size() != 0) {
				return lTransportTypes;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_CITY_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > getAllCity ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	
	}

	@Override
	public TransportType getTransportTypeById(Integer transportTypeId)
			throws LogiwareExceptionHandler {		
		
		TransportType transportType = null;
		try {

			TypedQuery<TransportType> transportTypeQuery = entityManager.createQuery(
					"SELECT t FROM TransportType t WHERE id = :id", TransportType.class);
			transportTypeQuery.setParameter("id", transportTypeId);
			transportType = transportTypeQuery.getSingleResult();

			if (transportType != null) {
				return transportType;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_TRANSPORTTYPE_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getTransportTypeById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > getTransportTypeById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editTransportType(TransportTypeDto transportTypeDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			TransportType transportType = new TransportType();
			transportType.setCompId(transportTypeDto.getCompId());
			transportType.setDescription(transportTypeDto.getDescription());
			transportType.setId(transportTypeDto.getId());
			transportType.setName(transportTypeDto.getName());
			entityManager.merge(transportType);
			entityManager.flush();
			
			if (transportType.getId() != null || transportType.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > editTransportType",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error("Exception Error in MastersDaoImpl - > editTransportType ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteTransportType(Integer transportTypeId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE TransportType SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", transportTypeId);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > deleteTransportType",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error( "Exception Error in MastersDaoImpl - > deleteTransportType", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	// start transport type details dao 
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addaddTransportTypeDtl(TransportTypeDtlDto transportTypeDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			TransportTypeDtl transportTypeDtl = new TransportTypeDtl();
			transportTypeDtl = transportTypeDtl._toJpa(transportTypeDto);			
			entityManager.persist(transportTypeDtl);
			entityManager.flush();
			
			if (transportTypeDtl.getId() != null || transportTypeDtl.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > addaddTransportTypeDtl",he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > addaddTransportTypeDtl ",e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<TransportTypeDtl> getAllTransportTypeDtl()
			throws LogiwareExceptionHandler {
		List<TransportTypeDtl> lTransportTypeDtls = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<TransportTypeDtl> criteriaQuery = criteriaBuilder
					.createQuery(TransportTypeDtl.class);
			Root<TransportTypeDtl> transportTypeJpa = criteriaQuery.from(TransportTypeDtl.class);
			criteriaQuery.select(transportTypeJpa);
			TypedQuery<TransportTypeDtl> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lTransportTypeDtls = typedQuery.getResultList();

			if (lTransportTypeDtls != null && lTransportTypeDtls.size() != 0) {
				return lTransportTypeDtls;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_TRANSPORTTYPE_DTL_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllTransportTypeDtl",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > getAllTransportTypeDtl ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	public TransportTypeDtl getTransportTypeDtlById(Integer transportTypeId)
			throws LogiwareExceptionHandler {
		TransportTypeDtl transportTypeDtls = null;
		try {

			TypedQuery<TransportTypeDtl> transportTypeQuery = entityManager.createQuery(
					"SELECT t FROM TransportTypeDtl t WHERE id = :id", TransportTypeDtl.class);
			transportTypeQuery.setParameter("id", transportTypeId);
			transportTypeDtls = transportTypeQuery.getSingleResult();

			if (transportTypeDtls != null) {
				return transportTypeDtls;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_TRANSPORTTYPE_DTL_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getTransportTypeDtlById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in UserManagementDaoImpl - > getTransportTypeDtlById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editTransportTypeDtl(TransportTypeDtlDto transportTypeDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			TransportTypeDtl transportTypeDtl = new TransportTypeDtl();
			entityManager.merge(transportTypeDtl._toJpa(transportTypeDto));
			entityManager.flush();
			
			if (transportTypeDtl.getId() != null || transportTypeDtl.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > editTransportTypeDtl",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error("Exception Error in MastersDaoImpl - > editTransportTypeDtl ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteTransportTypeDtl(Integer transportTypeDtlId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE TransportTypeDtlDto SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", transportTypeDtlId);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > deleteTransportTypeDtl",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error( "Exception Error in MastersDaoImpl - > deleteTransportTypeDtl", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}
	
	// end transport type details dao 
}
